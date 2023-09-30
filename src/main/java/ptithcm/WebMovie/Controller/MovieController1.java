package ptithcm.WebMovie.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ptithcm.WebMovie.Email.EmailService;
import ptithcm.WebMovie.Email.GenrateCode;
import ptithcm.WebMovie.Model.MovieRequest;
import ptithcm.WebMovie.Model.Role;
import ptithcm.WebMovie.Model.User;
import ptithcm.WebMovie.Repository.UserRepository;
import ptithcm.WebMovie.Service.MovieCollectionService;
import ptithcm.WebMovie.Service.MovieRequestService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class MovieController1 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private EmailService emailService;

    private MovieCollectionService movieCollectionService;
    private MovieRequestService movieRequestService;

    public MovieController1(MovieCollectionService movieCollectionService, MovieRequestService movieRequestService) {
        this.movieCollectionService = movieCollectionService;
        this.movieRequestService = movieRequestService;
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginPerform(@ModelAttribute User user, Model model){
        User userLogin = new User();
        userLogin = userRepository.findByuserNameAndPassword(user.getUserName(), user.getPassword());
        if(userLogin != null){
            session.setAttribute("user", userLogin);
            return "redirect:/home";
        } else {
            model.addAttribute("errorLogin", "Wrong password or user name");
        }
        return "login";
    }

    @GetMapping("/create-account-admin")
    public String crtAccAd(Model model){
        model.addAttribute("user", new User());
        return "CreateAccountAdmin";
    }
    @PostMapping("/create-account-admin")
    public String createAccountAdmin(@ModelAttribute User user, Model model, @RequestParam("imageInput") MultipartFile file){
        Role role = new Role();
        role.setRoleId(1);
        user.setRole(role);
        if(userRepository.findByuserName(user.getUserName()) == null){
            try {
                String uploadDir = "src/main/resources/static/img/user";
                String fileName = "";
                if(file == null){
                    fileName = "default.jpg";
                } else fileName = user.getUserName() + ".jpg";
                Path filePath = Paths.get(uploadDir, fileName);
                Files.copy(file.getInputStream(), filePath);
                user.setAvatar(fileName);
                userRepository.save(user);

            } catch (Exception e){
                e.printStackTrace();
            }
            return "redirect:/create-account-admin";
        } else {
            model.addAttribute("errorAddAccAdmin", "User name already exists in the system!");
            model.addAttribute("user", user);
            return "CreateAccountAdmin";
        }
    }
    @PostMapping("/register")
    public String registerPerform(@ModelAttribute User user, Model model, @RequestParam("imageInput") MultipartFile file){
        Role role = new Role();
        role.setRoleId(2);
        user.setRole(role);
        if(userRepository.findByuserName(user.getUserName()) == null){
            try {
                String uploadDir = "src/main/resources/static/img/user";
                String fileName = "";
                if(file == null){
                    fileName = "default.jpg";
                } else fileName = user.getUserName() + ".jpg";
                Path filePath = Paths.get(uploadDir, fileName);
                Files.copy(file.getInputStream(), filePath);
                user.setAvatar(fileName);
                userRepository.save(user);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            model.addAttribute("errorRegister", "User name already exists in the system!");
            return "login";
        }
        return "redirect:/login";
    }

    @GetMapping("/change-pass")
    public String changePass(){
        return "ChangePassword";
    }
    @PostMapping("/change-pass")
    public String changePass(HttpServletRequest request, Model model){
        User user = (User) session.getAttribute("user");
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("newPassword");
        if(userRepository.findByuserNameAndPassword(user.getUserName(), oldPass) == null){
            //nếu là null thì mật khẩu nhập chưa khớp
            model.addAttribute("errorOldPass", "You entered your old password incorrectly");
            System.out.println("loi mk");
        } else {
            //nếu khác null là nhập khớp mật khẩu cũ, tiến hành đi đổi pass
            userRepository.changePass(newPass, user.getUserName());
        }
        return "ChangePassword";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("userNameF") String userName, @RequestParam("emailF") String email){
        GenrateCode genrateCode = new GenrateCode();
        String newPass = genrateCode.generateCode();
        emailService.sendEmail(email, "Thư cấp lại mật khẩu", "Mật khẩu mới của bạn là: " + newPass);
        userRepository.resetPass(newPass, userName, email);
        return "redirect:/login";
    }

    @GetMapping("/user-information")
    public String userInformation(Model model){
        User userInSession = (User) session.getAttribute("user");
        User user = userRepository.findByuserName(userInSession.getUserName());
        System.out.println(user.getAvatar());
        model.addAttribute("user", user);
        model.addAttribute("img", user.getAvatar());
        return "UserInformation";
    }

    @PostMapping("/user-information")
    public String userInformation(@ModelAttribute User user, @RequestParam("imageInput") MultipartFile file){
        User user1 = (User) session.getAttribute("user");
        if(file != null && !file.isEmpty()){ // chọn file mới
            try {
                String oldImg = userRepository.findByuserName(user1.getUserName()).getAvatar();
                String uploadDir = "src/main/resources/static/img/user";
                Path filePath;
                //xóa ảnh cũ
                if(oldImg == null || oldImg.compareTo("default.jpg") != 0){
                    filePath = Paths.get(uploadDir, oldImg);
                    System.out.println(filePath);
                    Files.delete(filePath);
                }
                //ảnh mới
                LocalDateTime currentDateTime = LocalDateTime.now();
                System.out.println(currentDateTime);
                String fileName = user.getUserName() + "_" +
                        currentDateTime.getHour() + "h" +
                        currentDateTime.getMinute() + "m" +
                        currentDateTime.getSecond() + "s" + ".jpg";
                filePath = Paths.get(uploadDir, fileName);
                Files.copy(file.getInputStream(), filePath);
                user.setAvatar(fileName);
                userRepository.updateInformation(user.getName(), user.getEmail(), user.getUserName(), user.getAvatar());
            } catch (Exception e){
                e.printStackTrace();
            }
        } else{
            userRepository.updateInformation(user.getName(), user.getEmail(), user.getUserName(), user1.getAvatar());
        }
        return "redirect:/user-information";
    }

    @GetMapping("/my-collection")
    public String myCollection(Model model){
        User user = (User) session.getAttribute("user");
        List<Map<String, ?>> myCollection = movieCollectionService.findMyCollection(user.getUserId());
        List<MovieRequest> topRankMovie = movieRequestService.getTopView(5);
        model.addAttribute("myCollection", myCollection);
        model.addAttribute("topRankMV", topRankMovie);
        return "my-collection";
    }
}

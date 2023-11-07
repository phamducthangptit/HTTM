package ptithcm.WebMovie.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ptithcm.WebMovie.Email.EmailService;
import ptithcm.WebMovie.Email.GenrateCode;
import ptithcm.WebMovie.Model.Category;
import ptithcm.WebMovie.Model.MovieRequest;
import ptithcm.WebMovie.Model.Role;
import ptithcm.WebMovie.Model.User;
import ptithcm.WebMovie.Repository.CategoryRepository;
import ptithcm.WebMovie.Repository.UserRepository;
import ptithcm.WebMovie.Security.MovieUserDetails;
import ptithcm.WebMovie.Service.MovieCollectionService;
import ptithcm.WebMovie.Service.MovieRequestService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
public class MovieController1 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    @Autowired
    private CategoryRepository categoryRepository;
    
    private MovieCollectionService movieCollectionService;


    private MovieRequestService movieRequestService;
    public MovieController1(MovieCollectionService movieCollectionService, MovieRequestService movieRequestService) {
        this.movieCollectionService = movieCollectionService;
        this.movieRequestService = movieRequestService;
    }
    @GetMapping("/login")
    public String login(@AuthenticationPrincipal MovieUserDetails logged, Model model){
        if(logged != null){
            System.out.println("nhan ve user");
            return "redirect:/home";
        }
        System.out.println("loi");
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("listCategory",categories);
        return "login";
    }

    @GetMapping("/create-account-admin")
    public String crtAccAd(Model model){
        model.addAttribute("user", new User());
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("listCategory",categories);
        return "CreateAccountAdmin";
    }
    @PostMapping("/create-account-admin")
    public String createAccountAdmin(@ModelAttribute User user, Model model, @RequestParam("imageInput") MultipartFile file){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        Role role = new Role();
        role.setRoleId(1);
        user.setRole(role);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("listCategory",categories);

        if(userRepository.findByuserName(user.getUserName()) == null){
            try {
                String uploadDir = "src/main/resources/static/img/user";
                String fileName = "";
                LocalDateTime currentDateTime = LocalDateTime.now();
                if(file == null || file.isEmpty()){
                    fileName = "default.png";
                } else {
                    fileName = user.getUserName() + "_" +
                            currentDateTime.getHour() + "h" +
                            currentDateTime.getMinute() + "m" +
                            currentDateTime.getSecond() + "s" + ".png";
                    System.out.println(fileName);
                    Path filePath = Paths.get(uploadDir, fileName);
                    Files.copy(file.getInputStream(), filePath);
                }
                user.setAvatar(fileName);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
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
    public String registerPerform(Model model, @RequestParam("imageInput") MultipartFile file, HttpServletRequest request){
        Role role = new Role();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        role.setRoleId(2);
        String userName = request.getParameter("userName");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String password = passwordEncoder.encode(request.getParameter("password"));
        User user = new User();
        user.setUserName(userName);
        user.setName(fullName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        if(userRepository.findByuserName(user.getUserName()) == null){ // chưa có user name trong hệ thống
            try {
                LocalDateTime currentDateTime = LocalDateTime.now();
                String uploadDir = "src/main/resources/static/img/user";
                String fileName = "";
                System.out.println(file.getResource());
                if(file == null || file.isEmpty()){
                    fileName = "default.png";
                } else {
                    fileName = user.getUserName() + "_" +
                            currentDateTime.getHour() + "h" +
                            currentDateTime.getMinute() + "m" +
                            currentDateTime.getSecond() + "s" + ".png";
                    System.out.println(fileName);
                    Path filePath = Paths.get(uploadDir, fileName);
                    Files.copy(file.getInputStream(), filePath);
                }
                user.setAvatar(fileName);
                userRepository.save(user);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            model.addAttribute("errorRegister", "User name already exists in the system!");
            System.out.println("xuat hien loi khi dki");
            return "login";
        }
        return "redirect:/login";
    }

    @GetMapping("/change-pass")
    public String changePass(){
        return "ChangePassword";
    }
    @PostMapping("/change-pass")
    public String changePass(@AuthenticationPrincipal MovieUserDetails user, HttpServletRequest request, Model model){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        String oldPass = request.getParameter("oldPassword");
        String newPass = passwordEncoder.encode(request.getParameter("newPassword"));
        System.out.println(userRepository.findPasswordByUserName(user.getUsername()));
        if(!passwordEncoder.matches(oldPass, userRepository.findPasswordByUserName(user.getUsername()))){
            //nếu là null thì mật khẩu nhập chưa khớp
            model.addAttribute("errorOldPass", "You entered your old password incorrectly");
            System.out.println("loi mk");
        } else {
            //nếu khác null là nhập khớp mật khẩu cũ, tiến hành đi đổi pass
            userRepository.changePass(newPass, user.getUsername());
        }
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("listCategory",categories);

        return "ChangePassword";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("userNameF") String userName, @RequestParam("emailF") String email){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
        GenrateCode genrateCode = new GenrateCode();
        String newPassSendUser = genrateCode.generateCode();
        String newPass = passwordEncoder.encode(newPassSendUser);
        emailService.sendEmail(email, "Thư cấp lại mật khẩu", "Mật khẩu mới của bạn là: " + newPassSendUser);
        userRepository.resetPass(newPass, userName, email);
        return "redirect:/login";
    }

    @GetMapping("/user-information")
    public String userInformation(@AuthenticationPrincipal MovieUserDetails userInSession, Model model){
        User user = userRepository.findByuserName(userInSession.getUsername());
        System.out.println(user.getAvatar());
        model.addAttribute("user", user);
        model.addAttribute("img", user.getAvatar());

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("listCategory",categories);
        return "UserInformation";
    }

    @PostMapping("/user-information")
    public String userInformation(@AuthenticationPrincipal MovieUserDetails user1, @ModelAttribute User user, @RequestParam("imageInput") MultipartFile file){
        if(file != null && !file.isEmpty()){ // chọn file mới
            try {
                String oldImg = userRepository.findByuserName(user1.getUsername()).getAvatar();
                String uploadDir = "src/main/resources/static/img/user";
                Path filePath;
                //xóa ảnh cũ
                if(oldImg == null || oldImg.compareTo("default.png") != 0){
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
                        currentDateTime.getSecond() + "s" + ".png";
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
    public String myCollection(@AuthenticationPrincipal MovieUserDetails user, Model model){
        List<Map<String, ?>> myCollection = movieCollectionService.findMyCollection(user.getUserId());
        List<MovieRequest> topRankMovie = movieRequestService.getTopView(0,5);
        model.addAttribute("myCollection", myCollection);
        model.addAttribute("topRankMV", topRankMovie);


        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("listCategory",categories);
        return "my-collection";
    }

    @GetMapping("/list-movie")
    public String listMovie(Model model){
        List<Map<String, ?>> listMovie = movieCollectionService.selectListMovie();
        List<MovieRequest> topRankMovie = movieRequestService.getTopView(0,5);
        model.addAttribute("listMovie", listMovie);
        model.addAttribute("topRankMV", topRankMovie);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("listCategory",categories);
        return "list-movie";
    }
}

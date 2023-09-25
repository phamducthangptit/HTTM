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
import ptithcm.WebMovie.Email.EmailService;
import ptithcm.WebMovie.Email.GenrateCode;
import ptithcm.WebMovie.Model.Role;
import ptithcm.WebMovie.Model.User;
import ptithcm.WebMovie.Repository.UserRepository;

@Controller
public class MovieController1 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;
    @Autowired
    private EmailService emailService;
    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginPerform(@ModelAttribute User user){
        User userLogin = new User();
        userLogin = userRepository.findByuserNameAndPassword(user.getUserName(), user.getPassword());
        if(userLogin != null){
            session.setAttribute("user", userLogin);
            return "redirect:/index";
        } else System.out.println("....");
        return "login";
    }

    @GetMapping("/logout")
    public String logOut(){
        session.invalidate();
        return "redirect:/index";
    }
    @GetMapping("/create-account-admin")
    public String crtAccAd(Model model){
        model.addAttribute("user", new User());
        return "CreateAccountAdmin";
    }
    @PostMapping("/create-account-admin")
    public String createAccountAdmin(@ModelAttribute User user, Model model){
        Role role = new Role();
        role.setRoleId(1);
        user.setRole(role);
        if(userRepository.findByuserName(user.getUserName()) == null){
            userRepository.save(user);
            return "redirect:/CreateAccountAdmin";
        } else {
            model.addAttribute("errorAddAccAdmin", "User name already exists in the system!");
            model.addAttribute("user", user);
            return "CreateAccountAdmin";
        }
    }
    @PostMapping("/register")
    public String registerPerform(@ModelAttribute User user, Model model){
        Role role = new Role();
        role.setRoleId(2);
        user.setRole(role);
        if(userRepository.findByuserName(user.getUserName()) == null){
            userRepository.save(user);
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
        model.addAttribute("user", user);
        return "UserInformation";
    }

    @PostMapping("/user-information")
    public String userInformation(@ModelAttribute User user){
        userRepository.updateInformation(user.getName(), user.getEmail(), user.getUserName());
        return "redirect:/user-information";
    }
}

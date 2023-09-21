package ptithcm.WebMovie.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ptithcm.WebMovie.Model.User;
import ptithcm.WebMovie.Repository.UserRepository;

@Controller
public class MovieController1 {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginPerform(@ModelAttribute User user){
        User userLogin = new User();
        userLogin = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if(userLogin != null){
            session.setAttribute("user", userLogin);
        } else System.out.println("....");
        return "login";
    }
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}

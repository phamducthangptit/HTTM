package ptithcm.WebMovie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController1 {
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}

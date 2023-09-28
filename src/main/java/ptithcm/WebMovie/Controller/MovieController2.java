package ptithcm.WebMovie.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ptithcm.WebMovie.Email.EmailService;
import ptithcm.WebMovie.Email.GenrateCode;
import ptithcm.WebMovie.Model.User;
import ptithcm.WebMovie.Repository.MovieCollectionRepository;
import ptithcm.WebMovie.Repository.UserRepository;
import ptithcm.WebMovie.Service.MovieCollectionService;

@RestController
public class MovieController2 {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;

    private MovieCollectionService movieCollectionService;

    @Autowired
    private HttpSession session;

    public MovieController2(MovieCollectionService movieCollectionService) {
        super();
        this.movieCollectionService = movieCollectionService;
    }

    @PostMapping("/send-email")
    @ResponseBody
    public String send(@RequestParam("userNameF") String userName, @RequestParam("emailF") String email){
        if(userRepository.findByuserNameAndEmail(userName, email) != null){// tim ra duoc user
            GenrateCode genrateCode = new GenrateCode();
            String code = genrateCode.generateCode();
            emailService.sendEmail(email, "Thư lấy lại mật khẩu", "Mã xác thực tài khoản của bạn là: " + code);
            return code;
        } else {
            String error = "Please enter correct username and email";
            return error;
        }
    }

    @PostMapping("/add-collection/{id}")
    @ResponseBody
    public String addCollection(@PathVariable("id") int id){
        User user = (User) session.getAttribute("user");
        movieCollectionService.addMovieToCollection(user.getUserId(), id);
        return "success";
    }

    @PostMapping("/rmv-collection/{id}")
    @ResponseBody
    public String rmvCollection(@PathVariable("id") int id){
        User user = (User) session.getAttribute("user");
        movieCollectionService.removeMovieToCollection(user.getUserId(), id);
        return "success";
    }
}

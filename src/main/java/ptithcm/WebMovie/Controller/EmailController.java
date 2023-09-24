package ptithcm.WebMovie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ptithcm.WebMovie.Email.EmailService;
import ptithcm.WebMovie.Email.GenrateCode;
import ptithcm.WebMovie.Repository.UserRepository;

import java.util.Random;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;

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
}

package ptithcm.WebMovie.Email;

import java.util.Random;

public class GenrateCode {
    public String generateCode(){
        Random random = new Random(); // random mã để gửi mail
        String code = "";
        int s1 = random.nextInt(10);
        int s2 = random.nextInt(10);
        int s3 = random.nextInt(10);
        int s4 = random.nextInt(10);
        int s5 = random.nextInt(10);
        int s6 = random.nextInt(10);
        code = Integer.toString(s1) + Integer.toString(s2) + Integer.toString(s3) + Integer.toString(s4)
                + Integer.toString(s5) + Integer.toString(s6);
        return code;
    }
}

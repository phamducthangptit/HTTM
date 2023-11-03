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
import ptithcm.WebMovie.Service.MovieHistoryService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class MovieController2 {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserRepository userRepository;

    private MovieCollectionService movieCollectionService;
    private MovieHistoryService movieHistoryService;

    @Autowired
    private HttpSession session;

    public MovieController2(MovieCollectionService movieCollectionService, MovieHistoryService movieHistoryService) {
        super();
        this.movieCollectionService = movieCollectionService;
        this.movieHistoryService = movieHistoryService;
    }

    @PostMapping("/send-email")
    @ResponseBody
    public String send(@RequestParam("userNameF") String userName, @RequestParam("emailF") String email){
        if(userRepository.findByuserNameAndEmail(userName, email) != null){// tim ra duoc user
            GenrateCode genrateCode = new GenrateCode();
            String code = genrateCode.generateCode();
            emailService.sendEmail(email, "Thư lấy lại mật khẩu", "Mã xác nhận lấy lại mật khẩu của bạn là: " + code);
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

    @PostMapping("/save-history/{movie_id}/{episode}/{time}")
    @ResponseBody
    public String saveHistory(@PathVariable("movie_id") int movieId, @PathVariable("episode") int episode, @PathVariable("time") float time){
        if(session.getAttribute("user") != null){
            User user = (User) session.getAttribute("user");
            movieHistoryService.saveHistory(user.getUserId(), movieId, episode, time);
        } else {
            movieHistoryService.saveHistory(0, movieId, episode, time);
        }
        return "success";
    }

    @PostMapping("/find-history/{movie_id}/{episode}")
    @ResponseBody
    public int findHistory(@PathVariable("movie_id") int movieId, @PathVariable("episode") int episode){
        int result = 0;
        if(session.getAttribute("user") != null){
            User user = (User) session.getAttribute("user");
            result = movieHistoryService.findHistory(user.getUserId(), movieId, episode);
        }
        return result;
    }

    @PostMapping("/delete-history/{movie_id}/{episode}")
    @ResponseBody
    public int deleteHistory(@PathVariable("movie_id") int movieId, @PathVariable("episode") int episode){
        int result = 0;
        if(session.getAttribute("user") != null){
            User user = (User) session.getAttribute("user");
            result = movieHistoryService.deleteHistory(user.getUserId(), movieId, episode);
        }
        return result;
    }

    @PostMapping("/find-episode-delete-movie/{id}")
    @ResponseBody
    public List<Integer> findAllEpisodeNow(@PathVariable("id") int movieId){
        System.out.println("vaof ham tim kiem tap phim");
        return movieCollectionService.findAllEpisodeNow(movieId);
    }

    @PostMapping("/delete-movie/{id}")
    @ResponseBody
    public int deleteMovie(@PathVariable("id") int id){
        return movieCollectionService.deleteMovie(id);
    }

    @PostMapping("/delete-episode/{id}")
    @ResponseBody
    public int deleteEpisode(@PathVariable("id") int movieId, @RequestBody int[] selected){

        Set<Integer> episoded = new HashSet<>();
        for(int i = 0; i < selected.length; i++){
            episoded.add(selected[i]);
        }
        for(int x : episoded){
            System.out.println(x);
            movieCollectionService.deleteEpisode(movieId, x);
        }
        return 0;
    }
}

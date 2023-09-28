package ptithcm.WebMovie.Controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ptithcm.WebMovie.Model.MovieRequest;
import ptithcm.WebMovie.Model.User;
import ptithcm.WebMovie.Repository.MovieCollectionRepository;
import ptithcm.WebMovie.Service.MovieRequestService;

import java.util.List;
import java.util.Map;

@Controller
public class Contro1 {
    @Autowired
    private HttpSession session;
    private MovieRequestService movieRequestService;

    public Contro1(MovieRequestService movieRequestService) {
        super();
        this.movieRequestService = movieRequestService;
    }
    @GetMapping("/home")
    public String home(Model model) {
        List<MovieRequest> m = movieRequestService.getMovie(6);
        model.addAttribute("listMovie", m);
        List<MovieRequest> m1 = movieRequestService.getTopView(6);
        model.addAttribute("listTopView", m1);
        return "home";
    }
    @GetMapping("/movie")
    public String getMovieDetail(@RequestParam(name = "id") int id, Model model) {
        Map<String, ?> movie = movieRequestService.getMovieDetail(id);
        List<Map<String,?>> movieL = movieRequestService.getMovieLanguage(id);

        List<Map<String,?>> movieCate= movieRequestService.getMovieCategory(id);

        List<Map<String,?>> movieCo = movieRequestService.getMovieCompany(id);

        List<Map<String,?>> movieP = movieRequestService.getMoviePerson(id);
        String language = "";
        for (Map<String, ?> map : movieL) {
            language += map.get("name") + " (" + map.get("type")+") ";
        }

        if (language.length() == 0) {
            model.addAttribute("listLanguage", "Đang cập nhật");
        } else {
            model.addAttribute("listLanguage",language );
        }
        String company = "";
        for (Map<String, ?> map : movieCo) {
            company += map.get("name") +" ";
        }

        if (company.length() == 0) {
            model.addAttribute("listCompany", "Đang cập nhật");
        } else {
            model.addAttribute("listCompany",company );
        }
        String category = "";
        for (Map<String, ?> map : movieCate) {
            category += map.get("name")+" ";
        }
        if (category.length() == 0) {
            model.addAttribute("listCategory", "Đang cập nhật");
        } else {

            model.addAttribute("listCategory",category);
        }
        model.addAttribute("movie", movie);

        model.addAttribute("listPerson", movieP);
        System.out.println(movieCo);
        for (Map.Entry<String, ?> entry : movie.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        if(session.getAttribute("user") == null){ // chưa login
            model.addAttribute("isFollowing", "nouser");
        } else {
            User user = (User) session.getAttribute("user");
            // thực hiện tìm bộ sưu tập của user
            if(movieRequestService.getStatusCollection(user.getUserId(), id) == 0){
                model.addAttribute("isFollowing", "false"); // chưa có trong bst
            } else model.addAttribute("isFollowing", "true"); // đã có trong bst
        }


        return "movie-details";
    }
    @GetMapping("/movie-watching")
    public String watchMovie(@RequestParam(name = "id") int id,
                             @RequestParam(name = "episode", defaultValue = "1") int episode,
                             Model model
                             ) {


        List<Map<String,?>> episodes = movieRequestService.getMovieEpisode(id);
        Map<String,?> episode1 = null;
        for (Map<String, ?> map : episodes) {
            if (map.get("episode").equals(episode)) {
                episode1 = map;
                break;
            }
        }
        model.addAttribute("ep",episode1);
        model.addAttribute("listEp",episodes);
        return "movie-watching";
    }
}

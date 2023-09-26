package ptithcm.WebMovie.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ptithcm.WebMovie.Model.MovieRequest;
import ptithcm.WebMovie.Service.MovieRequestService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class Contro1 {
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
    @GetMapping("/movie/{id}")
    public String getMovieDetail(@PathVariable int id, Model model) {
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
        return "movie-details";
    }
    @GetMapping("/movie")
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

package ptithcm.WebMovie.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ptithcm.WebMovie.Model.Comment;
import ptithcm.WebMovie.Model.MovieRequest;
import ptithcm.WebMovie.Service.MovieRequestService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    @GetMapping("/movie")
    public String getMovieDetail(@RequestParam(name = "id") int id
                                    , Model model) {
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
        // Response Comment
        int currentPage = 0;
        int pageSize = 6;
        int totalComment = movieRequestService.getCommentCount(id);
        int totalPage = totalComment / pageSize + 1;

        int startPage = (currentPage - 1 > 0) ? currentPage - 1: 0;
        int endPage = (totalPage - 1 > currentPage +1 )? currentPage+1 : totalPage -1;

        List<Integer> pages = new ArrayList<>();
        for (int i = startPage;i<=endPage;i++){
            pages.add(i);
        }
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("pageSize", pageSize);
        List<Map<String,?>> listCM = movieRequestService.getComment(id,currentPage*pageSize,
                pageSize);
        model.addAttribute("listComment", listCM);
        for (Map<String,?> m:listCM) {
            for (Map.Entry<String, ?> entry : m.entrySet()) {
                System.out.println(entry.getKey()+ " : " + entry.getValue());
            }
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

        // Response Comment
        int currentPage = 0;
        int pageSize = 6;
        int totalComment = movieRequestService.getCommentCount(id);
        int totalPage = totalComment / pageSize + 1;

        int startPage = (currentPage - 1 > 0) ? currentPage - 1: 0;
        int endPage = (totalPage - 1 > currentPage +1 )? currentPage+1 : totalPage -1;

        List<Integer> pages = new ArrayList<>();
        for (int i = startPage;i<=endPage;i++){
            pages.add(i);
        }
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("pageSize", pageSize);
        List<Map<String,?>> listCM = movieRequestService.getComment(id,currentPage*pageSize,
                pageSize);
        model.addAttribute("listComment", listCM);
        for (Map<String,?> m:listCM) {
            for (Map.Entry<String, ?> entry : m.entrySet()) {
                System.out.println(entry.getKey()+ " : " + entry.getValue());
            }
        }
        return "movie-watching";
    }

    @GetMapping("/movie/CMApi")
    @ResponseBody
    public List<Map<String,?>> getAPICM(@RequestParam(name = "id") int id,
                                        @RequestParam(name = "start") int start,
                                        @RequestParam(name = "size") int size) {
        List<Map<String,?>> listCM = movieRequestService.getComment(id,start,size);
        return listCM;
    }

    @PostMapping("/movie/CMApi")
    @ResponseBody
    public void postAPICM(@RequestParam(name = "id") int id, @RequestBody Comment comment) {
        LocalDateTime now = LocalDateTime.now();

        // Chuyển đổi thành chuỗi
        comment.setDate(now);
        System.out.println(comment.getComment());
        System.out.println(comment.getValue());
        System.out.println(comment.getDate());

    }
    @GetMapping("/search")
    public String getMovieSearch(@RequestParam(name = "input") int id) {
        int currentPage = 0;
        int pageSize = 6;
        int totalComment = movieRequestService.getCommentCount(id);
        int totalPage = totalComment / pageSize + 1;

        int startPage = (currentPage - 1 > 0) ? currentPage - 1: 0;
        int endPage = (totalPage - 1 > currentPage +1 )? currentPage+1 : totalPage -1;

        List<Integer> pages = new ArrayList<>();
        for (int i = startPage;i<=endPage;i++){
            pages.add(i);
        }

        return "search";
    }

}

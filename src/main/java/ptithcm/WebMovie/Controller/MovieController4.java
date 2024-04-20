package ptithcm.WebMovie.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ptithcm.WebMovie.Model.*;
import ptithcm.WebMovie.Repository.*;
import ptithcm.WebMovie.Service.MovieRequestService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MovieController4 {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private PersonRepository personRepository;

    private MovieRequestService movieRequestService;

    public MovieController4(MovieRequestService movieRequestService) {
        this.movieRequestService = movieRequestService;
    }

    @GetMapping("/AddMovie")
    public String addMovie(Model model) {
        List<Movie> movies = movieRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        List<Country> countries = countryRepository.findAll();
        List<Language> languages = languageRepository.findAll();
        List<Company> companies = companyRepository.findAll();
        List<Map<String,?>> persons = personRepository.getPerson();

        model.addAttribute("categories", categories);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);

        model.addAttribute("companies",companies);
        model.addAttribute("persons",persons);

        model.addAttribute("listCategory",categories);

        return "AddMovie";
    }
    public List<Integer> StringToNumber (String[] temp , List<Integer> listNumber)
    {
        // Lặp qua mảng các chuỗi con và chuyển chúng thành số nguyên
        for (String part : temp) {
            try {
                int number = Integer.parseInt(part.trim());
                listNumber.add(number);
            } catch (NumberFormatException e) {
                // Xử lý nếu có lỗi chuyển đổi số
                System.err.println("Lỗi chuyển đổi số: " + e.getMessage());
            }
        }
        return listNumber;
    }
    @PostMapping("/AddMovie/add")
    public String addMovie(HttpServletRequest request, @RequestParam("image-input") MultipartFile file) {
        String idLanguageMovie =  request.getParameter("language-movie");
        String[] tempLanguage = idLanguageMovie.split(",");

        // Tạo danh sách (ArrayList) để lưu trữ các phần tử
        List<Integer> idLanguagenumbers = new ArrayList<>();
        idLanguagenumbers = StringToNumber(tempLanguage,idLanguagenumbers);
        System.out.println("L : "+idLanguagenumbers);

        String idCategoryMovie =  request.getParameter("category-movie");
        String[] tempCategory = idCategoryMovie.split(",");

        // Tạo danh sách (ArrayList) để lưu trữ các phần tử
        List<Integer> idCategorynumbers = new ArrayList<>();
        idCategorynumbers = StringToNumber(tempCategory,idCategorynumbers);
        System.out.println("C"+idCategorynumbers);

        String idPersonMovie =  request.getParameter("actor-movie");
        String[] tempPerson = idPersonMovie.split(",");

        // Tạo danh sách (ArrayList) để lưu trữ các phần tử
        List<Integer> idPersonnumbers = new ArrayList<>();
        idPersonnumbers = StringToNumber(tempPerson,idPersonnumbers);
        System.out.println("P"+idPersonnumbers);

        String idCompanyMovie =  request.getParameter("company-movie");
        System.out.println("c"+idCompanyMovie);
        String[] tempCompany = idCompanyMovie.split(",");

        // Tạo danh sách (ArrayList) để lưu trữ các phần tử
        List<Integer> idCompanynumbers = new ArrayList<>();
        idCompanynumbers = StringToNumber(tempCompany,idCompanynumbers);
        System.out.println("c"+idCompanynumbers);
        String movieName = (String) request.getParameter("movieName");

        int countryId;
        String country = (String) request.getParameter("country");
        if (countryRepository.findByname(country) == null)
        {
            Country newcountry = new Country();
            newcountry.setName(country);

            countryRepository.save(newcountry);

            countryId = countryRepository.findByname(country).getId();
        } else  countryId = countryRepository.findByname(country).getId();

        String movieSchedule = (String) request.getParameter("movieSchedule");

        String movieContent = (String) request.getParameter("movieContent");
        if (movieContent.equalsIgnoreCase(""))
        {
            movieContent = "Đang Cập Nhật";
        }
        String episodes = (String) request.getParameter("NofE");
        Movie movie = new Movie();
        movie.setName(movieName);
        movie.setMovieContent(movieContent);
        movie.setMovieSchedule(Integer.parseInt(movieSchedule));
        movie.setCountry(countryRepository.findById(countryId));
        movie.setEpisodes(Integer.parseInt(episodes));

        if(file != null && !file.isEmpty()){ // chọn file mới
            try {
                //ảnh mới
                LocalDateTime currentDateTime = LocalDateTime.now();
                System.out.println(currentDateTime);
                String fileName = movieName.replace(" ","") + "_" +
                        currentDateTime.getHour() + "h" +
                        currentDateTime.getMinute() + "m" +
                        currentDateTime.getSecond() + "s" + ".png";
                String uploadDir = "src/main/resources/static/img/movie";
                Path filePath = Paths.get(uploadDir, fileName);
                Files.copy(file.getInputStream(), filePath);
                movie.setImage(fileName);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        movieRepository.save(movie);
        int movieId = movie.getMovieId();


        int maxLenList = Math.max(idLanguagenumbers.size(), Math.max(idCategorynumbers.size(),Math.max(idCompanynumbers.size(),idPersonnumbers.size())));
        int idLanguage = 0, idCategory = 0, idPerson = 0, idCompany =0;

        for (int i = 0; i < maxLenList; i++){
            if(idLanguage < idLanguagenumbers.size()){
                movieRequestService.insertInformationMovie(movieId, 0, 0, idLanguagenumbers.get(idLanguage), 0,(i==0?1:0));
                idLanguage++;
            }
            if(idCategory < idCategorynumbers.size()){
                movieRequestService.insertInformationMovie(movieId, 0, idCategorynumbers.get(idCategory), 0, 0,0);
                idCategory++;
            }
            if(idCompany < idCompanynumbers.size()){
                movieRequestService.insertInformationMovie(movieId, 0, 0, 0, idCompanynumbers.get(idCompany),0);
                idCompany++;
            }
            if(idPerson < idPersonnumbers.size()){
                movieRequestService.insertInformationMovie(movieId, idPersonnumbers.get(idPerson), 0, 0, 0,0);
                idPerson++;
            }

        }


        return "redirect:/list-movie";
    }
    @RequestMapping("/UpdateMovie")
    public String updateMovie(Model model, @RequestParam("id") int id) {
        Movie movie = movieRepository.findById(id);

        List<Category> categories = categoryRepository.findAll();
        List<Country> countries = countryRepository.findAll();
        List<Language> languages = languageRepository.findAll();
        List<Company> companies = companyRepository.findAll();
        List<Map<String,?>> persons = personRepository.getPerson();

        model.addAttribute("categories", categories);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);

        model.addAttribute("companies",companies);
        model.addAttribute("persons",persons);
        model.addAttribute("movie", movie);

        model.addAttribute("listCategory",categories);
        return "UpdateMovie";
    }
    @PostMapping("/UpdateMovie/update")
    public String UpdateMovie(HttpServletRequest request, @RequestParam("image-input") MultipartFile file)
    {
        String idLanguageMovie =  request.getParameter("language-movie");
        String[] tempLanguage = idLanguageMovie.split(",");

        // Tạo danh sách (ArrayList) để lưu trữ các phần tử
        List<Integer> idLanguagenumbers = new ArrayList<>();
        idLanguagenumbers = StringToNumber(tempLanguage,idLanguagenumbers);
        System.out.println("L : "+idLanguagenumbers);

        String idCategoryMovie =  request.getParameter("category-movie");
        String[] tempCategory = idCategoryMovie.split(",");

        // Tạo danh sách (ArrayList) để lưu trữ các phần tử
        List<Integer> idCategorynumbers = new ArrayList<>();
        idCategorynumbers = StringToNumber(tempCategory,idCategorynumbers);
        System.out.println("C"+idCategorynumbers);

        String idPersonMovie =  request.getParameter("actor-movie");
        String[] tempPerson = idPersonMovie.split(",");

        // Tạo danh sách (ArrayList) để lưu trữ các phần tử
        List<Integer> idPersonnumbers = new ArrayList<>();
        idPersonnumbers = StringToNumber(tempPerson,idPersonnumbers);
        System.out.println("P"+idPersonnumbers);

        String idCompanyMovie =  request.getParameter("company-movie");
        System.out.println("c"+idCompanyMovie);
        String[] tempCompany = idCompanyMovie.split(",");

        // Tạo danh sách (ArrayList) để lưu trữ các phần tử
        List<Integer> idCompanynumbers = new ArrayList<>();
        idCompanynumbers = StringToNumber(tempCompany,idCompanynumbers);
        System.out.println("c"+idCompanynumbers);
        String movieName = (String) request.getParameter("movieName");

        int countryId;
        String country = (String) request.getParameter("country");
        if (countryRepository.findByname(country) == null)
        {
            Country newcountry = new Country();
            newcountry.setName(country);

            countryRepository.save(newcountry);

            countryId = countryRepository.findByname(country).getId();
        } else  countryId = countryRepository.findByname(country).getId();

        String movieSchedule = (String) request.getParameter("movieSchedule");

        String movieContent = (String) request.getParameter("movieContent");
        if (movieContent.equalsIgnoreCase(""))
        {
            movieContent = "Đang Cập Nhật";
        }
        String episodes = (String) request.getParameter("NofE");
        int id = Integer.parseInt(request.getParameter("movie_id"));
        Movie movie = movieRepository.findById(id);
        movie.setName(movieName);
        movie.setMovieContent(movieContent);
        movie.setMovieSchedule(Integer.parseInt(movieSchedule));
        movie.setCountry(countryRepository.findById(countryId));
        movie.setEpisodes(Integer.parseInt(episodes));
        if(file != null && !file.isEmpty()){ // chọn file mới
            try {
                //ảnh mới
                LocalDateTime currentDateTime = LocalDateTime.now();
                System.out.println(currentDateTime);
                String fileName = movieName.replace(" ","") + "_" +
                        currentDateTime.getHour() + "h" +
                        currentDateTime.getMinute() + "m" +
                        currentDateTime.getSecond() + "s" + ".png";
                String uploadDir = "src/main/resources/static/img/movie";
                Path filePath = Paths.get(uploadDir, fileName);
                Files.copy(file.getInputStream(), filePath);
                movie.setImage(fileName);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        movieRepository.save(movie);


        try {
                movieRequestService.deleteInformationMovie(id);
            // Sau khi SP chạy thành công, tiến hành vòng lặp và insert
            int maxLenList = Math.max(idLanguagenumbers.size(), Math.max(idCategorynumbers.size(), Math.max(idCompanynumbers.size(), idPersonnumbers.size())));
            int idLanguage = 0, idCategory = 0, idPerson = 0, idCompany = 0;

            for (int i = 0; i < maxLenList; i++) {

                if (idLanguage < idLanguagenumbers.size()) {
                    movieRequestService.insertInformationMovie(id, 0, 0, idLanguagenumbers.get(idLanguage), 0,(i==0?1:0));
                    idLanguage++;
                }
                if (idCategory < idCategorynumbers.size()) {
                    movieRequestService.insertInformationMovie(id, 0, idCategorynumbers.get(idCategory), 0, 0,0);
                    idCategory++;
                }
                if (idCompany < idCompanynumbers.size()) {
                    movieRequestService.insertInformationMovie(id, 0, 0, 0, idCompanynumbers.get(idCompany),0);
                    idCompany++;
                }
                if (idPerson < idPersonnumbers.size()) {
                    movieRequestService.insertInformationMovie(id, idPersonnumbers.get(idPerson), 0, 0, 0,0);
                    idPerson++;
                }
            }
        } catch (Exception e) {
            // Xử lý lỗi
            System.err.println("Lỗi: " + e.getMessage());
        }
        return "redirect:/list-movie";
    }
}

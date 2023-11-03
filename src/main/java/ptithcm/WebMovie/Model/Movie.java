package ptithcm.WebMovie.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "name")
    private String name;

    @Column(name = "movie_content")
    private String movieContent;

    @Column(name = "episodes")
    private int episodes;

    @Column(name = "tags")
    private String tags;

    @Column(name = "movie_shedule")
    private int movieSchedule;

    @Column(name = "image")
    private String image;

    @Column(name = "views")
    private int views;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Movie_Company",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "company_id") }
    )
    @JsonManagedReference
    private List<Company> movie_companyList;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Movie_Language",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "language_id") }
    )
    @JsonManagedReference
    private List<Language> movie_languageList;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Movie_Category",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "category_id") }
    )
    @JsonManagedReference
    private List<Category> movie_categoryList;


    @OneToMany(mappedBy = "movie")
    private List<Movie_Collection> movie_collectionList;

    @OneToMany(mappedBy = "movie")
    private List<Episode> episodeList;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Movie_Person",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "person_id") }
    )
    @JsonManagedReference
    private List<Person> movie_personList;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Movie() {
    }

    public Movie(int movieId, String name, String movieContent, int episodes, String tags, int movieShedule, String image, int views) {
        this.movieId = movieId;
        this.name = name;
        this.movieContent = movieContent;
        this.episodes = episodes;
        this.tags = tags;
        this.movieSchedule = movieShedule;
        this.image = image;
        this.views = views;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getMovieContent() {
        return movieContent;
    }

    public int getEpisodes() {
        return episodes;
    }

    public String getTags() {
        return tags;
    }

    public int getMovieSchedule() {
        return movieSchedule;
    }

    public String getImage() {
        return image;
    }

    public int getViews() {
        return views;
    }
    public Country getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMovieContent(String movieContent) {
        this.movieContent = movieContent;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setMovieSchedule(int movieSchedule) {
        this.movieSchedule = movieSchedule;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public List<Category> getMovie_categoryList() {
        return movie_categoryList;
    }

    public void setMovie_categoryList(List<Category> movie_categoryList) {
        this.movie_categoryList = movie_categoryList;
    }

    public List<Company> getMovie_companyList() {
        return movie_companyList;
    }

    public void setMovie_companyList(List<Company> movie_companyList) {
        this.movie_companyList = movie_companyList;
    }

    public List<Language> getMovie_languageList() {
        return movie_languageList;
    }

    public void setMovie_languageList(List<Language> movie_languageList) {
        this.movie_languageList = movie_languageList;
    }

    public List<Person> getMovie_personList() {
        return movie_personList;
    }

    public void setMovie_personList(List<Person> movie_personList) {
        this.movie_personList = movie_personList;
    }
}

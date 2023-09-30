package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
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
    private int movieShedule;

    @Column(name = "image")
    private String image;

    @Column(name = "views")
    private int views;

    @OneToMany(mappedBy = "movie")
    private List<Movie_Company> movie_companyList;

    @OneToMany(mappedBy = "movie")
    private List<Movie_Language> movie_languageList;

    @OneToMany(mappedBy = "movie")
    private List<Movie_Category> movie_categoryList;

    @OneToMany(mappedBy = "movie")
    private List<Movie_Collection> movie_collectionList;

    @OneToMany(mappedBy = "movie")
    private List<Episode> episodeList;

    @OneToMany(mappedBy = "movie")
    private List<Movie_Person> movie_personList;

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
        this.movieShedule = movieShedule;
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

    public int getMovieShedule() {
        return movieShedule;
    }

    public String getImage() {
        return image;
    }

    public int getViews() {
        return views;
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

    public void setMovieShedule(int movieShedule) {
        this.movieShedule = movieShedule;
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
}

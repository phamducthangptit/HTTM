package ptithcm.WebMovie.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Language")
public class Language {
    @Id
    @Column(name = "language_id")
    private int language_id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "movie_languageList")
    @JsonBackReference
    private List<Movie> movie_languageList;

    public Language() {
    }

    public Language(int language_id, String name) {
        this.language_id = language_id;
        this.name = name;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovie_languageList() {
        return movie_languageList;
    }

    public void setMovie_languageList(List<Movie> movie_languageList) {
        this.movie_languageList = movie_languageList;
    }
}

package ptithcm.WebMovie.Model;

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

    @OneToMany(mappedBy = "language")
    private List<Movie_Language> movie_languageList;

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
}

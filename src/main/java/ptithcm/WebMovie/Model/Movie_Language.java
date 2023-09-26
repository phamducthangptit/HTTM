package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie_Language")
public class Movie_Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "type")
    private String type;

    public Movie_Language() {
    }

    public Movie_Language(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

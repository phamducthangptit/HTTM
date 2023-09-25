package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie_Category")
public class Movie_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Movie_Category() {
    }
}

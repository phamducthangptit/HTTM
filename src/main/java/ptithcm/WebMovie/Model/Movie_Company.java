package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie_Company")
public class Movie_Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Movie_Company() {
    }
}

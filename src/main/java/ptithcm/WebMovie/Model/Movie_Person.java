package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Movie_Person")
public class Movie_Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    private Person person;

    public Movie_Person() {
    }
}

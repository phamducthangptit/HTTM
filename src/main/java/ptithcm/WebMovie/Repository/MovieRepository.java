package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findById(int movieId);
}

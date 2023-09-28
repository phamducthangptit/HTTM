package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Movie_Collection;

@Repository
public interface MovieCollectionRepository extends JpaRepository<Movie_Collection, Integer> {
    @Query(value = "{call SP_ADD_COLLECTION(:userId, :movieId)}", nativeQuery = true)
    int addMovieToCollection(@Param("userId") int userId, @Param("movieId") int movieId);

    @Query(value = "{call SP_REMOVE_COLLECTION(:userId, :movieId)}", nativeQuery = true)
    int removeMovieToCollection(@Param("userId") int userId, @Param("movieId") int movieId);
}

package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Movie_Collection;

import java.util.List;
import java.util.Map;

@Repository
public interface MovieCollectionRepository extends JpaRepository<Movie_Collection, Integer> {
    @Query(value = "{call SP_ADD_COLLECTION(:userId, :movieId)}", nativeQuery = true)
    int addMovieToCollection(@Param("userId") int userId, @Param("movieId") int movieId);

    @Query(value = "{call SP_REMOVE_COLLECTION(:userId, :movieId)}", nativeQuery = true)
    int removeMovieToCollection(@Param("userId") int userId, @Param("movieId") int movieId);

    @Query(value = "{call SP_FIND_COLLECTION(:user_id)}", nativeQuery = true)
    List<Map<String, ?>> findMyCollection(@Param("user_id") int userId);

    @Query(value = "{call SP_SELECT_LIST_MOVIE}", nativeQuery = true)
    List<Map<String, ?>> selectListMovie();

    @Query(value = "{call SP_FIND_EPISODE_DELETE_MOVIE(:movie_id)}", nativeQuery = true)
    List<Integer> findAllEpisodeNow(@Param("movie_id") int movieId);

    @Query(value = "{call SP_DELETE_EPISODE(:movie_id, :episode)}", nativeQuery = true)
    int deleteEpisode(@Param("movie_id") int movieId, @Param("episode") int episode);

    @Query(value = "{call SP_DELETE_MOVIE(:movie_id)}", nativeQuery = true)
    int deleteMovie(@Param("movie_id") int movieId);
}

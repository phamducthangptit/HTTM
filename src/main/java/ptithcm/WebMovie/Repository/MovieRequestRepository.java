package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.MovieRequest;

import java.util.List;
import java.util.Map;


@Repository
public interface MovieRequestRepository extends JpaRepository<MovieRequest, Integer> {
    @Query(value = "{call SP_FIND_NEW_MOVIE(:rank)}", nativeQuery = true)
    List<MovieRequest> getMovie(@Param("rank") int rank);

    @Query(value = "{call SP_FIND_TOP_VIEW_MOVIE(:rank)}", nativeQuery = true)
    List<MovieRequest> getTopView(@Param("rank") int rank);

    @Query(value ="{call SP_FIND_COMMENT_FROM_MOVIE(:id)}", nativeQuery = true)
    List<Map<String,?>> getCM(@Param("id") int id);

    @Query(value ="{call SP_FIND_MOVIE_DETAIL(:id)}", nativeQuery = true)
    Map<String,?> getMovieDetail(@Param("id") int id);

    @Query(value ="{call SP_FIND_MOVIE_LANGUAGE(:id)}", nativeQuery = true)
    List<Map<String,?>> getMovieLanguage(@Param("id") int id);
    @Query(value ="{call SP_FIND_MOVIE_CATEGORY(:id)}", nativeQuery = true)
    List<Map<String,?>> getMovieCategory(@Param("id") int id);

    @Query(value ="{call SP_FIND_MOVIE_COMPANY(:id)}", nativeQuery = true)
    List<Map<String,?>> getMovieCompany(@Param("id") int id);

    @Query(value ="{call SP_FIND_MOVIE_PERSON(:id)}", nativeQuery = true)
    List<Map<String,?>> getMoviePerson(@Param("id") int id);

    @Query(value ="{call SP_FIND_MOVIE_EPISODES(:id)}", nativeQuery = true)
    List<Map<String,?>> getMovieEpisode(@Param("id") int id);


    @Query(value ="{call SP_FIND_COMMENT_MOVIE(:id, :start, :size)}", nativeQuery = true)
    List<Map<String,?>> getComment(@Param("id") int id,
                                   @Param("start") int start,
                                   @Param("size") int size);

    @Query(value ="{call SP_COUNT_COMMENT_MOVIE(:id)}", nativeQuery = true)
    int getCommentCount(@Param("id") int id);



    @Query(value = "{call SP_GET_STATUS_COLLECTION(:user_id, :movie_id)}", nativeQuery = true)
    int getStatusCollection(@Param("user_id") int userId, @Param("movie_id") int movieId);

}

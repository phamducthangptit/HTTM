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

    @Query(value ="{call SP_INSERT_INFORMATION_MOVIE(:movie_id ,:person_id ,:category_id,:language_id,:company_id)}", nativeQuery = true)
    int insertInformationMovie(@Param("movie_id") int movie_id, @Param("person_id") int person_id ,@Param("category_id") int category_id,@Param("language_id") int language_id,@Param("company_id") int company_id);


}

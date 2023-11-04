package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.MovieRequest;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Repository
public interface MovieRequestRepository extends JpaRepository<MovieRequest, Integer> {
    // lọc ra những bộ phim mới được cập nhật tập mới
    @Query(value = "{call SP_FIND_NEW_MOVIE(:start,:size)}", nativeQuery = true)
    List<MovieRequest> getMovie(@Param("start") int start,
                                @Param("size") int size);
    // lọc ra những bộ phim mới theo thể loại
    @Query(value = "{call SP_FIND_TOP_MOVIE_CATEGORY(:start,:size,:category)}", nativeQuery = true)
    List<MovieRequest> getMovieTopCategory(@Param("start") int start,
                                           @Param("size") int size,
                                           @Param("category") String category);
    @Query(value ="{call SP_COUNT_MOVIE_CATEGORY(:category)}", nativeQuery = true)
    int getCountMovieCategory(@Param("category") String category);

    // lọc phim theo 2 thể loại
    @Query(value = "{call SP_TIM_PHIM_THEO_2_THE_LOAI(:theloai1, :theloai2, :theloai3,:theloai4,:theloai5, :start,:size)}", nativeQuery = true)
    List<MovieRequest> getMovie2Category(@Param("theloai1") String theLoai1,
                                           @Param("theloai2") String theLoai2,
                                           @Param("theloai3") String theLoai3,
                                           @Param("theloai4") String theLoai4,
                                           @Param("theloai5") String theLoai5,
                                           @Param("start") int start,
                                           @Param("size") int size
                                           );

    @Query(value ="{call SP_COUNT_PHIM_THEO_2_THE_LOAI(:theloai1, :theloai2, :theloai3,:theloai4,:theloai5)}", nativeQuery = true)
    int getCountMovie2Category(@Param("theloai1") String theLoai1,
                               @Param("theloai2") String theLoai2,
                               @Param("theloai3") String theLoai3,
                               @Param("theloai4") String theLoai4,
                               @Param("theloai5") String theLoai5);


    @Query(value = "{call SP_FIND_TOP_VIEW_MOVIE(:start,:size)}", nativeQuery = true)
    List<MovieRequest> getTopView(@Param("start") int start,
                                  @Param("size") int size);

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


    @Query(value ="{call SP_INSERT_INFORMATION_MOVIE(:movie_id ,:person_id ,:category_id,:language_id,:company_id,:type)}", nativeQuery = true)
    int insertInformationMovie(@Param("movie_id") int movie_id, @Param("person_id") int person_id ,@Param("category_id") int category_id,@Param("language_id") int language_id,@Param("company_id") int company_id,@Param("type") int type);
    @Query(value = "{call SP_DELETE_INFORMATION_MOVIE(:movie_id)}", nativeQuery = true)
    int deleteInformationMovie(@Param("movie_id") int movie_id);


    @Query(value ="{call SP_FIND_COMMENT_MOVIE(:id, :start, :size)}", nativeQuery = true)
    List<Map<String,?>> getComment(@Param("id") int id,
                                   @Param("start") int start,
                                   @Param("size") int size);



    @Query(value ="{call SP_COUNT_COMMENT_MOVIE(:id)}", nativeQuery = true)
    int getCommentCount(@Param("id") int id);
    @Query(value ="{call SP_SEARCH_MOVIE(:input, :start, :size)}", nativeQuery = true)
    List<MovieRequest> getSearchMovie(@Param("input") String input,
                                   @Param("start") int start,
                                   @Param("size") int size);
    @Query(value ="{call SP_COUNT_SEARCH_MOVIE(:input)}", nativeQuery = true)
    int getSearchMovieCount(@Param("input") String input);

    @Query(value = "{call SP_GET_STATUS_COLLECTION(:user_id, :movie_id)}", nativeQuery = true)
    int getStatusCollection(@Param("user_id") int userId, @Param("movie_id") int movieId);

    @Procedure(name="Comment.insertComment")
    int saveComment(int movie_id,
                    int user_id,
                    String comment,
                    int value,
                    LocalDateTime date
                    );


    @Query(value ="{call SP_GET_ACTOR( :start, :size)}", nativeQuery = true)
    List<Map<String,Object>> getActor(@Param("start") int start,
                                   @Param("size") int size);

    @Query(value ="{call SP_GET_ACTOR_COUNT()}", nativeQuery = true)
    int getActorCount();

    @Query(value ="{call SP_GET_COUNTRY()}", nativeQuery = true)
    List<String> getListCountry();

    @Query(value ="{call SP_CHECK_EXISTS_COUNTRY(:name)}", nativeQuery = true)
    int checkCountry(@Param("name") int name);

    @Procedure(name="Person.insertActor")
    void saveActor(String name,
                    int gender,
                    Date day_of_birth,
                    String image,
                    String describe,
                    String name_cn
    );

    @Query(value ="{call SP_FIND_MOVIE_NEW_COMMENT()}", nativeQuery = true)
    List<Map<String,?>> getMovieNewComment();

    @Query(value ="{call SP_INSERT_EPISODE(:name, :episode, :season,:source,:movie_id, :day_submit)}", nativeQuery = true)
    int saveEpisode(@Param("name") String name,
                     @Param("episode") int episode,
                     @Param("season")  String season,
                     @Param("source") String source,
                     @Param("movie_id") int movie_id,
                     @Param("day_submit") LocalDateTime day_submit
                     );

    @Query(value ="{call SP_DELETE_ACTORS(:id)}", nativeQuery = true)
    int deleteActor(@Param("id") int id);

    @Query(value ="{call SP_GET_ACTOR_INFO(:id)}", nativeQuery = true)
    Map<String, Object> getActorInfo(@Param("id") int id);

    @Procedure(name="Person.updateActor")
    int updateActor(int id,
                    String name,
                    int gender,
                    Date day,
                    String image,
                    String describe,
                    String name_cn
    );

    @Query(value ="{call SP_ADD_SEARCH_SENTENCE(:sentence)}", nativeQuery = true)
    int addSearchSentence(@Param("sentence") String sentence);
}

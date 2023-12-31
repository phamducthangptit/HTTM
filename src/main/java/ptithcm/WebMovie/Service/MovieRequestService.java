package ptithcm.WebMovie.Service;

import org.springframework.data.repository.query.Param;
import ptithcm.WebMovie.Model.MovieRequest;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MovieRequestService {

    List<MovieRequest> getMovie(int start, int size);

    List<MovieRequest> getTopView( int start, int size);

    List<Map<String,?>> getCM(int id);

    Map<String,?> getMovieDetail(int id);

    List<Map<String,?>> getMovieLanguage( int id);

    List<Map<String,?>> getMovieCategory( int id);

    List<Map<String,?>> getMovieCompany( int id);

    List<Map<String,?>> getMoviePerson(int id);

    List<Map<String,?>> getMovieEpisode( int id);

    int insertInformationMovie(int movie_id, int person_id ,int category_id,int language_id,int company_id,int type);
    int deleteInformationMovie(int movie_id);



    List<Map<String,?>> getComment(int id,
                                   int start,
                                   int size);

    int getCommentCount(int id);

    List<MovieRequest> getSearchMovie(String input,
                                      int start,
                                      int size);

    int getSearchMovieCount(String input);

    int saveComment(int movie_id,
                    int user_id,
                    String comment,
                    int value,
                    LocalDateTime date
    );

    int getStatusCollection(int userId, int movieId);

    List<Map<String,Object>> getActor(int start,
                                 int size);
    int getActorCount();

    List<String> getListCountry();

    int checkCountry(int name);

    void saveActor(String name,
                  int gender,
                  Date day_of_birth,
                  String image,
                  String describe,
                  String name_cn
    );
    List<Map<String,?>> getMovieNewComment();

    int saveEpisode(String name,
                     int episode,
                     String season,
                     String source,
                     int movie_id,
                     LocalDateTime day_submit
    );

    int deleteActor( int id);

    List<MovieRequest> getMovieTopCategory(int start, int size,
                                           String category);
    int getCountMovieCategory(String category);


    List<MovieRequest> getMovie2Category(String theLoai1,
                                         String theLoai2,
                                         String theLoai3,
                                         String theLoai4,
                                         String theLoai5,
                                         int start,
                                         int size
    );

    int getCountMovie2Category(String theLoai1,
                               String theLoai2,
                               String theLoai3,
                               String theLoai4,
                               String theLoai5);
    Map<String, Object> getActorInfo(int id);

    int updateActor(int id,
                    String name,
                    int gender,
                    Date day,
                    String image,
                    String describe,
                    String name_cn
    );

    int addSearchSentence(String sentence);
}

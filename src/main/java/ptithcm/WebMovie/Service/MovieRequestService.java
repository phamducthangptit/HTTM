package ptithcm.WebMovie.Service;

import org.springframework.data.repository.query.Param;
import ptithcm.WebMovie.Model.MovieRequest;

import java.util.List;
import java.util.Map;

public interface MovieRequestService {

    List<MovieRequest> getMovie(int rank);

    List<MovieRequest> getTopView( int rank);

    List<Map<String,?>> getCM(int id);

    Map<String,?> getMovieDetail(int id);

    List<Map<String,?>> getMovieLanguage( int id);

    List<Map<String,?>> getMovieCategory( int id);

    List<Map<String,?>> getMovieCompany( int id);

    List<Map<String,?>> getMoviePerson(int id);

    List<Map<String,?>> getMovieEpisode( int id);


    List<Map<String,?>> getComment(int id,
                                   int start,
                                   int size);

    int getCommentCount(int id);
}
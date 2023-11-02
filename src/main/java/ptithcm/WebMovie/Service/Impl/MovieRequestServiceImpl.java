package ptithcm.WebMovie.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import ptithcm.WebMovie.Model.MovieRequest;
import ptithcm.WebMovie.Repository.MovieRequestRepository;
import ptithcm.WebMovie.Service.MovieRequestService;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class MovieRequestServiceImpl implements MovieRequestService {
    @Autowired
    MovieRequestRepository movieRequestRepository;
    public List<MovieRequest> getMovie(int rank) {
        return movieRequestRepository.getMovie(rank);
    }

    public List<MovieRequest> getTopView( int rank){ return movieRequestRepository.getTopView(rank);};

    public List<Map<String,?>> getCM(int id){
        return movieRequestRepository.getCM(id);
    };

    public Map<String,?> getMovieDetail(int id){
        return movieRequestRepository.getMovieDetail(id);
    };

    public List<Map<String,?>> getMovieLanguage( int id){
        return movieRequestRepository.getMovieLanguage(id);
    };

    public List<Map<String,?>> getMoviePerson( int id){
        return movieRequestRepository.getMoviePerson(id);
    };
    public List<Map<String,?>> getMovieCompany( int id){
        return movieRequestRepository.getMovieCompany(id);
    };
    public List<Map<String,?>> getMovieCategory( int id){
        return movieRequestRepository.getMovieCategory(id);
    };

    public List<Map<String,?>> getMovieEpisode( int id) {
        return movieRequestRepository.getMovieEpisode(id);

    }

    public int insertInformationMovie(int movie_id, int person_id, int category_id, int language_id, int company_id) {
        return movieRequestRepository.insertInformationMovie(movie_id, person_id, category_id, language_id, company_id);
    }

    ;public int deleteInformationMovie(int movie_id)
    {
        return movieRequestRepository.deleteInformationMovie(movie_id);
    }





    public List<Map<String,?>> getComment(int id,
                                   int start,
                                   int size) {
        return movieRequestRepository.getComment(id,start,size);
    };

    public int getCommentCount(int id){
        return movieRequestRepository.getCommentCount(id);
    };

    public List<MovieRequest> getSearchMovie(String input,
                                      int start,
                                      int size){
        return movieRequestRepository.getSearchMovie(input,start,size);
    };
    public int getSearchMovieCount(String input){
        return movieRequestRepository.getSearchMovieCount(input);
    };
    public int getStatusCollection(int userId, int movieId){
        return movieRequestRepository.getStatusCollection(userId, movieId);
    }
    public int saveComment(int movie_id,
                    int user_id,
                    String comment,
                    int value,
                    LocalDateTime date
    ){
        return movieRequestRepository.saveComment(movie_id,user_id,comment,value,date);
    };
    public List<Map<String,Object>> getActor(int start,
                                 int size){
        return movieRequestRepository.getActor(start,size);
    };

    public int getActorCount() {
        return movieRequestRepository.getActorCount();
    };

    public List<String> getListCountry(){
        return movieRequestRepository.getListCountry();
    };

    public int checkCountry(int name) {
        return movieRequestRepository.checkCountry(name);
    };

    public void saveActor(String name,
                  int gender,
                  Date day_of_birth,
                  String image,
                  String describe,
                  String name_cn
    ){
       movieRequestRepository.saveActor(name,gender,day_of_birth,image,describe,name_cn);
    };

    public List<Map<String,?>> getMovieNewComment() {
        return movieRequestRepository.getMovieNewComment();
    };
    public int saveEpisode(String name,
                     int episode,
                     String season,
                     String source,
                     int movie_id,
                     LocalDateTime day_submit
    ){
      return  movieRequestRepository.saveEpisode(name, episode, season, source, movie_id, day_submit);
    };

    public int deleteActor(int id){
        return movieRequestRepository.deleteActor(id);
    };
    public List<MovieRequest> getMovieTopCategory(int rank,
                                           String category){
        return movieRequestRepository.getMovieTopCategory(rank,category);
    };
}

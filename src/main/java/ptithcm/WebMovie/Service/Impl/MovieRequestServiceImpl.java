package ptithcm.WebMovie.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.WebMovie.Model.MovieRequest;
import ptithcm.WebMovie.Repository.MovieRequestRepository;
import ptithcm.WebMovie.Service.MovieRequestService;

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
    };



    public List<Map<String,?>> getComment(int id,
                                   int start,
                                   int size) {
        return movieRequestRepository.getComment(id,start,size);
    };

    public int getCommentCount(int id){
        return movieRequestRepository.getCommentCount(id);
    };

    public int getStatusCollection(int userId, int movieId){
        return movieRequestRepository.getStatusCollection(userId, movieId);
    }

}

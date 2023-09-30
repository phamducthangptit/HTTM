package ptithcm.WebMovie.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.WebMovie.Repository.MovieCollectionRepository;
import ptithcm.WebMovie.Service.MovieCollectionService;

import java.util.List;
import java.util.Map;

@Service
public class MovieCollectionServiceImp implements MovieCollectionService {
    @Autowired
    MovieCollectionRepository movieCollectionRepository;

    public int addMovieToCollection(int userId, int movieId) {
        return movieCollectionRepository.addMovieToCollection(userId, movieId);
    }

    public int removeMovieToCollection(int userId, int movieId) {
        return movieCollectionRepository.removeMovieToCollection(userId, movieId);
    }

    public List<Map<String, ?>> findMyCollection(int userId) {
        return movieCollectionRepository.findMyCollection(userId);
    }


}

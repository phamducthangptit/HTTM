package ptithcm.WebMovie.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.WebMovie.Repository.MovieCollectionRepository;
import ptithcm.WebMovie.Service.MovieCollectionService;

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


}

package ptithcm.WebMovie.Service;

public interface MovieCollectionService {
    int addMovieToCollection(int userId, int movieId);

    int removeMovieToCollection(int userId, int movieId);
}

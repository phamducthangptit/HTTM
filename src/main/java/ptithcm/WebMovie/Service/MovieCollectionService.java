package ptithcm.WebMovie.Service;

import java.util.List;
import java.util.Map;

public interface MovieCollectionService {
    int addMovieToCollection(int userId, int movieId);

    int removeMovieToCollection(int userId, int movieId);

    List<Map<String, ?>> findMyCollection(int userId);
}

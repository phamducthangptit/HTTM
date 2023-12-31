package ptithcm.WebMovie.Service;

public interface MovieHistoryService {
    int saveHistory(int userId, int movieId, int episode, float time);

    int findHistory(int userId, int movieId, int episode);

    int deleteHistory(int userId, int movieId, int episode);

    int updateViews(int userId, int movieId, int episode, float time);
}

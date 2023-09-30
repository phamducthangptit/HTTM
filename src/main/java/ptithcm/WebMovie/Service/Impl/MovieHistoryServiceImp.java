package ptithcm.WebMovie.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ptithcm.WebMovie.Repository.MovieHistoryReponsitory;
import ptithcm.WebMovie.Service.MovieHistoryService;

@Service
public class MovieHistoryServiceImp implements MovieHistoryService {
    @Autowired
    MovieHistoryReponsitory movieHistoryReponsitory;

    public int saveHistory(int userId, int movieId, int episode, float time) {
        return movieHistoryReponsitory.saveHistory(userId, movieId, episode, time);
    }

    public int findHistory(int userId, int movieId, int episode) {
        return movieHistoryReponsitory.findHistory(userId, movieId, episode);
    }

    public int deleteHistory(int userId, int movieId, int episode) {
        return movieHistoryReponsitory.deleteHistory(userId, movieId, episode);
    }

    public int updateViews(int userId, int movieId, int episode, float time) {
        return movieHistoryReponsitory.updateViews(userId, movieId, episode, time);
    }


}

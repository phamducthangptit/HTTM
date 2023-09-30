package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.History;

@Repository
public interface MovieHistoryReponsitory extends JpaRepository<History, Integer> {
    @Query(value = "{call SP_SAVE_HISTORY(:userId, :movieId, :episode, :time)}", nativeQuery = true)
    public int saveHistory(@Param("userId") int userId, @Param("movieId") int movieId, @Param("episode") int episode, @Param("time") float time);

    @Query(value = "{call SP_FIND_HISTORY(:userId, :movieId, :episode)}", nativeQuery = true)
    public int findHistory(@Param("userId") int userId, @Param("movieId") int movieId, @Param("episode") int episode);
}

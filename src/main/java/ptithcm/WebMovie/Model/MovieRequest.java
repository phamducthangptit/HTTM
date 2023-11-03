package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;


@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name="Comment.insertComment",
        procedureName = "SP_INSERT_COMMENT", parameters = {
            @StoredProcedureParameter(mode=ParameterMode.IN, name="movie_id", type = Integer.class),
            @StoredProcedureParameter(mode=ParameterMode.IN, name="user_id", type = Integer.class),
            @StoredProcedureParameter(mode=ParameterMode.IN, name="comment", type = String.class),
            @StoredProcedureParameter(mode=ParameterMode.IN, name="value", type = Integer.class),
            @StoredProcedureParameter(mode=ParameterMode.IN, name="date", type = LocalDateTime.class),
            @StoredProcedureParameter(mode=ParameterMode.OUT, name="result", type = Integer.class)
        }
    ),
        @NamedStoredProcedureQuery(name="Person.insertActor",
                procedureName = "SP_INSERT_ACTOR", parameters = {
                @StoredProcedureParameter(mode=ParameterMode.IN, name="name", type = String.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="gender", type = Integer.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="day_of_birth", type = Date.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="image", type = String.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="describe", type = String.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="name_cn", type = String.class)
            }
        ),
        @NamedStoredProcedureQuery(name="Person.updateActor",
                procedureName = "SP_UPDATE_ACTOR_INFO", parameters = {
                @StoredProcedureParameter(mode=ParameterMode.IN, name="id", type = Integer.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="name", type = String.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="gender", type = Integer.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="day", type = Date.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="image", type = String.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="describe", type = String.class),
                @StoredProcedureParameter(mode=ParameterMode.IN, name="name_cn", type = String.class),
                @StoredProcedureParameter(mode=ParameterMode.OUT, name="result", type = Integer.class)
        }
        )
})
@Entity
public class MovieRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    private String name;
    private int episodes;
    private int episode;
    private int views;
    private int cm_count;
    private int episode_id;
    private String image;

    public MovieRequest() {
    }

    public MovieRequest(int movie_id, String name, int episodes, int episode, int views, int cm_count, int episode_id, String image) {
        this.movie_id = movie_id;
        this.name = name;
        this.episodes = episodes;
        this.episode = episode;
        this.views = views;
        this.cm_count = cm_count;
        this.episode_id = episode_id;
        this.image = image;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getCm_count() {
        return cm_count;
    }

    public void setCm_count(int cm_count) {
        this.cm_count = cm_count;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }
}

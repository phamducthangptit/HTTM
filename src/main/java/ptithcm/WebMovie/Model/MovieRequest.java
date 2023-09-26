package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class MovieRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movie_id;
    private String name;
    private int episodes;
    private int episode;
    private String tags;
    private int views;
    private int cm_count;
    private Date daysub;
    private String image;

    public MovieRequest() {
    }

    public MovieRequest(int movie_id, String name, int episodes, int episode, String tags, int views, int cm_count, Date daysub, String image) {
        this.movie_id = movie_id;
        this.name = name;
        this.episodes = episodes;
        this.episode = episode;
        this.tags = tags;
        this.views = views;
        this.cm_count = cm_count;
        this.daysub = daysub;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public Date getDaysub() {
        return daysub;
    }
    public void setDaysub(Date daysub) {
        this.daysub = daysub;
    }
}

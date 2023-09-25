package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "Episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "episode")
    private int episode;

    @Column(name = "season")
    private String season;

    @Column(name = "source")
    private String source;

    @Column(name = "day_submit")
    private Time daySubmit;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @OneToMany(mappedBy = "episode")
    private List<History> historyList;

    public Episode() {
    }

    public Episode(int id, String name, int episode, String season, String source, Time daySubmit) {
        this.id = id;
        this.name = name;
        this.episode = episode;
        this.season = season;
        this.source = source;
        this.daySubmit = daySubmit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Time getDaySubmit() {
        return daySubmit;
    }

    public void setDaySubmit(Time daySubmit) {
        this.daySubmit = daySubmit;
    }
}

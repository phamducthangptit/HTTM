package ptithcm.WebMovie.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Entity
@Data
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int person_id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private int gender;

    @Column(name = "day_of_birth")
    private Time dayOfBirth;

    @Column(name = "image")
    private String image;

    @Column(name = "describe")
    private String describe;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToMany(mappedBy = "movie_personList")
    @JsonBackReference
    private List<Movie> movie_personList;
    public Person() {
    }

    public Person(int person_id, String name, int gender, Time dayOfBirth, String image, String describe) {
        this.person_id = person_id;
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.image = image;
        this.describe = describe;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Time getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Time dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Movie> getMovie_personList() {
        return movie_personList;
    }

    public void setMovie_personList(List<Movie> movie_personList) {
        this.movie_personList = movie_personList;
    }
}

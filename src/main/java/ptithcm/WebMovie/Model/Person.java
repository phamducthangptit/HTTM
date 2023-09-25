package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @OneToMany(mappedBy = "person")
    private List<Movie_Person> movie_personList;
    public Person() {
    }

    public Person(int id, String name, int gender, Time dayOfBirth, String image, String describe) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dayOfBirth = dayOfBirth;
        this.image = image;
        this.describe = describe;
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
}

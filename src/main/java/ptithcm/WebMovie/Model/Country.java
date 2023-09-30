package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int country_id;

    @Column(name = "name")
    private String name;

    public Country() {
    }

    @OneToMany(mappedBy = "country")
    private List<Person> personList;

    @OneToMany(mappedBy = "country")
    private List<Movie> movies;

    public Country(int id, String name) {
        this.country_id = id;
        this.name = name;
    }

    public int getId() {
        return country_id;
    }

    public void setId(int id) {
        this.country_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

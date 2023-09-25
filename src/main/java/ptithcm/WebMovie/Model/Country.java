package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Country() {
    }

    @OneToMany(mappedBy = "country")
    private List<Person> personList;

    @OneToMany(mappedBy = "country")
    private List<Movie> movies;

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
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
}

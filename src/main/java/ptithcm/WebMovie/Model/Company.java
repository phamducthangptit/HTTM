package ptithcm.WebMovie.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "movie_companyList")
    @JsonBackReference
    private List<Movie> movie_companyList;


    public Company() {
    }

    public Company(int companyId, String name, String companyContent) {
        this.companyId = companyId;
        this.name = name;

    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Movie> getMovie_companyList() {
        return movie_companyList;
    }

    public void setMovie_companyList(List<Movie> movie_companyList) {
        this.movie_companyList = movie_companyList;
    }
}

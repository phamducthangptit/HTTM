package ptithcm.WebMovie.Model;

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

    @Column(name = "company_content")
    private String companyContent;

    @OneToMany(mappedBy = "company")
    private List<Movie_Company> movie_companyList;

    public Company() {
    }

    public Company(int companyId, String name, String companyContent) {
        this.companyId = companyId;
        this.name = name;
        this.companyContent = companyContent;
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

    public String getCompanyContent() {
        return companyContent;
    }

    public void setCompanyContent(String companyContent) {
        this.companyContent = companyContent;
    }
}

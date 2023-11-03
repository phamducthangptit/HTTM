package ptithcm.WebMovie.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "movie_categoryList")
    @JsonBackReference
    private List<Movie> movie_categoryList;
    public Category() {
    }

    public Category(String name) {

        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovie_categoryList() {
        return movie_categoryList;
    }

    public void setMovie_categoryList(List<Movie> movie_categoryList) {
        this.movie_categoryList = movie_categoryList;
    }


}

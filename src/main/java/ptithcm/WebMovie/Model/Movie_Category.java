//package ptithcm.WebMovie.Model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "Movie_Category")
//public class Movie_Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private Movie movie;
//
//    @ManyToOne
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//    public Movie_Category() {
//    }
//
//    public Movie_Category(Movie movie, Category category) {
//        this.movie = movie;
//        this.category = category;
//    }
//
//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//}

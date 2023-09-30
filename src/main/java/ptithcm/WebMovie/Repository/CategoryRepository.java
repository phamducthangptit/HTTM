package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

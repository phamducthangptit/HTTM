package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Language;

@Repository
public interface LanguageRepository extends JpaRepository <Language,Integer> {
}

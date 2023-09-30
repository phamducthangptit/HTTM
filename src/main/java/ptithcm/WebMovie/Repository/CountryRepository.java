package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
    Country findByname(String name);
    Country findById(int id);
}

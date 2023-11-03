package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Company;

@Repository
public interface CompanyRepository extends JpaRepository <Company,Integer>{
}

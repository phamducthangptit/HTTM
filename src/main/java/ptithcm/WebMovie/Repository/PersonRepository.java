package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Person;

import java.util.List;
import java.util.Map;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Integer>{
    @Query(value ="{call Person_id_name()}", nativeQuery = true)
    List<Map<String,?>> getPerson();
}

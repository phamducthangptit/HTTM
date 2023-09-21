package ptithcm.WebMovie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}

package ptithcm.WebMovie.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ptithcm.WebMovie.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByuserNameAndPassword(String userName, String password);
    User findByuserName(String userName);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :newPass where u.userName = :userName")
    void changePass(@Param("newPass") String newPass, @Param("userName") String userName);

    @Modifying
    @Transactional
    @Query("update User u set u.password = :newPass where u.userName = :userName and u.email = :email")
    void resetPass(@Param("newPass") String newPass, @Param("userName") String userName, @Param("email") String email);

    @Modifying
    @Transactional
    @Query("update User u set u.name = :name, u.email = :email, u.avatar = :avatar where u.userName = :userName")
    void updateInformation(@Param("name") String name, @Param("email") String email, @Param("userName") String userName, @Param("avatar") String avatar);

    User findByuserNameAndEmail(String userName, String email);


}

package az.khayal.springrestfiltering.repository;
import az.khayal.springrestfiltering.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Integer> {

   boolean existsByEmail(String email);

}

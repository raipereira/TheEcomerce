package raiper.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raiper.com.ecomerce.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String userEmail);
}

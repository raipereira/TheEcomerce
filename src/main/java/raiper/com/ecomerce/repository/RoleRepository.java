package raiper.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raiper.com.ecomerce.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRole(String role);
}

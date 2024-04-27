package raiper.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raiper.com.ecomerce.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

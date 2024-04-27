package raiper.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raiper.com.ecomerce.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}

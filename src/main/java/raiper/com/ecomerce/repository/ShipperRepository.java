package raiper.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raiper.com.ecomerce.model.Shipper;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
}

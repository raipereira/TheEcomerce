package raiper.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raiper.com.ecomerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}

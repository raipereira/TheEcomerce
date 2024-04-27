package raiper.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raiper.com.ecomerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

package raiper.com.ecomerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import raiper.com.ecomerce.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}

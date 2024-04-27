package raiper.com.ecomerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;
    private Integer quantity;
    private double price;
    @ManyToOne
    @MapsId("order")
    @JoinColumn(name = "order_id")
    private Order order;
}

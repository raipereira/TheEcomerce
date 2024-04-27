package raiper.com.ecomerce.dto.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductResponse(Integer productId,
                             String productName,
                             String productDescription,
                             Double productPrice,
                             Integer productQuantity,
                             String productImageUrl) {
}

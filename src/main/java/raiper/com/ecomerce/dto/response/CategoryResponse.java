package raiper.com.ecomerce.dto.response;

import jakarta.persistence.OneToMany;
import raiper.com.ecomerce.model.Product;

import java.util.List;

public record CategoryResponse(
         Integer categoryId,
         String categoryName,
         String description,
         List<ProductResponse> products
) {


}

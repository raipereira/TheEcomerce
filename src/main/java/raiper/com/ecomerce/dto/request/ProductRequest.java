package raiper.com.ecomerce.dto.request;

import raiper.com.ecomerce.dto.response.CategoryResponse2;

public record ProductRequest(String productName,
                             String productDescription,
                             Double productPrice,
                             Integer productQuantity,
                             String productImageUrl,
                             CategoryRequest category,
                             SupplierRequest supplier) {
}

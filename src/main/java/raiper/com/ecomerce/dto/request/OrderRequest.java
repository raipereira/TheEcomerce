package raiper.com.ecomerce.dto.request;

public record OrderRequest(String userEmail, Integer productId, Integer quantity,
                           double productPrice, String paymentType) {
}

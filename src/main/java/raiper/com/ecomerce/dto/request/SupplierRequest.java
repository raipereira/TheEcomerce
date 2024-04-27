package raiper.com.ecomerce.dto.request;

public record SupplierRequest(
         String supplierName,
         String supplierPhone,
         String supplierEmail,
         AddressRequest supplierAddress
) {
}

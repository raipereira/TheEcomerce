package raiper.com.ecomerce.dto.response;

import raiper.com.ecomerce.model.Address;

public record CustomerResponse(Integer customerId,
                               String firstName,
                               String lastName,
                               String phoneNumber,
                               String email,
                               AddressResponse address
                               ) {
}

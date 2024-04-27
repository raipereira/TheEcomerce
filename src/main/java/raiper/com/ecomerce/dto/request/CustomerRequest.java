package raiper.com.ecomerce.dto.request;

import raiper.com.ecomerce.dto.response.AddressResponse;

public record CustomerRequest(
                              String firstName,
                              String lastName,
                              String phoneNumber,
                              String email,
                              String userName,
                              String password,
                              AddressRequest address
                               ) {
}

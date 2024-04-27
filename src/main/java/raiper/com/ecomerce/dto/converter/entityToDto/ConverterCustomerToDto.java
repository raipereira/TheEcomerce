package raiper.com.ecomerce.dto.converter.entityToDto;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import raiper.com.ecomerce.dto.response.CustomerResponse;
import raiper.com.ecomerce.model.Customer;

@Component
public class ConverterCustomerToDto implements Converter<Customer, CustomerResponse> {

    private ConverterAddressToDto toAddressDTO;

    public ConverterCustomerToDto(ConverterAddressToDto toAddressDTO) {
        this.toAddressDTO = toAddressDTO;
    }

    @Override
    public CustomerResponse convert(Customer source) {
        var customerResponse =  new CustomerResponse(source.getCustomerId(),
                source.getFirstName(),
                source.getLastName(),
                source.getPhoneNumber(),
                source.getEmail(),
                toAddressDTO.convert(source.getAddress()));
        return customerResponse;
    }
}

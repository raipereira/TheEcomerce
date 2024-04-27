package raiper.com.ecomerce.dto.converter.dtoToEntity;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import raiper.com.ecomerce.dto.request.CustomerRequest;
import raiper.com.ecomerce.model.Customer;
import raiper.com.ecomerce.model.User;

@Component
public class ConverterRequestToCustomer implements Converter<CustomerRequest, Customer> {

    private ConverterRequestToAddress addressRequestDTO;

    public ConverterRequestToCustomer(ConverterRequestToAddress addressRequestDTO) {
        this.addressRequestDTO = addressRequestDTO;
    }

    @Override
    public Customer convert(CustomerRequest source) {
        var customer =  new Customer().builder()
                .firstName(source.firstName())
                .lastName(source.lastName())
                .phoneNumber(source.phoneNumber())
                .user(new User(source.userName(), source.password(), source.email()))
                .address(addressRequestDTO.convert(source.address()))
                .build();
        return customer;
    }
}

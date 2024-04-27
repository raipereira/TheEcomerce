package raiper.com.ecomerce.dto.converter.dtoToEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import raiper.com.ecomerce.dto.request.AddressRequest;
import raiper.com.ecomerce.model.Address;

@Component
public class ConverterRequestToAddress implements Converter<AddressRequest, Address> {
    @Override
    public Address convert(AddressRequest source) {
        var address = new Address().builder().state(source.state())
                .city(source.city())
                .street(source.street())
                .zipCode(source.zip())
                .build();
        return address;
    }
}

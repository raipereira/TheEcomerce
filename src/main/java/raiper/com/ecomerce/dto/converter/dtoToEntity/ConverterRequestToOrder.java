package raiper.com.ecomerce.dto.converter.dtoToEntity;

import org.springframework.core.convert.converter.Converter;
import raiper.com.ecomerce.dto.request.OrderRequest;
import raiper.com.ecomerce.model.Order;

import java.time.LocalDate;

public class ConverterRequestToOrder implements Converter<OrderRequest, Order> {


    @Override
    public Order convert(OrderRequest source) {

        return null;
    }
}

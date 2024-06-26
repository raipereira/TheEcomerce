package raiper.com.ecomerce.dto.converter.entityToDto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import raiper.com.ecomerce.dto.response.ProductResponse;
import raiper.com.ecomerce.model.Product;

@Component
public class ConverterProductToDto implements Converter<Product, ProductResponse> {

    @Override
    public ProductResponse convert(Product source) {
        var productResponse = new ProductResponse(source.getProductId(),
                source.getProductName(),
                source.getProductDescription(),
                source.getProductPrice(),
                source.getProductQuantity(),
                source.getProductImageUrl());
        return productResponse;
    }
}

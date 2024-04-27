package raiper.com.ecomerce.dto.converter.dtoToEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import raiper.com.ecomerce.dto.request.SupplierRequest;
import raiper.com.ecomerce.model.Supplier;

@Component
public class ConverterRequestToSupplier implements Converter<SupplierRequest, Supplier> {

    private ConverterRequestToAddress toAddress;

    public ConverterRequestToSupplier(ConverterRequestToAddress toAddress) {
        this.toAddress = toAddress;
    }

    @Override
    public Supplier convert(SupplierRequest source) {
        var supplier = new Supplier().builder()
                .supplierName(source.supplierName())
                .supplierEmail(source.supplierEmail())
                .supplierPhone(source.supplierPhone())
                .supplierAddress(toAddress.convert(source.supplierAddress()))
                .build();
        return supplier;
    }
}

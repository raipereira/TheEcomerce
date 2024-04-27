package raiper.com.ecomerce.controller;


import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raiper.com.ecomerce.dto.response.AddressResponse;
import raiper.com.ecomerce.model.Address;
import raiper.com.ecomerce.result.Result;
import raiper.com.ecomerce.result.StatusCode;
import raiper.com.ecomerce.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private AddressService addressService;
    private ConversionService conversionService;

    public AddressController(AddressService addressService, ConversionService conversionService) {
        this.addressService = addressService;
        this.conversionService = conversionService;
    }

    @GetMapping("/")
    public List<Address> getAllAddresses() {
        return null;
    }
    @GetMapping("/{addressId}")
    public Result getAddressById(@PathVariable Integer addressId) {
        var address = addressService.getByIdAddress(addressId);
        var addressResponse = conversionService.convert(address, AddressResponse.class);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", addressResponse);
    }
}

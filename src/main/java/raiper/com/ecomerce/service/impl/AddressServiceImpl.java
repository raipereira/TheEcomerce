package raiper.com.ecomerce.service.impl;

import org.springframework.stereotype.Service;
import raiper.com.ecomerce.exception.AddressNotFoundException;
import raiper.com.ecomerce.model.Address;
import raiper.com.ecomerce.repository.AddressRepository;
import raiper.com.ecomerce.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {


    private AddressRepository repo;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.repo = addressRepository;
    }

    @Override
    public Address getByIdAddress(Integer addressId) {
        return repo.findById(addressId).orElseThrow(() -> new AddressNotFoundException(addressId));
    }
}

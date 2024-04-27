package raiper.com.ecomerce.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import raiper.com.ecomerce.exception.AddressNotFoundException;
import raiper.com.ecomerce.model.Address;
import raiper.com.ecomerce.repository.AddressRepository;
import raiper.com.ecomerce.service.impl.AddressServiceImpl;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AddressServiceTest {
    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getByIdAddressSuccess() {
        // Given: Arrange input and target. Define the behavior of the mock object addressRepository
        var address = new Address().builder()
                .addressId(1).state("Fairfield").street("1000 4th St").state("Iowa")
                .zipCode("25557").build();
        given(addressRepository.findById(1)).willReturn(Optional.of(address)); // define behavior of mock object
        // when(addressRepository.findById(1)).thenReturn(Optional.of(address));

        // When. Act on the target behavior. When steps should cover the method to be tested
        Address returnAddress = addressService.getByIdAddress(1);

        // Then. Assert expected outcomes.
        assertNotNull(returnAddress);
        assertThat(returnAddress.getAddressId()).isEqualTo(address.getAddressId());
        assertThat(returnAddress.getState()).isEqualTo(address.getState());
        assertThat(returnAddress.getZipCode()).isEqualTo(address.getZipCode());
        assertThat(returnAddress.getStreet()).isEqualTo(address.getStreet());
        verify(addressRepository, times(1)).findById(1);

    }

    @Test
    void getByIdAddressNotFound() {
        //given
        given(addressRepository.findById(Mockito.any(Integer.class))).willReturn(Optional.empty());
        //when
        Throwable thrown = catchThrowable(() -> {
                    Address returnAddress = addressService.getByIdAddress(1);
                });
        //then
        assertThat(thrown)
                .isInstanceOf(AddressNotFoundException.class)
                .hasMessage("Could not find address with id 1 :(" );
        verify(addressRepository, times(1)).findById(1);
    }
}
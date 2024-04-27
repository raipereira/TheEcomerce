package raiper.com.ecomerce.controller;

import org.springframework.web.bind.annotation.*;
import raiper.com.ecomerce.dto.converter.dtoToEntity.ConverterRequestToCustomer;
import raiper.com.ecomerce.dto.converter.entityToDto.ConverterCustomerToDto;
import raiper.com.ecomerce.dto.request.CustomerRequest;
import raiper.com.ecomerce.result.Result;
import raiper.com.ecomerce.result.StatusCode;
import raiper.com.ecomerce.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;
    private ConverterCustomerToDto converterCustomerToCustomerDTO;
    private ConverterRequestToCustomer requestDtoToCustomer;

    public CustomerController(CustomerService customerService,
                              ConverterCustomerToDto toCustomerDTO,
                              ConverterRequestToCustomer requestDtoToCustomer) {
        this.customerService = customerService;
        this.converterCustomerToCustomerDTO = toCustomerDTO;
        this.requestDtoToCustomer = requestDtoToCustomer;
    }

    @GetMapping()
    public Result getAllCustomers() {
        var customers = customerService.findAllCustomers();
        var customersResponse =  customers.stream().map(customer -> converterCustomerToCustomerDTO.convert(customer)).toList();
        return new Result(true, StatusCode.SUCCESS, "Find All Success", customersResponse);
    }

    @PostMapping()
    public Result addCustomer(@RequestBody CustomerRequest customerRequest) {
        var newCustomer =  customerService.createNewCustomer(requestDtoToCustomer.convert(customerRequest));
        var customerResponse = converterCustomerToCustomerDTO.convert(newCustomer);
        return new Result(true, StatusCode.SUCCESS, "Save Success", customerResponse);

    }
}

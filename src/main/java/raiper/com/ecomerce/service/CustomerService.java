package raiper.com.ecomerce.service;

import raiper.com.ecomerce.model.Customer;
import raiper.com.ecomerce.repository.CustomerRepository;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomers();


    Customer createNewCustomer(Customer customer);
}

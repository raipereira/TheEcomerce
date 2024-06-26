package raiper.com.ecomerce.service.impl;

import org.springframework.stereotype.Service;
import raiper.com.ecomerce.model.Customer;
import raiper.com.ecomerce.model.Role;
import raiper.com.ecomerce.repository.CustomerRepository;
import raiper.com.ecomerce.repository.RoleRepository;
import raiper.com.ecomerce.repository.UserRepository;
import raiper.com.ecomerce.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               RoleRepository roleRepository,
                               UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer createNewCustomer(Customer customer) {

        List<Role> listAdminRoles = new ArrayList<>();
        var adminRole = roleRepository.findByRole("ROLE_CUSTOMER");
        if(adminRole.isEmpty()) {
            var newAdminRole = Role.builder().role("ROLE_CUSTOMER").build();
            listAdminRoles.add(newAdminRole);
        } else {
            listAdminRoles.add(adminRole.get());
        }
        var user = customer.getUser();
        user.setRoles(listAdminRoles);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCustomer(customer);

        user = this.userRepository.save(user);

        return user.getCustomer();
    }
}

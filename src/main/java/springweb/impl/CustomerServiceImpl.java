package springweb.impl;

import springweb.dto.Login;
import springweb.entity.Customer;
import springweb.repository.CustomerRepository;
import springweb.service.CustomerService;


public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public boolean checkLogin(final Login login) {
        Customer customer = customerRepository.findByFullNameAndPassword(login.getFullName(), login.getPassword()).orElse(null);
        if (customer == null) {
            return false;
        }
        return true;
    }
}

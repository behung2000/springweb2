package springweb.services;

import org.springframework.beans.BeanUtils;
import springweb.dto.CustomerDto;
import springweb.requests.Login;
import springweb.entity.Customer;
import springweb.repository.CustomerRepository;


public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Chức năng login (chức năng 1: Đăng nhập)
     * Login -> check db customer with object login (full name vs password)
     * @param login
     * @return boolean
     */
    public Integer checkLogin(final Login login) {
        Customer customer = customerRepository.findByFullNameAndPassword(login.getFullName(), login.getPassword()).orElse(null);
        if (customer == null) {
            return null;
        }
        return customer.getId();
    }

    /**
     * Chức năng đăng ký (chức năng 2: Đăng ký)
     * Add 1 customer
     * @param customerDto
     * @return CustomerDto
     */
    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = Customer.builder().build();
        BeanUtils.copyProperties(customerDto, customer);
        Customer saved = customerRepository.save(customer);
        CustomerDto response = CustomerDto.builder().build();
        BeanUtils.copyProperties(saved, response);
        return response;
    }
}

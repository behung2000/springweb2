package springweb.config;

import springweb.impl.CustomerServiceImpl;
import springweb.repository.CustomerRepository;
import springweb.repository.VegetableRepository;
import springweb.service.CustomerService;
import springweb.service.VegetableService;
import springweb.impl.VegetableServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("springweb.entity")
@EnableJpaRepositories("springweb.repository")
public class Config {
    @Bean
    public VegetableService vegetableService(VegetableRepository vegetableRepository) {
        return new VegetableServiceImpl(vegetableRepository);
    }

    @Bean
    public CustomerService customerService(CustomerRepository customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }
}

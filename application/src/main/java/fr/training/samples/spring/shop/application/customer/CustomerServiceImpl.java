package fr.training.samples.spring.shop.application.customer;


import fr.training.samples.spring.shop.domain.common.exception.AlreadyExistingException;
import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


        private final CustomerRepository customerRepository;

        public CustomerServiceImpl(final CustomerRepository customerRepository){
            this.customerRepository = customerRepository;
        }

    @Override
    public Customer create(Customer customer) {
            final Customer existingCustomer=customerRepository.findByName(customer.getName());
            if (existingCustomer!=null) {
                throw new AlreadyExistingException("client déjà existant !!!");
            }
            customerRepository.save(customer);
            return customer;
    }

    @Override
    public Customer findOne(String customerId) {

            return customerRepository.findById(customerId);
    }

    @Override
    public void update(Customer customer) {
    }

    @Override
    public Customer findByName(String name) {
            return customerRepository.findByName(name);
           }
}


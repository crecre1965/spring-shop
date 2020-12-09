package fr.training.samples.spring.shop.application.customer;


import fr.training.samples.spring.shop.domain.common.exception.AlreadyExistingException;
import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import fr.training.samples.spring.shop.domain.customer.RoleTypeEnum;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomerServiceImpl implements CustomerService {


        private final CustomerRepository customerRepository;
        private final PasswordEncoder passwordEncoder;

        public CustomerServiceImpl(final CustomerRepository customerRepository,
                                   final PasswordEncoder passwordEncoder){
            this.customerRepository = customerRepository;
            this .passwordEncoder=passwordEncoder;
        }

    @Override
    @Transactional
    public Customer create(Customer customer) {
            final Customer existingCustomer=customerRepository.findByName(customer.getName());
            if (existingCustomer!=null) {
                throw new AlreadyExistingException("client déjà existant !!!");
            }
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        // New customer has user role by default
            customer.addRole(RoleTypeEnum.ROLE_USER);
            customerRepository.save(customer);
            return customer;
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findOne(String customerId) {

            return customerRepository.findById(customerId);
    }
    @Secured("ROLE-USER")
    @Override
    @Transactional
    public void update(final String customerId,Customer customer) {
        final Customer customerToUpdate = customerRepository.findById(customerId);
        customerToUpdate.setName(customer.getName());
        customerToUpdate.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public Customer findByName(String name) {
            return customerRepository.findByName(name);
           }
}


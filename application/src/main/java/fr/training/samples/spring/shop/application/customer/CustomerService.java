package fr.training.samples.spring.shop.application.customer;

import fr.training.samples.spring.shop.domain.customer.Customer;

public interface CustomerService {
    public Customer create(Customer customer);
    public Customer findOne(String customerId);
    public Customer findByName(String customerName);
    public void update (Customer customer);
}

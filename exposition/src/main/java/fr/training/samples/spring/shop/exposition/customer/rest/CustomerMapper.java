package fr.training.samples.spring.shop.exposition.customer.rest;

import fr.training.samples.spring.shop.commun.AbstractMapper;
import fr.training.samples.spring.shop.domain.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CustomerMapper extends AbstractMapper<CustomerDto,Customer > {

    @Override
    public CustomerDto mapToDto(final Customer entity) {
        final CustomerDto dto=new CustomerDto();
        dto.setCustomerID(entity.getId());
        dto.setName(entity.getName());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    @Override
    public Customer mapToEntity(CustomerDto dto) {
        final Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setPassword(dto.getPassword());
        customer.setId(dto.getCustomerID());
        return customer;
    }

    public Customer mapToEntity(CustomerLightDto dto){
        final Customer customer= new Customer();
        customer.setName(dto.getName());
        customer.setPassword(dto.getName());
        return customer;
    }
}

package fr.training.samples.spring.shop.exposition.customer.rest;

import fr.training.samples.spring.shop.application.customer.CustomerService;
import fr.training.samples.spring.shop.application.order.OrderService;
import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.order.Order;
import fr.training.samples.spring.shop.exposition.order.rest.OrderDto;
import fr.training.samples.spring.shop.exposition.order.rest.OrderLightDto;
import fr.training.samples.spring.shop.exposition.order.rest.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {


    private final CustomerService customerService;
    private final CustomerMapper customerEntityMapper;

    private final OrderService orderService;
    private final OrderMapper orderEntityMapper;


    //Contructor pour bean Injection (evite @Autowired)
    public CustomerResource(CustomerService customerService,
                            CustomerMapper customerEntityMapper,
                            OrderService orderService,
                            OrderMapper orderEntityMapper) {
        this.customerService = customerService;
        this.customerEntityMapper=customerEntityMapper;
        this.orderService=orderService;
        this.orderEntityMapper=orderEntityMapper;
    }


    // Restituer le client : Get

    @GetMapping(value="/customers/{id}",produces  ={"application/json"})
    public CustomerDto getCustomer(@PathVariable final String id){

        final Customer customer=customerService.findOne(id);

        return customerEntityMapper.mapToDto(customer);
    }

    // Créer le client : Post

    @PostMapping(value="/customers", produces = {"application/json"}, consumes={"application/json"})
    public ResponseEntity<URI> addCustomerUsingPost(@Valid @RequestBody CustomerLightDto customerLightDto){

        final Customer customer=customerEntityMapper.mapToEntity(customerLightDto);
        customerService.create(customer);
        final URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(customer.getId()).toUri();

       return ResponseEntity.created(location).build();
    }


    //Modifer un client : Put

    @PutMapping(value="/customers/{id}",consumes="application/json",produces="application/json")
    public ResponseEntity<URI> updateCustomerUsingPut(@PathVariable final String id, @RequestBody final CustomerDto customerDto){

        customerDto.setCustomerID(id);
        final Customer customer=customerEntityMapper.mapToEntity(customerDto);
        customerService.update(customer);

        final URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(customer.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

// restituer les commandes d'un client : Get
    @GetMapping(value="/customers/{id}/orders", produces="application/json")
    public List<OrderDto> getOrders(@PathVariable final String id) {
        final List<Order> orders = orderService.findOrdersByCustomerId(id);
        return orderEntityMapper.mapToDtoList(orders);


    }
}

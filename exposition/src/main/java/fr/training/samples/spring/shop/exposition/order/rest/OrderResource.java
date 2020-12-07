package fr.training.samples.spring.shop.exposition.order.rest;



import fr.training.samples.spring.shop.application.order.OrderService;
import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.order.Order;
import fr.training.samples.spring.shop.exposition.item.rest.ItemLightDto;
import fr.training.samples.spring.shop.exposition.item.rest.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderResource {

    private OrderService orderService;
    private OrderMapper orderMapper;

    public OrderResource(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @PostMapping(value="/orders",consumes="application/json",produces="application/json")

    public ResponseEntity<URI> createOrderUsingPost(@RequestBody final OrderLightDto orderLightDto){
        final Order order = orderService.addOrder(orderLightDto.getCustomerID(),orderLightDto.getItems());
        final URI loccation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(loccation).build();
    }




}

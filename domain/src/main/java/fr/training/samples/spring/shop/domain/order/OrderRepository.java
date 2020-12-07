package fr.training.samples.spring.shop.domain.order;

import fr.training.samples.spring.shop.domain.item.Item;

import java.util.List;

public interface OrderRepository {
    public Order findById(String orderId);
    public void save (Order order);
    public List<Order> findOrdersByCustomerId(String customerID);
    };



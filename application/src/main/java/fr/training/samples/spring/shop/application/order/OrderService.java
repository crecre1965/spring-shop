package fr.training.samples.spring.shop.application.order;

import fr.training.samples.spring.shop.domain.order.Order;

import java.util.List;

public interface OrderService {
    public Order addOrder(String customerId, List<String> itemIds);
    public List<Order> findOrdersByCustomerId(String customerId);
    public Order findOne(String orderId);

}

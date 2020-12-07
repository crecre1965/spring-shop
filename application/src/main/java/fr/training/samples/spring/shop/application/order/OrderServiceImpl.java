package fr.training.samples.spring.shop.application.order;

import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.order.Order;
import fr.training.samples.spring.shop.domain.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;
    private CustomerRepository customerRepository;

    private List<Order> orders=new ArrayList<>();

    public OrderServiceImpl(OrderRepository orderRepository, final CustomerRepository customerRepository, final ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository=itemRepository;
        this.customerRepository=customerRepository;

    }

    @Override
    public Order findOne(String orderId) {
        return null;
    }

    @Override
    public Order addOrder(final String customerId, final List<String> itemIds) {
        final Customer customer = customerRepository.findById(customerId);
        final Order order=new Order();
        order.setCustomer(customer);
        final List<Item> items= itemRepository.findById(itemIds);
        for (final Item item :items)
        {
            order.addItem(item);
            order.setTotal(Integer.sum(order.getTotal(), item.getPrice()));
        }
        orderRepository.save(order);
        return order;
    }
    // client repo pour recherche cusomer par id
    // creer une nouvelle méthjode ou boucler id par id avec la methose fin by id de item repo


    public List<Order> findOrdersByCustomerId(String customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);

    }
}

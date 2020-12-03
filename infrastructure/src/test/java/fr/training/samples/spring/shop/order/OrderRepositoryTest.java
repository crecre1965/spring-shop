package fr.training.samples.spring.shop.order;

import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.order.Order;
import fr.training.samples.spring.shop.domain.order.OrderRepository;
import org.junit.Test;
import org.junit.platform.engine.reporting.ReportEntry;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void existing_order_should_be_found(){

        // Given
        final String orderId="123e4567-189b-42d3-a456-556642440000";
        // When
        final Order order=orderRepository.findById(orderId);
        // Then
        assertThat(order).isNotNull();
        assertThat(order.getId()).isEqualTo(orderId);
        assertThat(order.getCustomer().getName()).isEqualTo("NAME1");
    }
    @Test
    public void save_new_order(){

        // Given
        final Order order = new Order();
        final Customer customer = customerRepository.findById("123e4567-e89b-42d3-a456-556642440000");
        final Item item = itemRepository.findById("123e4567-e89b-42d3-a456-556642440005");
        order.setCustomer(customer);
        order.addItem(item);
        // When
        orderRepository.save(order);
        // Then
        assertThat(orderRepository.findById(order.getId())).isNotNull();

    }
}

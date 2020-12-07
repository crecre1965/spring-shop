package fr.training.samples.spring.shop.exposition.order.rest;


import fr.training.samples.spring.shop.commun.AbstractMapper;
import fr.training.samples.spring.shop.domain.order.Order;
import fr.training.samples.spring.shop.exposition.customer.rest.CustomerMapper;
import fr.training.samples.spring.shop.exposition.item.rest.ItemMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper extends AbstractMapper<OrderDto, Order> {
    private CustomerMapper customerMapper;
    private ItemMapper itemMapper;

    public OrderMapper(CustomerMapper customerMapper, ItemMapper itemMapper) {
        this.customerMapper = customerMapper;
        this.itemMapper = itemMapper;
    }

    @Override
    public OrderDto mapToDto(Order entity) {
        OrderDto dto = new OrderDto();
        dto.setCustomer(customerMapper.mapToDto(entity.getCustomer()));
        dto.setOrderID(entity.getId());
        dto.setItems(itemMapper.mapToDtoList(entity.getItems()));
        return dto;
    }

    @Override
    public Order mapToEntity(OrderDto dto) {
         return null;
    }


}

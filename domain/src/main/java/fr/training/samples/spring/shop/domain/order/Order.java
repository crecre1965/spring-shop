package fr.training.samples.spring.shop.domain.order;

import fr.training.samples.spring.shop.domain.common.entity.AbstractBaseEntity;
import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.item.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order extends AbstractBaseEntity {
        @ManyToOne
        @JoinColumn(name="CUSTOMER_ID")
        private Customer customer;

        @ManyToMany(targetEntity = Item.class,cascade= CascadeType.ALL)
        private List<Item> items=new ArrayList<>();

        private Integer total;

        public Customer getCustomer() {
                return customer;
        }

        public void setCustomer(Customer customer) {
                this.customer = customer;
        }

        public List<Item> getItems() {
                return items;
        }

        public void setItems(List<Item> items) {
                this.items = items;
        }

        public Integer getTotal() {
                return total;
        }

        public void setTotal(Integer total) {
                this.total = total;
        }
        public void addItem(final Item item){
                items.add(item);
        }
}

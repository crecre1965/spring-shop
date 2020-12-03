package fr.training.samples.spring.shop.domain.item;

import java.util.List;

public interface ItemRepository {
    public Item findById(String id);
    public void save (Item item);
    public List<Item> findAll();
}

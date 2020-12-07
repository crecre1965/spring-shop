package fr.training.samples.spring.shop.application.item;


import fr.training.samples.spring.shop.domain.item.Item;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item);
    public List<Item> getAllItems();


}

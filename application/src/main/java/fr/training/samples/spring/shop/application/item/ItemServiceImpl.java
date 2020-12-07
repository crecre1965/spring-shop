package fr.training.samples.spring.shop.application.item;

import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item addItem(Item item) {
        itemRepository.save(item);
        return item;
          }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}

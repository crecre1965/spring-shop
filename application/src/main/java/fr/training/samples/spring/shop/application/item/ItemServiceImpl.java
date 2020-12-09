package fr.training.samples.spring.shop.application.item;

import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Secured("ROLE-ADMIN")
    @Override
    @Transactional
    public Item addItem(Item item) {
        itemRepository.save(item);
        return item;
          }

    @Override
    @Transactional(readOnly=true)
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}

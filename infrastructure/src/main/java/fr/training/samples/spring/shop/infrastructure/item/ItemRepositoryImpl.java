package fr.training.samples.spring.shop.infrastructure.item;


import fr.training.samples.spring.shop.domain.common.exception.NotFoundException;
import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private ItemJpaRepository itemDataJpaRepository;
    public ItemRepositoryImpl(final ItemJpaRepository itemDataJpaRepository){
        this.itemDataJpaRepository=itemDataJpaRepository;
    }
    @Override
    public Item findById(final String id){
        return itemDataJpaRepository.findById(id).orElseThrow(()-> new NotFoundException());
    }

       @Override
    public void save(final Item item) {
        itemDataJpaRepository.save(item);
    }


//    @Override
    public List<Item> findAll(){
        return itemDataJpaRepository.findAll();
    }

    @Override
    public List<Item> findById(List<String> ids) {
        return itemDataJpaRepository.findAll();
    }
}

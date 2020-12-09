package fr.training.samples.spring.shop.exposition.item.rest;

import fr.training.samples.spring.shop.exposition.common.AbstractMapper;
import fr.training.samples.spring.shop.domain.item.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper extends AbstractMapper<ItemDto,Item> {
    @Override
    public ItemDto mapToDto(Item entity) {
        final ItemDto dto= new ItemDto();
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        dto.setItemID(entity.getId());
        return dto;
    }

    @Override
    public Item mapToEntity(ItemDto dto) {
        final Item entity=new Item();
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        entity.setId(dto.getItemID());
        return entity;
    }

    public Item mapToEntity(ItemLightDto dto) {
        final Item entity=new Item();
        entity.setPrice(dto.getPrice());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}

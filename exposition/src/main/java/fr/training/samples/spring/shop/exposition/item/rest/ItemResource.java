package fr.training.samples.spring.shop.exposition.item.rest;

import fr.training.samples.spring.shop.application.item.ItemService;
import fr.training.samples.spring.shop.domain.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemResource {

    private ItemService itemService;
    private ItemMapper itemMapper;

public ItemResource(final ItemService itemService, final ItemMapper itempMapper){
    this.itemService=itemService;
    this.itemMapper=itempMapper;
}

    @GetMapping(value = "/items", produces = "application/json")
    public List<ItemDto> getAllItemsUsingGet() {
    final List<Item> items=itemService.getAllItems();
        return itemMapper.mapToDtoList(items);
    }

    @PostMapping(value="/items",consumes="application/json",produces="application/json")
    public ResponseEntity<URI> addItemUsingPost(@RequestBody final ItemLightDto itemLightDto){
        Item item =itemService.addItem(itemMapper.mapToEntity(itemLightDto));
        URI loccation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(loccation).build();
    }

}

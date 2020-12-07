package fr.training.samples.spring.shop.application.item;


import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void
    existing_item_should_be_found(){
        //Given existing item in db
        final String idItem="123e4567-e89b-42d3-a456-556642440001";

        //When
        final Item item=itemRepository.findById(idItem);


        //Then
        Object assertThat;
        assertThat(item).isNotNull();
        assertThat(item.getDescription()).isEqualTo("DESC1");
        assertThat(item.getPrice()).isEqualTo(10);
    }
    @Test
    public void save_new_item_should_success() {
        // Given
        final Item item = new Item();
        item.setDescription("item lolo");
        item.setPrice(100);
        // When
        itemRepository.save(item);
        // Then
        assertThat(itemRepository.findById(item.getId())).isNotNull();
    }
    @Test
    public void get_all_items() {
        // Given

        // When

        // Then
        final List<Item> listeDesItems=itemRepository.findAll();
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
        for(int i=0;i<listeDesItems.size();i++) {
            System.out.println(listeDesItems.get(i).getId() + " " + listeDesItems.get(i).getDescription());
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        assertThat(listeDesItems).hasSize(5);
    }
}

package fr.training.samples.spring.shop.application.item;

import fr.training.samples.spring.shop.application.item.ItemService;
import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.item.Item;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemTest {

    @Autowired
    private ItemService itemService;

    @MockBean
    private ItemRepository itemRepositoryMock;

    @Test
    public void add_Item_should_success(){

        //Given
        final Item item =new Item();
        item.setDescription("Article Lolo");
        item.setPrice(10);

        //When
        final Item expected=itemService.addItem(item);
        //Then

        assertThat(expected).isNotNull();
        verify(itemRepositoryMock, Mockito.times(1)).save(item);
    }

}

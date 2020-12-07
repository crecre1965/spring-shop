package fr.training.samples.spring.shop.application.customer;

import fr.training.samples.spring.shop.domain.customer.Customer;
import fr.training.samples.spring.shop.domain.customer.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={CustomerServiceImpl.class})

public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepositoryMock;

    @Test
    public void create_Customer_should_success_when_not_already_exist(){
        //Given
        final Customer customer =new Customer();
        customer.setName("Michel Dupont");
        customer.setPassword("toto");
        when(customerRepositoryMock.findByName("name")).thenReturn(null);
        //When
        final Customer result=customerService.create(customer);

        //Then
        assertThat(result).isNotNull();
        verify(customerRepositoryMock, Mockito.times(1)).save(customer);
    }
}

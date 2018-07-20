package library.service;

import library.domain.Customer;
import library.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    @Before
    public void setUp() {
        this.customerService = new CustomerService(customerRepository);
    }

    @Test
    public void getByNameGivesEmptyListIfNoUserFound() {
        List<Customer> users = customerService.getByName("some name");
        assertEquals(0, users.size());
    }

    @Test
    public void getByNameGivesAListUserWhenFirstNameMatches() {
        Customer customer = new Customer("ishu", "sing");

        when(customerRepository.findByFirstName("ishu")).thenReturn(Collections.singletonList(customer));

        List<Customer> users = customerService.getByName("ishu");

        assertEquals(1, users.size());
    }

    @Test
    public void getByNameGivesAListUserWhenLastNameMatches() {
        Customer customer = new Customer("firstName", "lastName");

        when(customerRepository.findByLastName("lastName")).thenReturn(Collections.singletonList(customer));

        List<Customer> users = customerService.getByName("lastName");

        assertEquals(1, users.size());
    }
}
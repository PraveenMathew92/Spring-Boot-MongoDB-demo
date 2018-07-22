package library.service;

import library.domain.Customer;
import library.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;
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
    public void getByNameGivesTheUserWhenFirstNameMatches() {
        Customer customer = new Customer("ishu", "sing");

        when(customerRepository.findByFirstName("ishu")).thenReturn(Collections.singletonList(customer));

        List<Customer> users = customerService.getByName("ishu");

        assertEquals(1, users.size());
    }

    @Test
    public void getByNameGivesTheUserWhenLastNameMatches() {
        Customer customer = new Customer("firstName", "lastName");

        when(customerRepository.findByLastName("lastName")).thenReturn(Collections.singletonList(customer));

        List<Customer> users = customerService.getByName("lastName");

        assertEquals(1, users.size());
    }

    @Test
    public void getByNameGivesTheListOfUsersWhenTheNameMatches() {
        Customer aCustomer = new Customer("Some", "Name");
        Customer anotherCustomer = new Customer("Name", "Another");

        when(customerRepository.findByFirstName("Name")).thenReturn(Collections.singletonList(anotherCustomer));
        when(customerRepository.findByLastName("Name")).thenReturn(Collections.singletonList(aCustomer));
        List<Customer> users = customerService.getByName("Name");

        assertEquals(2, users.size());
    }

    @Test
    public void getByDateOfBirthGivesAnEmptyListIfNoUserIsFound() {
        Customer customer = new Customer("Some", "Name");
        Date dateOfBirth = new Date(999);
        customer.setDateOfBirth(dateOfBirth);

        when(customerRepository.findByDateOfBirth(new Date())).thenReturn(Collections.emptyList());
        List<Customer> users = customerService.getByDateOfBirth(new Date());

        assertEquals(0, users.size());
    }

    @Test
    public void getByDateOfBirthGivesTheUsersWithDateOfBirth() {
        Customer customer = new Customer("firstName", "lastName");
        Date dateOfBirth = new Date();
        customer.setDateOfBirth(dateOfBirth);

        when(customerRepository.findByDateOfBirth(dateOfBirth)).thenReturn(Collections.singletonList(customer));
        List<Customer> users = customerService.getByDateOfBirth(dateOfBirth);

        assertEquals(1, users.size());
    }
}
package library.service;

import library.domain.Customer;
import library.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getByName(String name) {
        List<Customer> firstNames = customerRepository.findByFirstName(name);
        List<Customer> lastNames = customerRepository.findByLastName(name);
        List<Customer> allNames = Stream.concat(firstNames.stream(), lastNames.stream())
                .collect(Collectors.toList());
        return allNames;
    }

    public List<Customer> getByDateOfBirth(Date dateOfbirth){
        return customerRepository.findByDateOfBirth(dateOfbirth);
    }
}

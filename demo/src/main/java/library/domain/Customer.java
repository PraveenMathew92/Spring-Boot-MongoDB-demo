package library.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;
    public Date dateOfBirth;

    public Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
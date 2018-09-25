package library.domain;

import org.springframework.data.annotation.Id;

public class Address {
    @Id
    public String id;

    private String firstLine;
    private String secondLine;
    private String city;

    public Address(String firstLine, String secondLine, String city) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.city = city;
    }
}

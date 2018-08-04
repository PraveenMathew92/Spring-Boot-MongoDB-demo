package library.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class Reader {

    @Id
    private String id;

    private String name;
    public Address address;


    public Reader(String name) {
        this.name= name;
    }

    @Override
    public String toString() {
        return String.format(
                "Reader[id=%s, name='%s']",
                id, name);
    }

}
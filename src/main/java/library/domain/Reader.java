package library.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;


public class Reader {

    @Id
    private  String id;

    private final String name;
    private Address address;
    private Date dateOfBirth;
    private Date dateOfJoining;

    public Reader(String name) {
        this.name= name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format(
                "Reader[id=%s, name='%s']",
                id, name);
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}
package library.domain;

import org.springframework.data.annotation.Id;

public class Stock {

    @Id
    private String id;

    private String typeId;
    private boolean available;
}

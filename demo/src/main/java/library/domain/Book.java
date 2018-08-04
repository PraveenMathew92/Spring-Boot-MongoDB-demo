package library.domain;

import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private String typeId;

    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}

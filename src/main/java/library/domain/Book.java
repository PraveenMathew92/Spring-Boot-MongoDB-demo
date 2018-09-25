package library.domain;

import org.springframework.data.annotation.Id;

public class Book {
    @Id
    private final String isbn;

    private final String name;
    private final String author;

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }
}

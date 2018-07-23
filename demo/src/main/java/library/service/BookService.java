package library.service;

import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
}

package library.service;

import library.domain.Book;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void getBookByName(String name) {
    }

    public void update(Book book) {

    }

    public void add(Book book) {

    }

    public void delete(Book book) {

    }
}

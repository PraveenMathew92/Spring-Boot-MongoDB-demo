package library.service;

import library.domain.Book;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository, CopyService copyService) {
        this.bookRepository = bookRepository;
    }

    public void getBookByName(String name) {
    }

    public Book getBookById (String typeId){
        return bookRepository.findByTypeId(typeId);
    }

    public void add(Book book) {
        bookRepository.save(book);
    }

    public void delete(Book book) {

    }

    public void update(Book book) {

    }
}

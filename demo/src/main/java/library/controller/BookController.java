package library.controller;

import library.domain.Book;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{name}")
    public void getBook(@RequestParam String name) {
        bookService.getBookByName(name);
    }

    @PutMapping("/update")
    public void update(@RequestBody Book book){
        bookService.update(book);
    }

    @PostMapping("/add")
    public void addBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Book book) {
        bookService.delete(book);
    }
}

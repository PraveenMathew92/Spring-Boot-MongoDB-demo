package library.controller;

import library.domain.Book;
import library.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {
    @Mock
    private BookService bookService;

    private BookController bookController;

    @Before
    public void setUp() {
        bookController = new BookController(bookService);
    }

    @Test
    public void expectGetBookFunctionToBeCalled() {
        bookController.getBook("name");
        verify(bookService, times(1)).getBookByName("name");
    }

    @Test
    public void expectAddBookFunctionToBeCalled() {
        Book book = new Book("isbn", "Title", "Author");

        bookController.addBook(book);

        verify(bookService, times(1)).add(book);
    }

    @Test
    public void expectUpdateBookFunctionToBeCalled() {
        Book book = new Book("isbn", "Title", "Author");
        bookController.update(book);

        verify(bookService, times(1)).update(book);
    }

    @Test
    public void expectDeleteookFunctionToBeCalled() {
        Book book = new Book("isbn", "Title", "Author");
        bookController.delete(book);

        verify(bookService, times(1)).delete(book);
    }
}
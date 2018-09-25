package library.service;

import library.domain.Book;
import library.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @Mock
    private CopyService copyService;

    private BookService bookService;

    @Before
    public void setup(){
        this.bookService = new BookService(bookRepository, copyService);
    }

    @Test
    public void addBookCallsTheSaveMethodOfTheBookRepository() {
        Book aBook = new Book("Wings of Fire", "Abdul Kalam", "isbn");

        bookService.add(aBook);

        verify(bookRepository, times(1)).save(aBook);
    }
}
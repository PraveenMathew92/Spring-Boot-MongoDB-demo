package library.service;

import library.Exceptions.BookNotFoundException;
import library.Exceptions.CopyNotFoundException;
import library.domain.Book;
import library.domain.Copy;
import library.repository.CopyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static java.util.Optional.of;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CopyServiceTest {
    @Mock
    private CopyRepository copyRepository;

    @Mock
    private BookService bookService;

    private CopyService copyService;

    @Before
    public void setup(){
        this.copyService = new CopyService(copyRepository, bookService);
    }

    @Test(expected = BookNotFoundException.class)
    public void addServiceShouldThrowExceptionIfTheBookIsNotAvailable() throws BookNotFoundException {
        when(bookService.getBookById("Id")).thenReturn(null);

        Copy copy = new Copy("Id");

        copyService.add(copy);
    }

    @Test
    public void addServiceShouldCallAddMethodInRepositoryIfTheBookIsAvailable() throws Exception {
        Book aBook = new Book("isbn", "Wings Of Fire", "Abdul Kalam");
        when(bookService.getBookById("Id")).thenReturn(aBook);

        Copy copy = new Copy("Id");
        copyService.add(copy);

        verify(copyRepository, times(1)).save(copy);
    }

    @Test
    public void borrowServiceShouldUpdateTheStockThroughRepository() throws CopyNotFoundException {
        Copy copy = new Copy("Id");
        Copy unavailableCopy = new Copy("Unavailable");
        unavailableCopy.setAvailability(false);

        when(copyRepository.findByTypeId("Id")).thenReturn(asList(unavailableCopy, copy));
        copy.setAvailability(false);
        copyService.borrow("Id");

        verify(copyRepository, times(1)).save(copy);
    }

    @Test(expected = CopyNotFoundException.class)
    public void borrowServiceShouldThrowCopyNotAvailableExceptionIfTheNoCopiesAreAvailable() throws CopyNotFoundException{
        when(copyRepository.findById("Id")).thenReturn(null);

        copyService.borrow("Id");
    }

    @Test
    public void giveBackServiceShouldUpdateTheStockThroughRepository() {
        Copy copy = new Copy("copy Id");
        when(copyRepository.findById(anyString())).thenReturn(of(copy));
        copy.setAvailability(true);

        copyService.giveBack("Copy Id");

        verify(copyRepository, times(1)).save(copy);
    }
}
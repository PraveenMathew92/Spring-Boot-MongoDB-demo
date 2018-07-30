package library.controller;

import library.domain.Reader;
import library.service.ReaderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReaderControllerTest {

    @Mock
    private ReaderService readerService;

    private ReaderController readerController;

    @Before
    public void setUp() {
        readerController = new ReaderController(readerService);
    }

    @Test
    public void getReader() {
        readerController.getReader("name");
        verify(readerService, times(1)).getByName("name");
    }

    @Test
    public void expectTheCreateReaderFunctionToBeCalled() {
        Reader aReader = new Reader("Jim", "Doe");
        readerController.createReader(aReader);
        verify(readerService, times(1)).addReader(aReader);
    }

    @Test
    public void expectTheUpdateReaderFunctionToBeCalled() {
        readerController.updateReader("name");
        verify(readerService, times(1)).updateByName("name");
    }

    @Test
    public void expectTheDeleteReaderFunctionToBeCalled() {
        readerController.deleteReader("name");
        verify(readerService, times(1)).deleteByName("name");
    }
}
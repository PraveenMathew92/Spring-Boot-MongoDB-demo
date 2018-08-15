package library.controller;

import library.Exceptions.BookNotFoundException;
import library.domain.Copy;
import library.service.CopyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CopyControllerTest {
    private CopyController copyController;

    @Mock
    private CopyService copyService;

    @Before
    public void setup(){
        copyController = new CopyController(copyService);
    }

    @Test
    public void expectAddServiceToBeCalled() throws BookNotFoundException {
        Copy copy = new Copy("type Id");
        copyController.add(copy);

        verify(copyService,times(1)).add(copy);
    }
}
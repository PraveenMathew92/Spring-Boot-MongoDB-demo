package library.controller;

import library.service.ReaderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HomePageTest {

    @Mock
    private ReaderService readerService;

//    @Mock
//    private DummyService dummyService;

//    @InjectMocks
    private HomePage homePage;

    @Before
    public void setUp() {
        homePage = new HomePage(readerService);
    }

    @Test
    public void getReader() {
        homePage.getReader("name");
        verify(readerService, times(1)).getByName("name");
    }
}
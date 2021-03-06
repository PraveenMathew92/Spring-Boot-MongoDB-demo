package library.controller;


import library.service.ReaderService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReaderControllerTest {
    @Mock
    private ReaderService readerService;

    //@Rule
    //public WireMockRule wireMockRule = new WireMockRule(3000);


    private ReaderController readerController;

//    @Before
//    public void setUp() {
//        readerController = new ReaderController(readerService);
//        wireMockServer.start();
//    }

//    @Test
//    public void getReader() {
//        configureFor("localhost", 3000);
////        stubFor(get(urlEqualTo("user/Jim"))
////                .willReturn(aResponse()));
//
//        verify(getRequestedFor(urlEqualTo("/user/Jim")));
//
//        //readerController.getReader("name");
//        //HttpGet httpGet = new HttpGet("http://localhost:3000/user/Jim");
//
//        verify(readerService, times(1)).getByName("Jim");
//    }

//    @Test
//    public void expectTheCreateReaderFunctionToBeCalled() {
//        Reader aReader = new Reader("Jim", "Doe");
//        readerController.createReader(aReader);
//        verify(readerService, times(1)).issue(aReader);
//    }
//
//    @Test
//    public void expectTheUpdateReaderFunctionToBeCalled() {
//        Reader aReader = new Reader("Jim", "Doe");
//        Date dateOfBirth = new Date();
//        readerController.updateReader(aReader, dateOfBirth);
//        verify(readerService, times(1)).update(aReader, dateOfBirth);
//    }
//
//    @Test
//    public void expectTheDeleteReaderFunctionToBeCalled() {
//        Reader aReader = new Reader("Jim", "Doe");
//        readerController.deleteReader(aReader);
//        verify(readerService, times(1)).delete(aReader);
//    }
}
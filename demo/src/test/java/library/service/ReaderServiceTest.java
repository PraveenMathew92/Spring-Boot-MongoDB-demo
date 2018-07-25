package library.service;

import library.domain.Reader;
import library.repository.ReaderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReaderServiceTest {

    @Mock
    private ReaderRepository readerRepository;

    private ReaderService readerService;

    @Before
    public void setUp() {
        this.readerService = new ReaderService(readerRepository);
    }

    @Test
    public void getByNameGivesEmptyListIfNoUserFound() {
        List<Reader> users = readerService.getByName("some name");
        assertEquals(0, users.size());
    }

    @Test
    public void getByNameGivesTheUserWhenFirstNameMatches() {
        Reader reader = new Reader("ishu", "sing");

        when(readerRepository.findByFirstName("ishu")).thenReturn(Collections.singletonList(reader));

        List<Reader> users = readerService.getByName("ishu");

        assertEquals(1, users.size());
    }

    @Test
    public void getByNameGivesTheUserWhenLastNameMatches() {
        Reader reader = new Reader("firstName", "lastName");

        when(readerRepository.findByLastName("lastName")).thenReturn(Collections.singletonList(reader));

        List<Reader> users = readerService.getByName("lastName");

        assertEquals(1, users.size());
    }

    @Test
    public void getByNameGivesTheListOfUsersWhenTheNameMatches() {
        Reader aReader = new Reader("Some", "Name");
        Reader anotherReader = new Reader("Name", "Another");

        when(readerRepository.findByFirstName("Name")).thenReturn(Collections.singletonList(anotherReader));
        when(readerRepository.findByLastName("Name")).thenReturn(Collections.singletonList(aReader));
        List<Reader> users = readerService.getByName("Name");

        assertEquals(2, users.size());
    }



    @Test
    public void getByDateOfBirthGivesTheUsersWithDateOfBirth() {
        Reader reader = new Reader("firstName", "lastName");
        Date dateOfBirth = new Date();
        reader.setDateOfBirth(dateOfBirth);

        when(readerRepository.findByDateOfBirthBetween(new Date(0) ,dateOfBirth)).thenReturn(Collections.singletonList(reader));
        List<Reader> users = readerService.getByDOBAfter(dateOfBirth);

        assertEquals(1, users.size());
    }
}
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

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
    public void addUserServiceCallsTheSaveMethodOfTheRepository() {
        Reader aReader = new Reader("Jim");

        readerService.add(aReader);

        verify(readerRepository, times(1)).save(aReader);
    }

    @Test
    public void getByDateOfBirthGivesTheUsersWithDateOfBirth() {
        Reader reader = new Reader("Jim");
        Date dateOfBirth = new Date();
        reader.setDateOfBirth(dateOfBirth);

        when(readerRepository.findByDateOfBirthBetween(new Date(0) ,dateOfBirth)).thenReturn(Collections.singletonList(reader));
        List<Reader> users = readerService.getByDOBAfter(dateOfBirth);

        assertEquals(1, users.size());
    }

}
package library.service;

import library.domain.Reader;
import library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReaderService {

    private ReaderRepository readerRepository;

    @Autowired
    public ReaderService(ReaderRepository customerRepository) {
        this.readerRepository = customerRepository;
    }

    public void add(Reader reader) {
        readerRepository.save(reader);
    }

    public List<Reader> getByDOBAfter(Date dateOfBirth) {
        return readerRepository.findByDateOfBirthBetween(dateOfBirth, new Date());
    }
}

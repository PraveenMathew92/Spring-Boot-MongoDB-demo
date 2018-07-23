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

    public List<Reader> getByName(String name) {
        List<Reader> firstNames = readerRepository.findByFirstName(name);
        List<Reader> lastNames = readerRepository.findByLastName(name);
        List<Reader> allNames = Stream.concat(firstNames.stream(), lastNames.stream())
                .collect(Collectors.toList());
        return allNames;
    }

    public List<Reader> getByDOBAfter(Date dateOfBirth){
        return readerRepository.findByDateOfBirthBetween(new Date(0), dateOfBirth);
    }
}

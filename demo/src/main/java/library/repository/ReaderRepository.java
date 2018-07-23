package library.repository;

import java.util.Date;
import java.util.List;

import library.domain.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<Reader, String> {

    public List<Reader> findByFirstName(String firstName);
    public List<Reader> findByLastName(String lastName);
    public List<Reader> findByDateOfBirthBetween(Date youngestDateOfBirth, Date oldestDateOfBirth);
}
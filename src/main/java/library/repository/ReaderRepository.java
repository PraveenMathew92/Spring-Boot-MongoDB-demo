package library.repository;

import java.util.Date;
import java.util.List;

import library.domain.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<Reader, String> {
    List<Reader> findByName(String firstName);
    List<Reader> findByDateOfBirthBetween(Date begining, Date end);
}
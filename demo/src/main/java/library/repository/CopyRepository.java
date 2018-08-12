package library.repository;

import library.domain.Copy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CopyRepository extends MongoRepository<Copy, String>{
    List<Copy> findByTypeId(String id);
    List<Copy> findByAvailable(boolean availability);
    Optional<Copy> findById(String id);
}

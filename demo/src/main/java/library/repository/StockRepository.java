package library.repository;

import library.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockRepository extends MongoRepository<Stock, String>{
    List<Stock> findByTypeId(String id);
    List<Stock> findByAvailable(String id);
}

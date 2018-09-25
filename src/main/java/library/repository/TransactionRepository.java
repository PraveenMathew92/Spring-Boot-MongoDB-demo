package library.repository;

import library.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    List<Transaction> findByReaderId(String firstName);
    List<Transaction> findByBookId(String firstName);
}
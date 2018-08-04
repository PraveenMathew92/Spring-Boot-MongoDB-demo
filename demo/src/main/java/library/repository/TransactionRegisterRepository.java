package library.repository;

import library.domain.TransactionRegister;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRegisterRepository extends MongoRepository<TransactionRegister, String> {
    List<TransactionRegister> findByMemberId(String firstName);
    List<TransactionRegister> findByBookId(String firstName);
}
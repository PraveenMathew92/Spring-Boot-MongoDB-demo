package library.repository;

import library.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    public List<Book> findByName(String title);
    public List<Book> findByAuthor(String author);
    public Book findByTypeId(String typeId);
}
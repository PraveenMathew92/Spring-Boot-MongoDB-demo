package library;

import library.domain.Book;
import library.domain.Reader;
import library.repository.BookRepository;
import library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ReaderRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        repository.save(new Reader("Alice"));
        repository.save(new Reader("Bob"));

        System.out.println("Readers found with findAll():");
        System.out.println("-------------------------------");
        for (Reader reader : repository.findAll()) {
            System.out.println(reader);
        }
        System.out.println();

        System.out.println("Reader found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("Alice"));

        System.out.println("Readers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Reader reader : repository.findByName("Smith")) {
            System.out.println(reader);
        }


    }

}
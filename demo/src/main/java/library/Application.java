package library;

import library.domain.Reader;
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

        repository.save(new Reader("Alice", "Smith"));
        repository.save(new Reader("Bob", "Smith"));

        System.out.println("Readers found with findAll():");
        System.out.println("-------------------------------");
        for (Reader reader : repository.findAll()) {
            System.out.println(reader);
        }
        System.out.println();

        System.out.println("Reader found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Readers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Reader reader : repository.findByLastName("Smith")) {
            System.out.println(reader);
        }

    }

}
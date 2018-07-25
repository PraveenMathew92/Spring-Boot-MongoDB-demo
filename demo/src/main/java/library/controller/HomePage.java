package library.controller;

import library.domain.Reader;
import library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomePage {

    @Autowired
    private ReaderService readerService;


    @Autowired
    public HomePage(ReaderService readerService) {
        this.readerService = readerService;
    }

    @RequestMapping("/")
    public String home(){
        return "Welcome to Library";
    }

    @GetMapping("/user/{name}")
    public List<Reader> getReader(@PathVariable("name") String name) {
        return readerService.getByName(name);
    }
}

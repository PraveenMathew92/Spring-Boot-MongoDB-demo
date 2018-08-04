package library.controller;

import library.domain.Reader;
import library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ReaderController {

    private ReaderService readerService;


    @Autowired
    public ReaderController(ReaderService readerService) {
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

    @PostMapping("/user/add")
    public void createReader(@RequestBody Reader reader) {
        readerService.add(reader);
    }

    @PutMapping("/user/update")
    public void updateReader(@RequestBody Reader reader, Date dateOfBirth) {
        readerService.update(reader, dateOfBirth);
    }

    @DeleteMapping("/user/delete/")
    public void deleteReader(@RequestBody Reader reader) {
        readerService.delete(reader);
    }
}

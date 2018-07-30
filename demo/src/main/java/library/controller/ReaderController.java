package library.controller;

import library.domain.Reader;
import library.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReaderController {

    @Autowired
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
        readerService.addReader(reader);
    }

    @PutMapping("/user/update/{name}")
    public void updateReader(@RequestBody String name) {
        readerService.updateByName(name);
    }

    @DeleteMapping("/user/delete/{name}")
    public void deleteReader(@RequestBody String name) {
        readerService.deleteByName(name);
    }
}

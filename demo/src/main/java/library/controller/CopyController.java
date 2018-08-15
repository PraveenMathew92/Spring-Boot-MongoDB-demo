package library.controller;

import library.Exceptions.BookNotFoundException;
import library.domain.Copy;
import library.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CopyController {
    private final CopyService copyService;

    @Autowired
    public CopyController(CopyService copyService) {
        this.copyService = copyService;
    }

    @PostMapping("/copy/add")
    public void add(@RequestBody Copy copy) throws BookNotFoundException {
        copyService.add(copy);
    }
}

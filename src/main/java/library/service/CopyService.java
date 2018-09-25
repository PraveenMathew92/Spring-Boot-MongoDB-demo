package library.service;

import library.Exceptions.BookNotFoundException;
import library.Exceptions.CopyNotFoundException;
import library.domain.Copy;
import library.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static java.util.Objects.isNull;

public class CopyService {
    private CopyRepository copyRepository;
    private BookService bookService;

    @Autowired
    public CopyService(CopyRepository copyRepository, BookService bookService) {
        this.copyRepository = copyRepository;
        this.bookService = bookService;
    }

    public void add(Copy copy) throws BookNotFoundException{
        String bookId = copy.getTypeId();
        if(isNull(bookService.getBookById(bookId)))
            throw new BookNotFoundException();
        copyRepository.save(copy);
    }

    public void borrow(String typeId) throws CopyNotFoundException {
        Copy copy = getCopyWithId(typeId);

        copy.setAvailability(false);
        copyRepository.save(copy);

    }

    private Copy getCopyWithId(String typeId) throws CopyNotFoundException {
        Optional<Copy> copyHavingTheId = copyRepository.findByTypeId(typeId)
                .stream()
                .filter(Copy::isAvailable)
                .findFirst();
        if (copyHavingTheId.isPresent()) {
            return copyHavingTheId.get();
        }
        throw new CopyNotFoundException();
    }

    public void giveBack(String copyId){
        Copy copyToBeGivenBack = copyRepository.findById(copyId).get();
        copyToBeGivenBack.setAvailability(true);
        copyRepository.save(copyToBeGivenBack);
    }
}

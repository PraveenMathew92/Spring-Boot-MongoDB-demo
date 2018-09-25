package library.service;

import library.Exceptions.BookCannotBeReturnedException;
import library.Exceptions.CopyNotFoundException;
import library.domain.Transaction;
import library.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TransactionService {
    private TransactionRepository transactionRepository;
    private CopyService copyService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CopyService copyService) {
        this.transactionRepository = transactionRepository;
        this.copyService = copyService;
    }

    public void issue(String readerId, String bookId, Date borrowDate) throws CopyNotFoundException {
        copyService.borrow(bookId);
        Transaction transaction = new Transaction(readerId, bookId);
        transaction.setBorrowDate(borrowDate);
        transactionRepository.save(transaction);
    }

    public void giveBack(String bookId, Date giveBackDate) throws BookCannotBeReturnedException {
        Transaction transactionToBeUpdated = getTransactionToBeUpdated(bookId);
        transactionToBeUpdated.setReturnDate(giveBackDate);
        transactionRepository.save(transactionToBeUpdated);
        copyService.giveBack(bookId);
    }

    private Transaction getTransactionToBeUpdated(String bookId) throws BookCannotBeReturnedException {
        List<Transaction> transactions = transactionRepository.findByBookId(bookId);
        Optional<Transaction> transactionToBeUpdated = transactions
                .stream()
                .filter(transaction -> transaction.getReturnDate() == null)
                .findFirst();
        if(transactionToBeUpdated.isPresent()){
            return transactionToBeUpdated.get();
        }
        throw new BookCannotBeReturnedException();
    }
}
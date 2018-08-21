package library.controller;

import library.Exceptions.CopyNotFoundException;
import library.domain.IssueTransaction;
import library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping("/issue")
    public void issue(@RequestBody IssueTransaction issueTransaction) throws CopyNotFoundException {
        String readerId = issueTransaction.getReaderId();
        String bookId = issueTransaction.getBookId();
        Date borrowDate = issueTransaction.getBorrowDate();
        transactionService.issue(readerId, bookId, borrowDate);
    }
}

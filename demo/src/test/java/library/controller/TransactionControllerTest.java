package library.controller;

import library.Exceptions.CopyNotFoundException;
import library.domain.IssueTransaction;
import library.service.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TransactionControllerTest {
    @Mock
    private TransactionService transactionService;

    private TransactionController transactionController;

    @Before
    public void setup(){
        this.transactionController = new TransactionController(transactionService);
    }

    @Test
    public void expectIssueTransactionToCallTheIssueBookOfTransaction() throws CopyNotFoundException {
        String bookId = "BookId";
        String readerId = "ReaderId";
        Date borrowDate = new Date();
        IssueTransaction issueTransaction = new IssueTransaction(readerId, bookId, borrowDate);

        transactionController.issue(issueTransaction);

        verify(transactionService, times(1)).issue(readerId, bookId, borrowDate);
    }

}
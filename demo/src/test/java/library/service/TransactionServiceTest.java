package library.service;

import library.Exceptions.BookCannotBeReturnedException;
import library.Exceptions.CopyNotFoundException;
import library.domain.Transaction;
import library.repository.TransactionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CopyService copyService;

    private TransactionService transactionService;

    @Before
    public void setup(){
        this.transactionService = new TransactionService(transactionRepository, copyService);
    }

    @Test
    public void issueMethodShouldCallTheBorrowMethodOfStockService() throws CopyNotFoundException {
        Date someDate = new Date();
        transactionService.issue("reader Id", "Book Id", someDate);

        verify(copyService, times(1)).borrow("Book Id");
    }


    @Test
    public void issueMethodCallsTheSaveTransactionMethodOfTheRepository() throws CopyNotFoundException {
        String readerId = "Reader Id";
        String bookId = "Book Id";
        Date borrowDate = new Date();
        Transaction transaction = new Transaction(readerId, bookId);

        transactionService.issue(readerId, bookId, borrowDate);

        verify(transactionRepository, times(1)).save(any(transaction.getClass()));
    }

    @Test
    public void giveBackMethodCallsTheSaveTransactionMethodOfTheRepository() throws BookCannotBeReturnedException {
        String readerId = "Reader Id";
        String bookId = "Book Id";
        Date giveBackDate = new Date();
        Transaction transactionToBeUpdated = new Transaction(readerId, bookId);

        when(transactionRepository.findByBookId(bookId)).thenReturn(asList(transactionToBeUpdated));

        transactionService.giveBack(bookId, giveBackDate);

        verify(transactionRepository, times(1)).save(transactionToBeUpdated);
    }

    @Test(expected = BookCannotBeReturnedException.class)
    public void giveBackMethodThrowsBookCannotBeReturnedExceptionIfTheBookIsNotIssued() throws BookCannotBeReturnedException {
        String readerId = "Reader Id";
        String bookId = "Book Id";
        Transaction transactionToBeUpdated = new Transaction(readerId, bookId);
        transactionToBeUpdated.setReturnDate(new Date());

        when(transactionRepository.findByBookId(bookId)).thenReturn(asList(transactionToBeUpdated));

        transactionService.giveBack(bookId, new Date());
    }
}
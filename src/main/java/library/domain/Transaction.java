package library.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Transaction {
    @Id
    private String id;

    private final String readerId;
    private final String bookId;

    private Date returnDate;
    private Date borrowDate;

    public Transaction(String readerId, String bookId) {
        this.readerId = readerId;
        this.bookId = bookId;
    }

    public String getId() {
        return id;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
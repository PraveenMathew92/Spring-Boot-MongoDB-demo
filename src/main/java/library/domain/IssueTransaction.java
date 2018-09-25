package library.domain;

import java.util.Date;

public class IssueTransaction {
    private final String readerId;
    private final String bookId;
    private final Date borrowDate;

    public IssueTransaction(String readerId, String bookId, Date borrowDate) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getBookId() {
        return bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
}

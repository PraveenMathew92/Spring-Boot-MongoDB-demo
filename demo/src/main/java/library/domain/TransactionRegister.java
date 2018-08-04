package library.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class TransactionRegister {
    @Id
    private String id;

    private String memeberId;
    private String bookId;

    private Date returnDate;
    private Date borrowDate;
}
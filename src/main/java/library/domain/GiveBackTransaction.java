package library.domain;


import java.util.Date;

public class GiveBackTransaction {
    private final Transaction transaction;
    private final Date giveBackDate;

    public GiveBackTransaction(Transaction transaction, Date giveBackDate) {
        this.transaction = transaction;
        this.giveBackDate = giveBackDate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Date getGiveBackDate() {
        return giveBackDate;
    }
}

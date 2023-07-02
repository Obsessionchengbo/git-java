package Experiment3;

import java.util.Date;

public class Transaction {private final Date date;
    private final char type;

    private final double amount;
    private final double balance;
    private final String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public String toString() {
        return  "date=" + date +
                ", type=" + type +
                ", amount=" + amount +
                ", balance=" + balance +
                ", description='" + description + '\'' +
                '.';
    }
}

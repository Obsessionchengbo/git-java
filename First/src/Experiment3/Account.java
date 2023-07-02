package Experiment3;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private final Date dateCreated;

    public Account() {
        this.dateCreated = new Date();
    }
    public Account(int id, double balance) {
        this.dateCreated = new Date();
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate(){ //月利率
        return annualInterestRate / 12;
    }
    public double getMonthlyInterest(){ //月利息
        return balance * getMonthlyInterestRate();
    }
    public void withDraw(double money){
        if (balance >= money){
            balance -= money;
        }else {
            System.out.println("余额不足");
        }
    }
    public void deposit(double money){ //向账户存储指定额度
        balance += money;
    }
}

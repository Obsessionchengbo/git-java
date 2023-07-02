package Experiment3;

public class NewAccountTest {
    public static void main(String[] args) {

    NewAccount newAccount = new NewAccount("George", 1000, 1122);
    newAccount.setAnnualInterestRate(1.5 / 100);
    newAccount.deposit(30);
    newAccount.deposit(40);
    newAccount.deposit(50);
    newAccount.withDraw(5);
    newAccount.withDraw(4);
    newAccount.withDraw(2);

    System.out.println("Name:" + newAccount.getName() + ",MonthlyInterestRate:" + newAccount.getMonthlyInterestRate() +
            ",Balance:" + newAccount.getBalance());
    for (int i = 0; i < newAccount.transactions.size(); i++) {
        System.out.println("Transaction " + (i + 1) + ":" + newAccount.transactions.get(i));
    }
}
}


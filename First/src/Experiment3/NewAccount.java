package Experiment3;
import java.util.ArrayList;

public class NewAccount extends Account {
    private String name;
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        public NewAccount(String name, int id, double balance) {
            super(id, balance);
            this.name = name;
        }

        public String getName() {
            return name;
        }


        public void withDraw(double money) {
            if (getBalance() > money) {
                setBalance(getBalance() - money);
                transactions.add(new Transaction('W', money, getBalance(), "取款"));
            }
        }

        public void deposit(double money) {
            setBalance(getBalance() + money);
            transactions.add(new Transaction('D', money, getBalance(), "存款"));
        }
    }

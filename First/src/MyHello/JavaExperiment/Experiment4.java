package MyHello.JavaExperiment;
import java.util.Scanner;
public class Experiment4 {public static void main(String[] args) {
    Account[] arr = new Account[10];
    for (int i = 0; i < 10; i++) {
        arr[i] = new Account(i, 100);
    }
    Scanner input = new Scanner(System.in);
    int id = 0;
    while (true) {
        System.out.print("\nEnter an id:");
        id=input.nextInt();
        if (id < 0 || id >= 10) {
            System.out.println("请输入正确ID");
            continue;
        }
        boolean bool=true;
        while(bool){
            System.out.println("\nMain menu");
            System.out.println("1:check balance");
            System.out.println("2:withdraw");
            System.out.println("3:deposit");
            System.out.println("4:exit");
            System.out.print("Enter a choice:");
            int choice = input.nextInt();
            if(choice==1){
                System.out.printf("The balance is %.1f\n",arr[id].getBalance());
            }
            if(choice==2){
                System.out.print("Enter an amount to withdraw:");
                double withdraw=input.nextDouble();
                arr[id].withDraw(withdraw);
            }
            if(choice==3){
                System.out.print("Enter an amount to deposit:");
                double deposit=input.nextDouble();
                arr[id].deposit(deposit);
            }
            if(choice==4){
                bool=false;
            }
        }
    }
}
}

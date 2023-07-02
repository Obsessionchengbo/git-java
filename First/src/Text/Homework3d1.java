package Text;

import java.util.Scanner;

public class Homework3d1 {
    public static void main(String[] args) {
    int left = (int) (Math.random() * 100);
    int right = (int) (Math.random() * 100);
    int sum = left + right;
    System.out.printf("%d+%d=", left, right);
    Scanner input = new Scanner(System.in);
    int result = input.nextInt();
    if (result != sum)
    System.out.println("答案错误！");
    else System.out.println("答案正确！");
    }
}

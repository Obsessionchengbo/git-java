package Text;

import java.util.Scanner;

public class Homework3d2 {
    public static void main(String[] args) {
    System.out.println("请输入一个三位数的整数：");
    Scanner input = new Scanner(System.in);
    int number = input.nextInt();
    int a = number / 100;
    int b = number % 10;
    if (a == b)
    System.out.println(number + "是回文数字。");
    else System.out.println(number + "不是回文数字。");
    }
}

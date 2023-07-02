package Text;

import java.util.Scanner;

public class Homework2d3 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入英尺的值：");
    double feet = sc.nextDouble();
    double meters = 0.305 * feet;
    System.out.println(feet+"英尺等于"+meters+"米");
    }
}

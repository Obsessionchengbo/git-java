package Text;

import java.util.Scanner;

public class Homework2d2 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入圆柱体半径和长度");
    double radius = sc.nextDouble();
    double length = sc.nextDouble();
    double area = radius*radius * 3.14159;
    double volume=area*length;
    System.out.printf("面积为%.4f",area);
    System.out.printf("体积为%.2f",volume);
 }
}

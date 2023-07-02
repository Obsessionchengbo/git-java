package Text;

import java.util.Scanner;

public class Homework2d1 {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System .in);
    System.out.print("请输入摄氏度 " );
    int celsius=sc.nextInt();
    double fahrenheit=(9.0/5)*celsius+32;
    System.out.println(celsius+"摄氏度"+"等于"+fahrenheit+"华氏温度");
    }
}

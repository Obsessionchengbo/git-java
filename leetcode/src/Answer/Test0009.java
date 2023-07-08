package Answer;

import java.util.Scanner;

public class Test0009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个需要判断数字：");
        int x = scanner.nextInt();
        System.out.println(Demo0009.isPalindrome(x));
    }
}

class Demo0009{
    public static boolean isPalindrome(int x){
        if(x<0 || (x%10 == 0 && x!=0)){
            return false;
        }
        if(x<10){
            return true;
        }
        int num = 0;
        int n = 1;
        while (x>num){
            num = num*10+x%10;
            x = x/10;
            n*=10;
        }
        return x == num || x == num / 10;
    }
}

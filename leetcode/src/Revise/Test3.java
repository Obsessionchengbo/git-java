package Revise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        System.out.println("请输入要判断的字符串s：");
        s = scanner.next();
        System.out.println("该字符串的最长子串的长度为："+ Demo03.lengthOfLongestSubstring(s));
    }
}
class Demo03{
    public static int lengthOfLongestSubstring(String s) {
        int max = 1;
        int len = s.length();
        int num = 1;
        char ch = 0;
        if(len == 0) return 0;
        if(len == 1) return 1;
        for (int i = 1; i < len; i++) {
            ch = s.charAt(i);
            int index = s.indexOf(ch,i-num);
            /*System.out.print(ch +"index="+index+"----i="+i+"   ");*/
            if(i == index){
                num++;
            }else {
                num = i-index;
            }
            max = Math.max(num, max);
            /*System.out.println("max="+max+"     num="+num);*/
        }
        return max;
    }
}
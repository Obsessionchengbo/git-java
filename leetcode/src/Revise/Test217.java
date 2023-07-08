package Revise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test217 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("请输入数组的长度:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入" + n + "个数:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(Demo217.containsDuplicate(nums));
    }
}


class Demo217 {
    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
}

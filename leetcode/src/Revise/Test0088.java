package Revise;

import java.util.Arrays;
import java.util.Scanner;

public class Test0088 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组1的长度：");
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("请输入"+n1+"个数：");
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = scanner.nextInt();
        }
        System.out.println("请输入数组2的长度：");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("请输入"+n2+"个数：");
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = scanner.nextInt();
        }
        System.out.println("请输入数组一要合并的个数：");
        int m = scanner.nextInt();
        System.out.println("请输入数组二要合并的个数：");
        int n = scanner.nextInt();

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        Demo0088.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}

class Demo0088{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m--+--n;
        while(n>=0) {
            nums1[i--] = m>=0 && nums1[m]>nums2[n] ? nums1[m--] : nums2[n--];
        }
    }
}

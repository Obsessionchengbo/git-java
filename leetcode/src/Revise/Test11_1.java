package Revise;

import java.util.Arrays;
import java.util.Scanner;

public class Test11_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = scanner.nextInt();
        int[] height = new int[n];
        System.out.println("请输入" + n + "个数的值");
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        System.out.println("输入："+ Arrays.toString(height));
        Solution area = new Solution();
        System.out.println("输出：" + area.maxArea(height));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;
        int a,b;
        while(left<right) {
            a = height[left];
            b = height[right];
            int x = right - left;
            int y = Math.min(a, b);
            max = Math.max(max, x * y);
            if (a < b) {
                while (left < right && height[left] <= a) {
                    left++;
                }
            } else {
                while (left < right && height[right] <= b) {
                    right--;
                }
            }
        }
        return max;
    }
}
package Revise;

import java.util.Arrays;
import java.util.Scanner;

public class Test2475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入"+n+"个数：");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(Demo2475_.unequalTriplets(nums));
    }
}
class Demo2475_{
    public static int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, start = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] != nums[i]) {
                ans += start * (i - start + 1) * (n - 1 - i);
                start = i + 1;
            }
        }
        return ans;
    }
}
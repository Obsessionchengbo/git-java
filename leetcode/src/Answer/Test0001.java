package Answer;

import java.util.Arrays;
import java.util.Scanner;

public class Test0001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入"+n+"个数：");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("请输入目标值：");
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(Solution.twoSum(nums,target)));
    }
}

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0;i<nums.length;i++){
            for (int j = nums.length-1; j > i; j--) {
                if((nums[i])+nums[j]==target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
}
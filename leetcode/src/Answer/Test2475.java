package Answer;

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
        System.out.println(Demo2475.unequalTriplets(nums));
    }
}
class Demo2475{
    public static int unequalTriplets(int[] nums) {
        int len = nums.length;
        int num = 0;
        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j < len-1; j++) {
                for (int k = j+1; k < len; k++) {
                    if(nums[i]!=nums[j] && nums[j] != nums[k] && nums[i]!=nums[k]){
                        num++;
                    }
                }
            }
        }
        return num;
    }
}

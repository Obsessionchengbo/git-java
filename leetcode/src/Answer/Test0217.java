package Answer;

import java.util.HashMap;
import java.util.Scanner;

public class Test0217 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println("请输入数组的长度:");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入"+n+"个数:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(Demo0217.containsDuplicate(nums));
    }
}

class Demo0217{
    public static boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int num : nums) {
            hashMap.put(num, num);
        }
        int size = hashMap.size();
        return len != size;
    }
}
package Revise;

import java.util.Arrays;
import java.util.Scanner;

public class Test0027 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入" + n + "个数的值");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println("请输入要删除的元素:");
        int val = scanner.nextInt();
        System.out.println("新数组长度为:" + Demo27.removeElement(nums,val));
        System.out.println(Arrays.toString(nums));

    }
}

class Demo27{
    public static int removeElement(int[] nums,int val){
        int j = 0;
        if(nums.length == 0 || (nums.length == 1 && nums[0] == val)){
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}

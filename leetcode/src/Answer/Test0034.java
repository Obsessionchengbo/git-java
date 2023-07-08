package Answer;

import java.util.Arrays;
import java.util.Scanner;

class Test0034 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组长度n：");
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random()*50);//存储n个随机数在数组里
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("请输入查找的数字：");
        int target = input.nextInt();

        System.out.println(Arrays.toString(Solution34.searchRange(nums,target)));

    }
}

class Solution34 {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int[] a = new int[2];
        while(left <= right){
            if(nums[left] == target){
                if(nums[right] == target){
                    a[0] = left;
                    a[1] = right;
                    return a;
                }else {
                    right--;
                }
            }else {
                left++;
            }
        }
        a[0] = -1;
        a[1] = -1;
        return a;
    }
}

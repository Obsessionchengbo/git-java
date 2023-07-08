package Revise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Test448 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = input.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入"+n+"个数：");
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println(Demo448.findDisappearedNumbers(nums));

    }
}
class Demo448 {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int index = 0;
        while (index<len){
            if(nums[index] == index+1){
                index++;
            }else {
                int targetIndex = nums[index] -1;
                if (nums[targetIndex] == nums[index]) {
                    index++;
                    continue;
                }
                    int temp = nums[targetIndex];
                    nums[targetIndex] = nums[index];
                    nums[index] = temp;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(nums[i] != i + 1){
                list.add(i + 1);
            }
        }
        return list;
    }
}

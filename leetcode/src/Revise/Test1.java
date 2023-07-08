package Revise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
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
        System.out.println(Arrays.toString(Add.twoSum(nums,target)));
    }
}

class Add {
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> hashMap = new HashMap<>(len - 1);//哈希表的初始化，长度为len-1是因为其下标是从0开始
        hashMap.put(nums[0],0);// .put(nums[0],0)是给哈希表赋值的方法
        for (int i = 1; i < len; i++) {
            int key = target - nums[i];
            if(hashMap.containsKey(key)){// .containsKey()是检查括号里的元素是否在哈希表中
                return new int[]{hashMap.get(key),i};// .get()是获取关键值对应的下标
            }
            hashMap.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


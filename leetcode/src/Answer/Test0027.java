package Answer;

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
        System.out.println("新数组长度为:" + Demo0027.removeElement(nums,val));
        System.out.println(Arrays.toString(nums));

    }
}

class Demo0027{
    public static int removeElement(int[] nums, int val) {
        int num = 0;
        int left = 0;
        int right = nums.length - 1;
        int temp = 0;
        if(nums.length == 1){
            if(nums[0] == val){
                return 0;
            }else return 1;
        }
        if(nums.length == 0){
            return 0;
        }
        do {
            if(nums[left] == val){
                while (nums[right] == val){
                    if(left == right){
                        return num;
                    }
                    right--;
                }
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }
            if(nums[left] != val){
                num++;
            }
            left++;
            System.out.println("left=" + left + "  right=" + right + "  num=" + num);
            System.out.println(Arrays.toString(nums));
        }while (left <= right);

        return num;
    }
}

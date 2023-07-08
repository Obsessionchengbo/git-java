package Answer;

import java.util.Arrays;
import java.util.Scanner;

public class Test0026 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("请输入"+n+"个数：");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("新数组长度为：" + Demo0026.removeDuplicates(nums));
        System.out.println(nums.length);
    }
}
class Demo0026{
    public static int removeDuplicates(int[] nums) {
        int num;
        int[] arr = new int[1];
        int j = 1;
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        arr[0] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i + 1]){
                arr = Arrays.copyOf(arr,arr.length+1);
                arr[j] = nums[i + 1];
                j++;
                System.out.println(Arrays.toString(arr));//测试
            }
        }
        nums = arr;
        num = nums.length;
        System.out.println(Arrays.toString(nums));//测试
        return num;
    }
}

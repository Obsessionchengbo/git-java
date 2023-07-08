package Answer;

import java.util.*;

public class Test0448 {
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
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            hashMap.put(num % n, num % n);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(hashMap.get(i));
            if(hashMap.get(i) == null){
                if(i == 0){
                    list.add(n);
                }else list.add(i);
            }
        }
        return list;
    }
}

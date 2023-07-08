package Answer;

import java.util.Arrays;
import java.util.Scanner;

public class Test0088 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组1的长度：");
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("请输入"+n1+"个数：");
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = scanner.nextInt();
        }
        System.out.println("请输入数组2的长度：");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("请输入"+n2+"个数：");
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = scanner.nextInt();
        }
        System.out.println("请输入数组一要合并的个数：");
        int m = scanner.nextInt();
        System.out.println("请输入数组二要合并的个数：");
        int n = scanner.nextInt();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        Demo0088.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
}

class Demo0088{
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left1 = 0;
        int left2 = 0;
        int newLength = m + n;
        if(nums1.length == 0){
            nums1 = nums2;
        }
        while (nums1.length != newLength){
            if(nums1[left1] == nums2[left2]){
                int temp = nums1[left1+1];
                nums1[left1+1] = nums2[left2];
                nums2[left2] = temp;
                left1++;
            }else if(nums1[left1] > nums2[left2]){
                int temp = nums1[left1];
                nums1[left1] = nums2[left2];
                nums2[left2] = temp;
                left1++;
            }else if(nums2[left2] > nums1[left1]){
                while (nums2[left2] > nums1[left1]){
                    left1++;
                    if(left1 == nums1.length) {
                        nums1 = Arrays.copyOf(nums1,nums1.length+1);
                        nums1[left1] = nums2[left2];
                        left2++;
                        break;
                    }
                }
            }
            if(left1 == nums1.length) {
                nums1 = Arrays.copyOf(nums1, nums1.length + 1);
                nums1[left1] = nums2[left2];
                left2++;
            }
            if(left2 == nums2.length-1){
                nums1 = Arrays.copyOf(nums1, nums1.length + 1);
                nums1[left1+1] = nums2[left2];
            }
            //System.out.println("left1="+left1+"     left2="+left2);
            System.out.println(Arrays.toString(nums1));
        }
    }
}

package Revise;
import java.util.Arrays;
import java.util.Scanner;

public class Test0004 {
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
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Demo0004.findMedianSortedArrays(nums1,nums2));
    }
}
class Demo0004{
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){

        double num = 0.0;
        int len1 = nums1.length;//数组1的长度
        int len2 = nums2.length;//数组2的长度
        int numsLength = (len1 + len2)/2;//两个数组整体长度的一半

        if(len1>len2){//数组长度不同时，同一把数组一换成小的
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        len1 = nums1.length;
        len2 = nums2.length;

        if( nums1.length< nums1.length+1 && nums2.length<nums2.length+1){
            nums1 = Arrays.copyOf(nums1,nums1.length + nums2.length);
            int newLength = nums1.length;
            int i = len1--+--len2;
            while(len2>=0) {
                nums1[i--] = len1>=0 && nums1[len1]>nums2[len2] ? nums1[len1--] : nums2[len2--];
            }
            //System.out.println(Arrays.toString(nums1));//测试
            if((newLength) % 2 == 1){
                return ( nums1[newLength/2]);    /*[0,0,0,0,0],[-1,0,0,0,0,0,1]*/
            }else {
                return ((double) nums1[numsLength]+nums1[numsLength-1])/2;
            }
        }
        return num;
    }
}
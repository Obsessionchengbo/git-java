package Answer;

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
        System.out.println(Demo04.findMedianSortedArrays(nums1,nums2));
    }
}

class Demo04{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double num = 0.0;
        int len1 = nums1.length;//数组1的长度
        int left1 = 0;//数组1的左指针
        int right1 = len1-1;//数组1的右指针
        int len2 = nums2.length;//数组2的长度
        int left2 = 0;//数组2的左指针
        int right2 = len2-1;//数组2的右指针

        //两个数组中有空的数组的时候
        if(nums1.length==0){
            if(len2 % 2 == 0){
                num = ((double) nums2[0] + nums2[right2])/2;
            }else {
                num = (nums2[len2/2]);
            }
            return num;
        }else if(nums2.length==0){
            if(len1 % 2 == 0){
                num = ((double) nums1[0] + nums1[right1])/2;
            }else {
                num = (nums1[len1/2]);
            }
            return num;
        }


        int numsLength = (len1 + len2)/2;//两个数组整体长度的一半


        //数组不出现混插的情况
        if(nums2[0] >= nums1[right1]) {//数组2整体大于数组1时
            //长度相等时
            if (len1 == len2) {
                num = ((double) nums1[right1] + nums2[0])/2;
                return num;
            }else if(len1>len2){//数组1长于数组2的话，中位数在数组一中产生；
                num = ((double)nums1[numsLength] + nums1[right1-(numsLength-len2)])/2;
                return num;
            }else {
                num = ((double) nums2[numsLength-len1]+nums2[right2-numsLength])/2;
                return num;
            }
        }else if(nums1[0] >= nums2[right2]){//数组1整体大于数组2时
            //长度相等时
            if (len1 == len2) {
                num = ((double) nums1[0] + nums2[right2])/2;
                return num;
            }else if(len1>len2){//数组1长于数组2的话，中位数在数组一中产生；
                num = ((double)nums1[numsLength-len2] + nums1[right1-numsLength])/2;
                return num;
            }else {
                num = ((double) nums2[numsLength]+nums2[right2-(numsLength-len1)])/2;
                return num;
            }
        }

        //数组出现混插的情况
        if(len1>len2){//数组长度不同时，同一把数组一换成小的
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        len1 = nums1.length;
        len2 = nums2.length;
        int m = len1/2;//数组一的指针
        int n = len2/2;//数组二的指针

        //数组有长度为1时的情况
        if(len1 == 1 || len2 == 1){
            if(len1 == len2){
                return ((double)nums1[0]+nums2[0])/2;
            }
            //两数相等
            if(nums1[0]==nums2[n]){
                return nums1[0];
            }

            if(len2%2 == 1) {
                if (nums1[0] > nums2[n] && nums1[0] > nums2[n + 1]) {
                    return ((double) nums2[n] + nums2[n + 1]) / 2;
                }else if((nums1[0] > nums2[n] && nums1[0] < nums2[n + 1])||(nums1[0] < nums2[n] && nums1[0] > nums2[n - 1])){
                    return ((double) nums2[n] + nums1[0])/2;
                }else if(nums1[0] < nums2[n] && nums1[0] < nums2[n-1]){
                    return ((double) nums2[n] + nums2[n - 1])/2;
                }
            }else {
                if(nums1[0] < nums2[n-1]){
                    return nums2[n-1];
                }else if(nums1[0] > nums2[n]){
                    return nums2[n];
                }else if(nums1[0]<nums2[n] && nums1[0]>nums2[n-1]){
                    return nums1[0];
                }
            }
        }
        //System.out.println("nums1[0]="+nums1[0]+"   nums2[n]="+nums2[n]+"    nums2[n-1]="+nums2[n-1]);//测试


        try {
            int[] arr = new int[4];

            //数组长度皆为偶数时
            if(nums1.length % 2 == 0 && nums2.length % 2 == 0){
                while (nums1[m] < nums2[n - 1] || nums2[n] < nums1[m - 1]){
                    if(nums1[m] < nums2[n - 1]){
                        m++;
                        n--;
                    }else if(nums2[n] < nums1[m - 1]){
                        m--;
                        n++;
                    }
                    if(m-1 == 0|| m+1 == nums1.length || n-1 == 0 || n+1 == nums2.length){
                        //System.out.println("数组越界警告！！！");
                        break;
                    }


                }
                /*System.out.println("nums1[m]="+nums1[m]+"    nums2[n]="+nums2[n]+"  " +
                        "  nums1[m-1]="+nums1[m-1]+"    nums2[n-1]="+nums2[n-1]+
                        "   n="+n+"     m="+m);//测试*/
                    arr[0] = nums1[m];
                    arr[1] = nums2[n];
                    arr[2] = nums1[m-1];
                    arr[3] = nums2[n-1];
                    Arrays.sort(arr);
                    return ((double)arr[1]+arr[2])/2;

            }else {
                while (nums1[m] > nums2[n] || nums2[n - 1] > nums1[m + 1]){
                    /*System.out.println("nums1[m]="+nums1[m]+"    nums2[n]="+nums2[n]+
                            "    nums1[m+1]="+nums1[m+1]+"    nums2[n-1]="+nums2[n-1]);//测试*/
                    if(nums1[m] > nums2[n]){
                        m--;
                        n++;
                    }else if(nums2[n-1] > nums1[m+1]){
                        n--;
                        m++;
                    }
                }
                arr[0] = nums1[m];
                arr[1] = nums2[n];
                arr[2] = nums1[m+1];
                arr[3] = nums2[n-1];
                Arrays.sort(arr);
                if((len1+len2)%2 == 1){
                    return arr[1];
                }else return ((double)arr[1]+arr[2])/2;
            }
        } catch (Exception e) {
            //System.out.println("测试！！！");//测试
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
        }
        return num;
    }

}
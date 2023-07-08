package Answer;

import java.util.Arrays;
import java.util.Scanner;

public class Test0011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int n = scanner.nextInt();
        int[] height = new int[n];
        System.out.println("请输入" + n + "个数的值");
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        System.out.println("输入："+Arrays.toString(height));
        Solution11 area = new Solution11();
        System.out.println("输出：" + area.maxArea(height));
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int num = 0;
        int k = 1;
        int[] a = new int[1];
        if(height.length == 2){
            num = Math.min(height[0], height[1]);
            a[0] = num;
            return num;
        }else {
            for (int i = 0; i < height.length; i++) {
                for (int j = i+1; j < height.length; j++){
                    if(height[i] < height[j]){
                        num = height[i]*(j-i);
                    }else {
                        num = height[j]*(j-i);
                    }
                    a = Arrays.copyOf(a,a.length+1);
                    a[k++] = num;
                }
            }
        }


        int b = 0;
        int max = 0;
        for (int i = 1; i <= a.length-1; i++) {
            b = Math.max(a[i], a[i - 1]);
            max = Math.max(b, max);
        }

        return max;
    }
}
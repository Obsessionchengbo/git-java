import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,4,5,6,7,8,9,10};
        S.remove(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class S{
    public static void remove(int[] arr){
        int[] nums = {9,8,7,6,5,4,3,2,1};

        arr = nums;
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(arr));
    }
}

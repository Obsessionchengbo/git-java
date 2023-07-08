package Answer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*「快乐数」定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为1，那么这个数就是快乐数。
*/

public class Test0202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要判断的数字:");
        int n = 0;
        n = scanner.nextInt();
        System.out.println("判断结果为:" + Demo0202.isHappy(n));

    }
}

//@SuppressWarnings("all")
class Demo0202 {

    public static boolean isHappy(int n) {

        if(n == 1) return true;

        int sum = 0;//平方和数
        int num = 0;//个位数字
        int temp = 0;//除十取余后的数字
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        do {
            sum = 0;
            list.clear();
            do {
                num = n % 10;
                temp = n / 10;
                n = temp;
                list.add(num);
            } while (temp / 10 != 0);
            list.add(temp);

            for (Integer integer : list) {
                sum += integer * integer;
            }

            n = sum;

            if(hashMap.containsKey(n)){
                return false;
            }

            while (n > 10) {
                n %= 10;
            }
            n = sum;
           if(n == 1){
                return true;
            }

            hashMap.put(n,n);

        } while (true);
    }
}

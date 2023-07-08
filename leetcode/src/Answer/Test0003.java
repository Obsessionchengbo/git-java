package Answer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Test0003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        System.out.println("请输入要判断的字符串s：");
        s = scanner.next();
        System.out.println("该字符串的最长子串的长度为："+Demo3.lengthOfLongestSubstring(s));
    }
}

class Demo3 {
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        char[] chars = new char[len];
        int[] count = new int[]{};//最大无重复字符串,初始值为一
        int j = 0;
        int num = 1;
        int max = 0;
        if(len == 1) return num;
        if(s.equals("")){
            return 0;
        }else {
            chars[0] = s.charAt(0);//给第一个字符数组赋值，以免后边遍历不到
            HashMap<Character,Integer> hashMap = new HashMap<>(len-1);//Character是字符对象
            hashMap.put(chars[0],0);
            for (int i = 1; i <= len-1; i++) {
                chars[i] = s.charAt(i);
                if(hashMap.containsKey(chars[i])){
                    count = Arrays.copyOf(count,count.length+1);
                    count[j++] = num;//将每段不重复的字符串长度放入数组中
                    num = i-hashMap.get(chars[i]);//清空哈希表后字符长度初始值为重复字符下标减去上一个重复数字下标
                    hashMap.remove(chars[i]);
                    hashMap.put(chars[i],i);//将当前字符再放入哈希表中，避免漏掉字符
                }else {
                    hashMap.put(chars[i],i);
                    num++;
                    count = Arrays.copyOf(count,count.length+1);
                    count[j++] = num;
                }
                System.out.println(Arrays.toString(count));//测试
            }
            Arrays.sort(count);//count数组进行排序
            max = count[count.length-1];//排序后最后一位数就是最大值
            return max;
        }
    }
}


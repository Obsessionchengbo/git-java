package Experiment7;

import java.io.*;
import java.util.Scanner;

public class Test17_10
{

        public static void main(String[] args) throws IOException {
            System.out.println("请输入需要分割文件的地址：");
            String filename = new Scanner(System.in).nextLine();
            File file = new File(filename);
            long lon= file.length();
            System.out.println("请输入要分割的数量：");
            int n = new Scanner(System.in).nextInt();
            long i = lon/n;
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
            BufferedOutputStream bos = null;
            byte bytes[]=new byte[(int) i];
            for (int j = 0; j<n; j++) {
                String Filename =  "E:\\桌面\\aaa\\"+ "bbb" + j + ".mp4";
                File file1 = new File(Filename);
                while ((bis.read(bytes)) != -1) {
                    bos = new BufferedOutputStream(new FileOutputStream(Filename));
                    bos.write(bytes);
                    if(file1.length() == i){
                        break;
                    }
                    bos.close();
                }
            }
            System.out.println("分割完成！");
            bis.close();
        }
    }
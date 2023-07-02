package Experiment7;

import java.io.*;



public class Test17_12
{
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("E:\\桌面\\bbb\\ccc.mp4");
        File f = new File("E:\\桌面\\aaa");
        File [] files = f.listFiles();
        for (File file :files )
        {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = new byte[1024*1024*5];
            int len;
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            fis.close();
        }
        System.out.println("合成完成！");
        fos.close();
    }
    }


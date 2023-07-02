package MyHello;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Javaclass {
    public static void main(String[] args) throws IOException {
        /*File f1 = new File("E:\\桌面\\aaa.txt");
        FileOutputStream outToFile = new FileOutputStream(f1);
        outToFile.write(97);
        byte[]b={1,3,5,7,9,11,13,};
        outToFile.write(b);
        outToFile.write(b,1,3);*/
        File f1 = new File("E:\\\\桌面\\\\aaa.txt");
        /*FileOutputStream outToFile = new FileOutputStream(f1);
        for(int i=1;i<=13;i++)
            outToFile.write(i);
        outToFile.close();*/
        FileInputStream inFromFile = new FileInputStream(f1);
        /*int b;
        while((b=inFromFile.read())!=-1)
        System.out.println(b);
        inFromFile.close();*/
        byte[]b=new byte[20];
        int num = inFromFile.read(b);
        for(int i=0;i<num;i++)
            System.out.println(b[i]);
    }
}

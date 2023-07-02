package Experiment6;

import java.io.File;
import java.io.IOException;

public class TestFileClass {public static void main(String[] args) throws IOException{
    //文件方法熟悉
    java.io.File file1 = new java.io.File("E://桌面//score.txt");
    java.io.File file2 = new java.io.File("E://桌面//score.txt");
    //file.createNewFile();
    System.out.println("Does it exits? "+file1.exists());
    System.out.println("The file has "+file1.length());
    System.out.println("Can it be read? "+file1.canRead());
    System.out.println("Can it be written? "+file1.canWrite());
    System.out.println("IS it a directory? "+file1.isDirectory());
    System.out.println("Is it a file? "+file1.isFile());
    System.out.println("Is it absolute? "+file1.isAbsolute());
    System.out.println("Is it hidden? "+file1.isHidden());
    System.out.println("Absolute path is "+file1.getAbsolutePath());

}

    public static void showFileList(File fd){
        System.out.println(fd.getAbsolutePath()+" <dir>");
        File[]files=fd.listFiles();
        for(File f:files){
            if(f.isFile()&&f.getName().toLowerCase().endsWith("java"))
                System.out.println(f.getName()+ " <file>");
        }
    }

    public static void delDir(File fd){
        File[]files = fd.listFiles();
        for(File f:files){
            if(f.isDirectory())
                delDir(f);
            else
                f.delete();
            }
        fd.delete();
        System.out.println("Delete successed!");
    }
}


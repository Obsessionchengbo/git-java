package Experiment6;

import java.io.File;

public class Delete {
    public static void main(String[] args) {
        File dir = new File("E:/桌面/a");
        deleteDir(dir);
        System.out.println("删除完成！");
    }
    public static void deleteDir(File fd) {
        File[] files = fd.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                deleteDir(f);
            else
                f.delete();
        }
        fd.delete();
    }
}
package Experiment6;

import java.io.File;
import java.io.IOException;

public class Find {
        public static void main(String[] args) throws IOException {
            File f2 = new File("E:\\First\\src\\Experiment3");
            show(f2);
        }
        static void show(File file){
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()){
                    show(file1);
                }
                else
                if (file1.getName().endsWith("java"))
                    System.out.println(file1.getName());
            }
        }
    }


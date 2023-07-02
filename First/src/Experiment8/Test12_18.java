package Experiment8;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test12_18 {
    public static void main(String [] args) throws Exception {

    try (Scanner userInput = new Scanner(System.in)) {
        System.out.println("输入源根目录：");
        String sourceFile = userInput.nextLine();

        File initialFile = new File(sourceFile);
        if (!initialFile.exists())
        {
            System.out.println(sourceFile + " 是不存在的");
            System.exit(2);
        }
        addPackage(initialFile);
    }
}

    public static void addPackage(File initialFile) throws Exception
    {
        if (initialFile.isFile() && initialFile.getName().endsWith(".java"))
        {
            add(initialFile);
        }
        else if (initialFile.isDirectory())
        {
            File[] fileList = initialFile.listFiles();
            for (File file : fileList)
            {
                addPackage(file);
            }
        }
    }

    public static void add(File file) throws Exception
    {
        ArrayList<String> fileContent = new ArrayList<>();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext())
            {
                fileContent.add(new String(input.nextLine()));
            }
        }
        try(
                PrintWriter output = new PrintWriter(file);
        ){
            output.println("package " + file.getParent()+";");
            for (String content : fileContent)
            {
                output.println(content);
            }
        }
    }
}

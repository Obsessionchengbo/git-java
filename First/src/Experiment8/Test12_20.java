package Experiment8;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test12_20 { public static void main(String [] args) throws Exception
{
    try (Scanner userInput = new Scanner(System.in)) {
        System.out.println("输入源根目录：");
        String sourceFile = userInput.nextLine();

        File initialFile = new File(sourceFile);
        if (!initialFile.exists())
        {
            System.out.println(sourceFile + " 是不存在的");
            System.exit(2);
        }
        deleteWords(initialFile);
    }
}
    public static void deleteWords(File file) throws Exception
    {
        if (file.isFile())
        {
            delete(file);
        }
        else
        {
            File[] fileList = file.listFiles();
            for (File everyFile : fileList)
            {
                deleteWords(everyFile);
            }
        }
    }

    public static void delete(File file) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext())
            {
                list.add(input.nextLine());
            }
        }

        if (list.get(0).equals("package " + file.getParent()+";"))
        {

            list.remove(0);
        }


        try(
                PrintWriter output = new PrintWriter(file);
        ){
            for (String everyLine : list)
            {
                output.println(everyLine);
            }
        }

    }

    public static void print(ArrayList<String> list)
    {
        for (String str : list)
        {
            System.out.println(str);
        }
    }
}

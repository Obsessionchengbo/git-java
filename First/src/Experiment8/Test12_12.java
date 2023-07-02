package Experiment8;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test12_12 {

    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        System.out.println("输入源文件：");
        String sourceFile = userInput.nextLine();

        File file = new File(sourceFile);
        if (!file.exists()) {
            System.out.println("File : " + sourceFile + " 不存在");
            System.exit(2);
        }

        try (
                PrintWriter output = new PrintWriter("E:\\桌面\\Test2\\Chapter 12\\newscore.java");
                Scanner input = new Scanner(file);
        ) {

            ArrayList<String> recode = new ArrayList<>();
            while (input.hasNextLine()) {
                recode.add(new String(input.nextLine()));
            }
            for (int i = 0; i < recode.size() - 1; i++) {
                if (recode.get(i + 1).contains("{")) {
                    String newLine = recode.get(i) + "{";
                    recode.set(i, newLine);

                    recode.remove(i + 1);
                }
            }

            for (int i = 0; i < recode.size(); i++) {
                output.println(recode.get(i));
            }
            System.out.println("成功！");
        }
        userInput.close();
    }

}

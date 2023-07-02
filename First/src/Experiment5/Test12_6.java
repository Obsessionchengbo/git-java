package Experiment5;

import java.util.Scanner;

public class Test12_6 {
    public static void main(String[] args) {

    boolean continueLoop = true;
    Scanner input = new Scanner(System.in);
    while (continueLoop) {

        System.out.print("Enter a hex number: ");
        try {
            String hex = input.nextLine();

            System.out.println("The decimal value for hex number " + hex
                    + " is " + hexToDecimal(hex.toUpperCase()));
           //input.close();
        } catch (NumberFormatException ex) {
            System.out.println("您输入的不是十六进制数");
        }
    }
}

    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }
    public static int hexCharToDecimal(char ch) throws java.lang.NumberFormatException {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else if (ch >= '0' && ch <= '9')
            return ch - '0';
        else throw new java.lang.NumberFormatException("您输入的数不是十六进制的数");
    }
}

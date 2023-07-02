package Experiment5;

import java.util.Scanner;

public class Test12_8 {
    public static void main(String[] args) throws HexFormatException_1 {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a hex number: ");
    String hex = input.nextLine();
    System.out.println("The decimal val" +
            "" + "use for hex number " + hex
            + " is " + hexToDecimal(hex.toUpperCase()));
    input.close();
}

    public static int hexToDecimal(String hex) throws HexFormatException_1 {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }

        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) throws HexFormatException_1 {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else if (ch >= '0' && ch <= '9')
            return ch - '0';
        else throw new HexFormatException_1(ch);
    }
}
class HexFormatException_1 extends Exception{
     private char ch;

    HexFormatException_1(char ch) {
        super("您输入的输入不是十六进制的数" + ch);
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }
}

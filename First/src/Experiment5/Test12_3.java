package Experiment5;

import java.util.Scanner;

public class Test12_3 {
    public static void main(String[] args){
    int [] randomNumberArray=new int[100];
    for(int i=0;i<randomNumberArray.length;i++){

        randomNumberArray[i]=(int)(Math.random()*100);
    }
    boolean continueLoop=true;
    Scanner input = new Scanner(System.in);
    while(continueLoop){
        System.out.print("Please input a index of the array: ");
        try{
            int number =input.nextInt();
            if(number==-1){
                continueLoop=false;
            }
            else
                System.out.println("Input element is "+randomNumberArray[number]);
        }
        //程序只能输入int类型，否则报错
        catch(java.util.InputMismatchException ex){
            System.out.println("Wrong input!");
            input.nextLine();
        }
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Out of Bounds");
        }
    }
    input.close();
}
}

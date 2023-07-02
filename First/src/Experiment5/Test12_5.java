package Experiment5;

import java.util.Scanner;

public class Test12_5 {public static void main(String[] args){
    boolean continueLoop=true;
    double side1=0.0;
    double side2=0.0;
    double side3=0.0;

    Triangle triangle1 = new Triangle();
    triangle1.TriangleException();


}
}

class SimpleGeometricObject{
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    // 空的构造方法
    public SimpleGeometricObject(){
        dateCreated=new java.util.Date();
    }
    //带参数的构造方法
    public SimpleGeometricObject(String color,boolean filled){
        dateCreated=new java.util.Date();
        this.color=color;
        this.filled=filled;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color=color;
    }
    public boolean isFiled(){
        return filled;
    }
    public void setFilled(boolean filled){
        this.filled=filled;
    }
    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    public String toString(){
        return "SimpleGeometricObject{"+"color= "+color+",filled= "+filled+",dateCreated= "+dateCreated+"}";
    }
}

class Triangle extends SimpleGeometricObject{
    private double side1;
    private double side2;
    private double side3;
    public boolean continueLoop = true;
    int b;

     public Triangle(){
        side1=0.0;
        side2=0.0;
        side3=0.0;
    }

    public Triangle(double side1,double side2,double side3) throws IllegalArgumentException{
        if((side1+side2>side3&&side1+side3>side2&&side2+side3>side1)&&(side1>0&&side2>0&&side3>0)){
            this.side1=side1;
            this.side2=side2;
            this.side3=side3;
        }
        else throw new IllegalArgumentException("The input sides cannot form a triangle");
    }

    public void TriangleException() {
        Scanner input=new Scanner(System.in);
        while (continueLoop) {
            System.out.print("Please input side1,side2,side3: ");
            try {
                side1 = input.nextDouble();
                side2 = input.nextDouble();
                side3 = input.nextDouble();
                System.out.println("请输入提示指令（1表示继续执行，其他数字表示退出程序）：");
                b = input.nextInt();
                if (b == 1) {
                    Triangle triangle = new Triangle(side1, side2, side3);
                    System.out.println(triangle.toString() + "  " + triangle.getArea() + "  " + triangle.getPerimeter());

                }
                else {

                    continueLoop = false;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("The input sides cannot form a triangle");
            }
        }
        input.close();
    }

    public double getSide1(){
        return side1;
    }
    public void setSide1(double side1){
        this.side1=side1;
    }
    public double getSide2(){
        return side2;
    }
    public void setSide2(double side2){
        this.side2=side2;
    }
    public double getSide3(){
        return side3;
    }
    public void setSide3(double side3){
        this.side3=side3;
    }
    public double getArea() {
        double n = side1 + side2 + side3;
        return Math.sqrt(n * (n - side1) * (n - side2) * (n - side3));
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    public String toString() {
        return "TestTriangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}

package Text;

public class TestSimpleCircle {
    public static void main(String[] args){
        SimpleCircle circle1=new SimpleCircle();
        System.out.println("The area of the circle of radius"+circle1+"is"+circle1.getArea());
        SimpleCircle circle2=new SimpleCircle(25);
        System.out.println("The area of the circle of radius"+circle2+"is"+circle2.getArea());
        SimpleCircle circle3=new SimpleCircle(125);
        System.out.println("The area of the circle of radius"+circle3+"is"+circle3.getArea());
    }
}
class SimpleCircle{
    double radius;
    SimpleCircle(){
        radius=1;
    }
    SimpleCircle(double newRadius){
        radius=newRadius;
    }
    double getArea(){
        return radius*radius*Math.PI;
    }
    double getPerimeter(){
        return 2*radius*Math.PI;
    }
    void setRadius(double newRadius){
        radius=newRadius;
    }
}

package Experiment4;

public class Rectangle extends GeometricObject {
    private final double width;
    private final double height;

    public Rectangle(double width,double height){
        this.width=width;
        this.height=height;
    }

    public double getArea(){
        return width*height;
    }
    public double getPerimeter(){
        return 2*(width+height);
    }
    public String toString(){
        return("Width is "+width+" Height is "+height+" \t/Area is "+getArea());
    }
}

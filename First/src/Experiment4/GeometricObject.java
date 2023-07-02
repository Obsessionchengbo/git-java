package Experiment4;

public abstract class GeometricObject {

    protected GeometricObject(){
    }
    protected GeometricObject(boolean filled){
    }

    public void setColor(String color){
    }

    public void setFilled(boolean filled){
    }


    public abstract double getArea();
    public abstract double getPerimeter();
}



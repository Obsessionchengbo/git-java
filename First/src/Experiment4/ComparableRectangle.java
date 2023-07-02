package Experiment4;

public class ComparableRectangle extends ComparableGeometricObject {
    private double width;
    private double height;

    public ComparableRectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public ComparableRectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
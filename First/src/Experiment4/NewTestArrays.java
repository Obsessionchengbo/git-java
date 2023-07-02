package Experiment4;

import java.util.Arrays;

public class NewTestArrays {
    public static void main(String[] args) {
        ComparableGeometricObject[] shapes = {
                new ComparableCircle(5),
                new ComparableRectangle(10, 5),
                new ComparableCircle(3),
                new ComparableRectangle(8, 4)
        };

        Arrays.sort(shapes);

        for (ComparableGeometricObject shape : shapes) {
            System.out.printf("Area: %f, Perimeter: %f\n", shape.getArea(), shape.getPerimeter());
        }
    }
}

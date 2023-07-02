package Experiment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TestArrays {public static void main(String[] args){
    ArrayList<GeometricObject> shapes=new ArrayList<>();
    shapes.add(new Circle(5));
    shapes.add(new Rectangle(10,5));
    shapes.add(new Circle(3));
    shapes.add(new Rectangle(8,4));
    System.out.println("The Arrays of shapes is: ");
    for (GeometricObject shape : shapes) {
        System.out.println(shape.toString());
    }


    GeometricObject[] Newshapes = {new Circle(5), new Rectangle(10, 5), new Circle(3), new Rectangle(8, 4)};
    Arrays.sort(Newshapes, Comparator.comparingDouble(GeometricObject::getArea));
    GeometricObject largest = Newshapes[Newshapes.length - 1];

    for(GeometricObject o:Newshapes){
        System.out.printf("Area: %f, Perimeter: %f\n",o.getArea(),o.getPerimeter());
    }

    System.out.println("The largest instance is: " + largest.toString());
}
}

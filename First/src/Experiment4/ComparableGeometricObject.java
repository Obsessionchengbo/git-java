package Experiment4;

public abstract class ComparableGeometricObject extends GeometricObject
        implements Comparable<ComparableGeometricObject>{
    public ComparableGeometricObject() {
        super();
    }
    public ComparableGeometricObject(String color, boolean filled) {
        super(filled);
    }
    public int compareTo(ComparableGeometricObject o){
        if (this.getArea()>o.getArea())
            return 1;
        else if(getArea()<o.getArea())
            return -1;
        else
            return 0;
    }
}

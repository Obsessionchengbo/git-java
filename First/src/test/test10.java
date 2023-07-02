package test;

public class test10 {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadious(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());

        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadious(5);
        fan2.setColor("blue");
        fan2.setOn(false);
        System.out.println(fan2.toString());
    }
}
class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radious = 5;
    private String color = "blue";

    public Fan() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadious() {
        return radious;
    }

    public void setRadious(double radious) {
        this.radious = radious;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        if (on) {
            return speed + "\t" + color + "\t" + radious;
        } else {
            return "fan is off" + "\t" + color + "\t" + radious;
        }

    }
}


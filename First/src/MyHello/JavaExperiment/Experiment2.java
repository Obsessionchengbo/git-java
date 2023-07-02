package MyHello.JavaExperiment;
import java.util.Scanner;
public class Experiment2 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("请输入a,b,c:");
            double a = input.nextDouble();
            double b = input.nextDouble();
            double c = input.nextDouble();
            QuadraticEquation q =new QuadraticEquation(a,b,c);
            if(q.getRoot1()==0 && q.getRoot2()==0)
            {
                System.out.println("The equation has no roots");
            }else if(q.getRoot1()==q.getRoot2())
            {
                System.out.println(q.getRoot1());
            }else
            {
                System.out.println("root1 = "+q.getRoot1()+","+"root2 = "+q.getRoot2());
            }
        }
    }
}
class QuadraticEquation
{
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(double a,double b,double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant()
    {
        return b*b - 4*a*c;
    }
    public double getRoot1()
    {
        double root1 = (-b +Math.sqrt(this.getDiscriminant()))/(2*a);
        if(getDiscriminant() >= 0)
        {
            return root1;
        }else
        {
            return 0;
        }
    }
    public double getRoot2()
    {
        double root2 = (-b - Math.sqrt(this.getDiscriminant()))/(2*a);
        if(getDiscriminant() >= 0)
        {
            return root2;
        }else
        {
            return 0;
        }
    }
}

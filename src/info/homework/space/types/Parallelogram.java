package info.homework.space.types;

import info.homework.space.Shapes;
import info.homework.space.properties.Colors;

import java.util.StringJoiner;

public class Parallelogram extends Shapes {
    private double base;
    private int angle;
    private double side3=angle;

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }



    @Override
    public String toString() {
        return new StringJoiner(", ", Parallelogram.class.getSimpleName() + "[", "]")
                .add("base=" + base)
                .add("angle=" + angle)
                .add("side3=" + side3)
                .add("name='" + name + "'")
                .add("x=" + x)
                .add("y=" + y)
                .add("size='" + size + "'")
                .toString();
    }

    public Parallelogram(int id,String name, double width, double height, int angle, String size, boolean figure) {
        super(id,name, width, height, size, figure);
        this.angle=angle;
    }

    public Parallelogram(int id,String name, double width, double height, double side3, String size, boolean figure) {

        super(id,name, width, height, size, figure);
        this.side3=side3;

    }
    public Parallelogram (double width, double height, int angle){
        super(width, height);
        this.angle=angle;
    }

    public Parallelogram (double width, double height, double base) {
        super(width, height);
        this.base=base;

    }


    @Override
    public void calculateArea() {
        double S =  x * base;
        System.out.println("The area of the parallelogram by H is: " + S);
    }

    public void calculateAreaByAngle() {
        double sin_x = Math.sin(Math.toRadians(angle));
        double S = x * x * sin_x;
        System.out.println("The area of the parallelogram by angle is: " + S);
    }



    @Override
    public void size() {

    }

    @Override
    public void shapecolor() {
        System.out.println("The color of parellelogram is: " + Colors.GREEN);

    }
}

package info.homework.space.types;

import info.homework.space.Shapes;

import java.util.StringJoiner;

public class Rhombus extends Shapes {
    private double radius;
    private int angle;



    public Rhombus(double width, double height) {
        super(width, height);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Rhombus.class.getSimpleName() + "[", "]")
                .add("radius=" + radius)
                .add("angle=" + angle)
                .add("name='" + name + "'")
                .add("x=" + x)
                .add("y=" + y)
                .add("size='" + size + "'")
                .toString();
    }

    public Rhombus(int id,String name, double width, double height,int angle,String size, boolean figure ) {
        super(id,name, width, height, size, figure);
        this.angle = angle;
    }

    @Override
    public void calculateArea() {
        double  area=(x*x)/2;
        System.out.println("Area of Rhombus is: " + area);

    }

    public void calculateAreaByAngle() {
        double b = Math.toRadians(y);
        double area=y*y*(Math.sin(b));
        if (y <= 0)
            System.out.println("Length should be positve");
        else
            System.out.println("Area of rhombus by angle = "+ area);
    }

    public void calculateAreaByRadius() {
        double  area=2*x*radius;
        System.out.println("Area of Rhombus is: " + area);

    }
    @Override
    public void size() {

    }

    @Override
    public void shapecolor() {

    }
}


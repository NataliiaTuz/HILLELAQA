package info.homework.space.types;

import info.homework.space.Shapes;
import info.homework.space.properties.Colors;
import info.homework.space.properties.Size;

import java.util.StringJoiner;

public class Triangle extends Shapes {
    private double side3;

    @Override
    public String toString() {
        return new StringJoiner(", ", Triangle.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("width=" + x)
                .add("height=" + y)
                .add("size='" + size + "'")
                .toString();
    }

    public Triangle(int id,String name, double width, double height, double side3, String size, boolean figure) {
        super(id,name, width, height, size, figure);
        this.side3=side3;

    }

    public Triangle(double width, double height, double side3) {
        super(width, height);
        this.side3 = side3;
    }

    @Override
    public void calculateArea() { // replace method StringJoiner
        double P = (y + x + side3) / 2;
        double S = Math.sqrt(P * (P - y) * (P - x) * (P - side3));
        System.out.println("The area of the triangle is: " + S);
    }

    @Override
    public void size() {
        System.out.println(Size.SMALL);
    }

    @Override
    public void shapecolor() {
        System.out.println("The color of triangle is: " + Colors.BLACK);

    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
}

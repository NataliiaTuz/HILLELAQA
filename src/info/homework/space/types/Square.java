package info.homework.space.types;

import info.homework.space.Shapes;
import info.homework.space.properties.Colors;
import info.homework.space.properties.RotatAble;
import info.homework.space.properties.Size;

import java.util.StringJoiner;

public class Square extends Shapes implements RotatAble {
private double side3;

    @Override
    public String toString() {
        return new StringJoiner(", ", Square.class.getSimpleName() + "[", "]")
                .add("side3=" + side3)
                .add("name='" + name + "'")
                .add("x=" + x)
                .add("y=" + y)
                .add("size='" + size + "'")
                .toString();
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public Square(int id, String name, double width, double height, double side3, String size, boolean figure) {
        super(id,name, width, height, size, figure);
        this.side3=side3;
    }

    public Square(String size) {
        super(size);
    }

    @Override
    public void shapecolor() {
        System.out.println("The color of square is: " + Colors.BLUE);
    }

    @Override
    public void calculateArea() {
        double S = x * y;
        System.out.println("Area of square is: " + S);
    }

    @Override
    public void size() {
        System.out.println(Size.SMALL);
    }


    @Override
    public void rotate() {
        System.out.println("The Space.types.Square shape can rotate!");
    }
}

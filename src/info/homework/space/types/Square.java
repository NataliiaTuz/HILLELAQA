package info.homework.space.types;

import info.homework.space.Shapes;
import info.homework.space.properties.Colors;
import info.homework.space.properties.RotatAble;
import info.homework.space.properties.Size;

import java.util.StringJoiner;

public class Square extends Shapes implements RotatAble {

    @Override
    public String toString() {
        return new StringJoiner(", ", Square.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("width=" + x)
                .add("height=" + y)
                .add("size='" + size + "'")
                .toString();
    }

    public Square(String name, double width, double height, String size, boolean figure) {
        super(name, width, height, size, figure);
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

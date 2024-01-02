package info.homework.space.types;

import info.homework.space.Shapes;
import info.homework.space.properties.Colors;
import info.homework.space.properties.Size;

import java.util.StringJoiner;

public class Rectangle extends Shapes {

    @Override
    public String toString() {
        return new StringJoiner(", ", Rectangle.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("width=" + y)
                .add("height=" + x)
                .add("size='" + size + "'")
                .toString();
    }

    public Rectangle(int id,String name, double width, double height, String size, boolean figure) {
        super(id,name, width, height, size, figure);
    }
    public Rectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public void shapecolor() {
        System.out.println("The color of Space.types.Rectangle is: " + Colors.GREEN);
    }

    @Override
    public void calculateArea() { //replace method String concat(+)
        double S = x * y;
        System.out.println("Area of Space.types.Rectangle is: " + S);
    }

    @Override
    public void size() {
        System.out.println(Size.LARGE);
    }
}

package info.homework.space.types;

import info.homework.space.Shapes;

import java.util.StringJoiner;

public class Ellipse extends Shapes {




    @Override
    public String toString() {
        return new StringJoiner(", ", Ellipse.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("x=" + x)
                .add("y=" + y)
                .add("size='" + size + "'")
                .toString();
    }

    public Ellipse(String name, double width, double height, String size, boolean figure) {
        super(name, width, height, size, figure);
    }

    @Override
    public void calculateArea() {
        double S = Math.PI*x*y;
        System.out.println("The area of the Ellipse =" + S);
    }

    @Override
    public void size() {

    }

    @Override
    public void shapecolor() {

    }
}

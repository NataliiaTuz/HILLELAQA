package info.homework.space.types;

import info.homework.space.Shapes;

import java.util.StringJoiner;

public class Ellipse extends Shapes {
private double side3;


    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ellipse.class.getSimpleName() + "[", "]")
                .add("side3=" + side3)
                .add("name='" + name + "'")
                .add("x=" + x)
                .add("y=" + y)
                .add("size='" + size + "'")
                .toString();
    }


//    public Ellipse(int id,String name, double width, double height,double side3, String size, boolean figure) {
//        super(id,name, width, height, size, figure);
//        this.side3=side3;
//    }

    public Ellipse(int id, String name, double width, double height, double side3, String size, boolean figure)  {
        super(id, name, width, height, size, figure);
        this.side3 = side3;
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

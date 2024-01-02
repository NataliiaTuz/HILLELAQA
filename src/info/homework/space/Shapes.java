package info.homework.space;

import java.util.Comparator;
import java.util.StringJoiner;

public abstract class Shapes { // change the class to abstract
    protected String name;
    protected double x;
    protected double y;
    protected String size;
    private boolean figure;
    private int id;

    @Override
    public String toString() {
        return new StringJoiner(", ", Shapes.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("x=" + x)
                .add("y=" + y)
                .add("size='" + size + "'")
                .add("figure=" + figure)
                .add("id=" + id)
                .toString();
    }

    public Shapes(int id,String name, double width, double height, String size, boolean figure) {
        this.id=id;
        this.size = size;
        this.x = width;
        this.y = height;
        this.name = name;
        this.figure = figure;
    }

    public Shapes(String size) {
    }

    public Shapes(double width, double height) {
        this.x = width;
        this.y = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    abstract public void calculateArea(); // change the method to abstract

    abstract public void size();// added new method size

    abstract public void shapecolor();// created new method for using enum Space.properties.Colors

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getWidth() {
        return x;
    }

    public void setWidth(double width) {
        this.x = width;
    }

    public double getHeight() {
        return y;
    }

    public void setHeight(double height) {
        this.y = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFigure() {
        return figure;
    }

    public void setFigure(boolean figure) {
        this.figure = figure;
    }

}





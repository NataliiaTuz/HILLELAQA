package info.homework.space.types;

import info.homework.space.properties.ChangePosition;
import info.homework.space.properties.RotatAble;
import info.homework.space.properties.Size;

public class Circle implements ChangePosition, RotatAble {
    private double radius;
    private String name;
    private String isInheritance;
    private String locatedInTheSpace;
    private String type;
private int id;


    public Circle(int id, String name,double radius, String isInheritance, String locatedInTheSpace, String type) { //Replace constructor with builder
        this.id=id;
        this.radius = radius;
        this.name = name;
        this.isInheritance = isInheritance;
        this.locatedInTheSpace = locatedInTheSpace;
        this.type = type;
    }

    @Override
    public void rotate() {
        System.out.println("The circle can rotate");
    }

    @Override
    public void changePos() {
        System.out.println("The circle can change the position");

    }

    public void calculateArea() {
        double area = radius * radius * Math.PI;
        System.out.println("The area of the circle: " + area);
    }

    @Override
    public String toString() {  // Added method String concat(+) and super.toString()
        return "Circle{" + "radius=" + radius + ", name='" + name + '\'' + ", isInheritance='" + isInheritance + '\'' + ", locatedInTheSpace='" + locatedInTheSpace + '\'' + ", type='" + type + '\'' + '}';
    }

    public void CircleInfo() { // replace method String concat(+) and super.toString()
        System.out.println("radius:" + radius + "   name:" + name + "   isInheritance:" + isInheritance + "   locatedInTheSpace" + locatedInTheSpace + "   type:" + type);
    }
}



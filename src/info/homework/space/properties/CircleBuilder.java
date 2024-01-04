package info.homework.space.properties;

import info.homework.space.types.Circle;

import java.util.StringJoiner;

public class CircleBuilder {
    private double radius;
    private String name;
    private String isInheritance;
    private String locatedInTheSpace;
    private String type;
    private int id;

    public CircleBuilder setRadius(double radius) {
        this.radius = radius;
        return this;
    }

    public CircleBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CircleBuilder setIsInheritance(String isInheritance) {
        this.isInheritance = isInheritance;
        return this;
    }

    public CircleBuilder setLocatedInTheSpace(String locatedInTheSpace) {
        this.locatedInTheSpace = locatedInTheSpace;
        return this;
    }

    public CircleBuilder setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() { // added method StringJoiner
        return new StringJoiner(", ", CircleBuilder.class.getSimpleName() + "[", "]").add("radius=" + radius).add("name='" + name + "'").add("isInheritance='" + isInheritance + "'").add("locatedInTheSpace='" + locatedInTheSpace + "'").add("type='" + type + "'").toString();
    }

    public Circle createCircle() {
        return new Circle( id,name,radius, isInheritance, locatedInTheSpace, type);
    }
}
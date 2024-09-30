package _05_class._abstract._prac4;

public abstract class Shape {
    String color;
    String type;

    public Shape(String color, String type) {
        this.color = color;
        this.type = type;
    }

    abstract double calculateArea();

    public String getColor() {
        return color;
    }
}

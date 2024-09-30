package _05_class._abstract._prac4;

import static java.lang.Math.PI;

public class Circle extends Shape{
    
    double radius;
    
    public Circle(String color, String type, double radius) {
        super(color, type);
        this.radius = radius;
    }
    
    @Override
    double calculateArea() {
        return radius * radius * PI;
    }
}

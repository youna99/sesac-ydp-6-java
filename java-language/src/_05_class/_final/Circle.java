package _05_class._final;

public class Circle {
    private final double radius;
    private static final double PI = 3.141592;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculagteArea() {
        return radius * radius * PI;
    }
}

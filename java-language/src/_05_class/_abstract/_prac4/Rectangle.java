package _05_class._abstract._prac4;

public class Rectangle extends Shape{

    double width;
    double height;

    public Rectangle(String color, String type, double width, double height) {
        super(color, type);
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}

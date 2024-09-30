package _05_class._abstract._prac4;

import java.util.ArrayList;

public class ShapeEx {
    public static void main(String[] args) {
        ArrayList<Shape> shapes =  new ArrayList<>();

        Circle circle = new Circle("blue", "Circle", 5);
        Rectangle rectangle = new Rectangle("yellow", "Rectangle", 3, 8);

        shapes.add(circle);
        shapes.add(rectangle);

        for(Shape s : shapes) {
            System.out.println("=== " + s.type + " 도형의 정보 ===");
            System.out.println("도형의 색상: " + s.getColor());
            System.out.println("도형의 넓이: " + s.calculateArea());
            System.out.println();
        }
    }
}

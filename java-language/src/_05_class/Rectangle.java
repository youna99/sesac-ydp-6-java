package _05_class;

public class Rectangle {

    private int width;
    private int height;
    private static int count = 0;

    public Rectangle(int width) {
        this.width = width;
        count++;
    }

    public int getCount() {
        return count;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }

}

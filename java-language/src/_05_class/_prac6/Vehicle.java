package _05_class._prac6;

public abstract class Vehicle {
    private String name;
    private int maxSpeed;

    public Vehicle(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public abstract void move();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

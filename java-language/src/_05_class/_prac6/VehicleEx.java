package _05_class._prac6;

import java.util.ArrayList;

public class VehicleEx {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[2];

        Car car = new Car("제네시스", 10);
        vehicles[0] = car;

        Airplane airplane = new Airplane("대한항공", 30);
        vehicles[1] = airplane;

        for (Vehicle v : vehicles) {
            v.move();

//            System.out.println(v instanceof Flyable);
            if (v instanceof Flyable) {
                ((Flyable) v).fly();
            }
        }

    }
}

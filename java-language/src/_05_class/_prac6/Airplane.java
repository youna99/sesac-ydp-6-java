package _05_class._prac6;

public class Airplane extends Vehicle implements Flyable{
    public Airplane(String name, int maxSpeed) {
        super(name, maxSpeed);
    }

    @Override
    public void move() {
        System.out.println(getName() + "이(가) 하늘을 날아가는 중");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " 이(가) 고도 " + getMaxSpeed() + "피트에서 비행 중");
    }
}

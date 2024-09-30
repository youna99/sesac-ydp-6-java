package _05_class._abstract;

public class Beak extends Student{
    public Beak(String name,String school, int age, String stdNum) {
        super(name, school, age, stdNum);
    }

    @Override
    void todo() {
        System.out.println("점심은 백종원 피자");
    }
}

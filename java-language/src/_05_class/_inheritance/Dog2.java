package _05_class._inheritance;

public class Dog2 extends Animal2 {
    public Dog2(String name, int age) {
        super("강아지", name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("멍멍하고 소리를 낸다.");
    }
}

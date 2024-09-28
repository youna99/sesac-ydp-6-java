package _05_class._inheritance;

public class Cat2 extends Animal2{
    public Cat2(String name, int age) {
        super("고양이", name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("야옹하고 소리를 낸다.");
    }
}

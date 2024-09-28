package _05_class._inheritance;

public class Animal2Ex {
    public static void main(String[] args) {
        Cat2 cat = new Cat2("삼식이", 3);
        Dog2 dog = new Dog2("초코", 2);

        System.out.println("이름 : " + cat.getName() + ", 나이: " + cat.getAge() + ", 종: " + cat.getSpecies());
        cat.makeSound();
        System.out.println("이름 : " + dog.getName() + ", 나이: " + dog.getAge() + ", 종: " + dog.getSpecies());
        dog.makeSound();
    }
}

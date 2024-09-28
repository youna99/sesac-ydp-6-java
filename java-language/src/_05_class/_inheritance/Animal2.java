package _05_class._inheritance;

public class Animal2 {
    private String species;
    private String name;
    private int age;

    // 생성자
    public Animal2(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
        System.out.println("동물은 소리를 낸다.");
    }
}

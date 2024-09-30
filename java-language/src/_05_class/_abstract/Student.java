package _05_class._abstract;

public abstract class Student {
    String name;
    String school;
    int age;
    String stdNum;

    public Student(String name, String school, int age, String stdNum) {
        this.name = name;
        this.school = school;
        this.age = age;
        this.stdNum = stdNum;
    }

    abstract void todo();
}

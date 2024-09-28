package _05_class;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentEx2 {
    public static void main(String[] args) {
        Student2 std1 = new Student2("김새싹", "20231001", 1);
        Student2 std2 = new Student2("박지은", "20231002", 2);
        Student2 std3 = new Student2("이은지", "20231003", 3);

        std1.displayInfo();
        std2.displayInfo();
        std3.displayInfo();

        System.out.println("총 학생 수는 " + Student2.getTotalStudents() + "명 입니다.");
    }
}

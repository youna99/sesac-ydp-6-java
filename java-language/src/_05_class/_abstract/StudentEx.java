package _05_class._abstract;

public class StudentEx {
    public static void main(String[] args) {
        Kim kim = new Kim("김철수", "ABC 고등학교", 17, "20220001");
        Beak beak = new Beak("백영희", "XYZ 고등학교", 18, "20220002");

        print(kim);
        print(beak);
    }

    public static void print (Student student) {
        System.out.println("=== " + student.name + " 학생의 정보 ===");
        System.out.println("학교: " + student.school);
        System.out.println("나이: " + student.age);
        System.out.println("학번: " + student.stdNum);
        student.todo();
        System.out.println();
    }
}

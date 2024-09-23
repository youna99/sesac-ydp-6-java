package _02_control_statement;

import java.util.Scanner;

// 조건문, 반복문 실습
public class Prac {
    public static void main(String[] args) {
        System.out.println("나이를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        if (age >= 1 && age <= 7) {
            System.out.println("유아");
        } else if (age >= 8 && age <= 13) {
            System.out.println("초등학생");
        } else if (age >= 14 && age <= 16) {
            System.out.println("중학생");
        } else if (age >= 17 && age <= 19) {
            System.out.println("고등학생");
        } else if (age >= 20) {
            System.out.println("성인");
        } else {
            System.out.println("잘못된 입력입니다.");
        }

        System.out.println("이름을 입력하세요.");
        String name = scanner.next();

        if (name.equals("홍길동")) {
            System.out.println("남자");
        } else if (name.equals("성춘향")) {
            System.out.println("여자");
        } else {
            System.out.println("모르겠어요.");
        }

        System.out.println("세 개의 정수를 입력하세요.");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        // 최대값
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        System.out.println("최대값: " + max);

        // 최소값
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        System.out.println("최소값: " + min);

        // 합계와 평균
        int sum = a + b + c;
        int avg = sum / 3;
        System.out.printf("합계: %d, 평균: %d", sum, avg);

        System.out.println();

        System.out.println("숫자를 입력하세요.");
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            System.out.print(i + " ");
        }
    }
}

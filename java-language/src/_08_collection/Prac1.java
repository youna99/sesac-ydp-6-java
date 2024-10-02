package _08_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Prac1 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요. -1을 입력하면 종료됩니다.");

        while (true) {
            System.out.print("정수 입력: ");
            int num = sc.nextInt();
            set.add(num);
            if (set.contains(-1)) break;
        }

        set.remove(-1);
        System.out.println("중복 제거된 정수 목록: " + set);
    }
}

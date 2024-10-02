package _08_collection;

import _05_class._abstract.Student;

import java.util.*;

public class Prac2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("이름과 나이를 입력하세요. '종료'를 입력하면 종료됩니다.");
        while (true) {
            System.out.print("이름 입력: ");
            String name = sc.next();
            if (name.equals("종료")) break;
            System.out.print("나이 입력: ");
            int age = sc.nextInt();
            map.put(name, age);
        }

        System.out.println("== 입력받은 이름과 나이 목록 ==");
//        System.out.println("map = " + map);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String n = entry.getKey();
            Integer a = entry.getValue();
            System.out.println("이름: " + n + ", 나이: " + a);
        }
        System.out.println();
    }
}

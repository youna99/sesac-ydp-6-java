package _03_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prac1 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("문자를 입력해주세요. :");
            String list = scanner.nextLine();

            lists.add(list);
            if (lists.contains("exit")) {
                break;
            }
        }
        lists.remove(lists.size() - 1);
        for (String l : lists) {
            System.out.print(l + " ");
        }
    }
}

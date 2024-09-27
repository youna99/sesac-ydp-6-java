package _05_class;

import java.util.ArrayList;
import java.util.Scanner;

public class RectangleEx {
    public static void main(String[] args) {

        ArrayList<Rectangle> rect = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("사각형의 가로와 세로 길이를 띄어쓰기를 기준으로 입력해주세요.");
            int width = sc.nextInt();
            int height = sc.nextInt();
            if (width == 0 && height == 0) break;
            Rectangle r1 = new Rectangle(width);
            rect.add(r1);
            r1.setHeigth(height);
            }


            for (Rectangle r: rect){
                System.out.println("가로 길이는: " + r.getWidth());
                System.out.println("세로 길이는: " + r.getHeigth());
                System.out.println("넓이는: " + r.getArea());
                System.out.println("---------------------");
        }
    }

}

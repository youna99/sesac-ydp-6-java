package _04_exception;

// 실습 1
public class Prac {
    public static void main(String[] args) {
        int[] numArr = {1,2,3,4};
        try {
            for (int i = 0; i <= 5; i++) {
                System.out.println(numArr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("인덱스가 범위를 벗어났습니다. " + e.getMessage());
        }
    }
}

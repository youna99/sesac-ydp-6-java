package _07_generic;

public class PairEx {
    public static void main(String[] args) {
        Pair pair1 = new Pair<>("One", 1);
        Pair pair2 = new Pair<>(2, "Two");

        System.out.println("Key: " + pair1.getKey() + ", Value: " + pair1.getValue());
        System.out.println("Key: " + pair2.getKey() + ", Value: " + pair2.getValue());
    }
}

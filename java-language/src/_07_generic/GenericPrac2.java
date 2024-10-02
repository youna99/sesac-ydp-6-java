package _07_generic;

class Calculator<T extends Number> {
    private T num1;
    private T num2;
    public void Calculator(T num1, T num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public double add(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}

public class GenericPrac2 {
    public static void main(String[] args) {
        Calculator<Integer> integerCalculator = new Calculator<>();
        System.out.println("Integer Sum: " + integerCalculator.add(10, 20));

        Calculator<Double> doubleCalculator = new Calculator<>();
        System.out.println("Double Sum: " + doubleCalculator.add(5.25, 2.3));
    }
}

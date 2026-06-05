package au.training.calculator;

public class App {
    public static void main(String[] args) {
        System.out.println("AI Calculator v0.1");
        System.out.println("2 + 3 = " + add(2, 3));
        System.out.println("10 - 4 = " + subtract(10, 4));
        System.out.println("5 x 6 = " + multiply(5, 6));
        System.out.println("20 / 4 = " + divide(20, 4));
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
}

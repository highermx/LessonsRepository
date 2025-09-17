package project.function;

public class Calculator {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static long multiply(int a, int b) {
        return (long) a * b;
    }

    public static double divide(int a, int b) {
        return (double) a / b;
    }


    public static String sumLine(int a, int b) {
        return a + "+" + b + " = " + sum(a, b);
    }

    public static String subtractLine(int a, int b) {
        return a + "-" + b + " = " + subtract(a, b);
    }
    public static String multiplyLine(int a, int b) {
        return a + "*" + b + " = " + multiply(a, b);
    }
}

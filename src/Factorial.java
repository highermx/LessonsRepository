public class Factorial {
    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Максимальное допустимое значение: 20");
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

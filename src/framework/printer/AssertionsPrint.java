package framework.printer;

import java.util.Arrays;

public class AssertionsPrint {
    public static <T> void contains(T[] current, T[] toContain) throws AssertResult {
        if (current == null || toContain == null) {
            throw new AssertResult("Обнаружен нулевой массив", Arrays.toString(current), Arrays.toString(toContain));
        }

        if (toContain.length == 0) {
            return; // Пустой подмассив всегда считается найденным
        }

        if (current.length < toContain.length) {
            throw new AssertResult("Несоответствие длины массива",
                    Arrays.toString(current),
                    Arrays.toString(toContain));
        }

        mainLoop:
        for (int i = 0; i <= current.length - toContain.length; i++) {
            for (int j = 0; j < toContain.length; j++) {
                if (!objectsEqual(current[i + j], toContain[j])) {
                    continue mainLoop;
                }
            }
            return; // Подмассив найден
        }

        throw new AssertResult("Вложенный массив не найден",
                Arrays.toString(current),
                Arrays.toString(toContain));
    }

    private static boolean objectsEqual(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals(b);
    }
}

class AssertResult extends Exception {
    private final String expected;
    private final String actual;

    public AssertResult(String message, String actual, String expected) {
        super(message);
        this.actual = actual;
        this.expected = expected;
    }

    public String getFormattedError() {
        return String.format(
                "Не удалось выполнить: %s\nФактический массив: %s\nОжидаемый подмассив: %s",
                getMessage(), actual, expected
        );
    }
}

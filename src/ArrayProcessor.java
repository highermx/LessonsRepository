import java.util.Arrays;

public class ArrayProcessor {

    public static int[] getAfterLast4(int[] array) {
        int last4Index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) last4Index = i;
        }

        if (last4Index == -1) {
            throw new RuntimeException("Массив не содержит четверок");
        }

        return Arrays.copyOfRange(array, last4Index + 1, array.length);
    }

    public static boolean hasOnly1And4(int[] array) {
        boolean has1 = false;
        boolean has4 = false;

        for (int num : array) {
            if (num != 1 && num != 4) return false;
            if (num == 1) has1 = true;
            if (num == 4) has4 = true;
        }

        return has1 && has4;
    }
}

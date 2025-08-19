public class ArraySwapper {
    public static <T> void swapPairs(T[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length - 1; i += 2) {
            T gen = array[i];
            array[i] = array[i + 1];
            array[i + 1] = gen;
        }
    }
}

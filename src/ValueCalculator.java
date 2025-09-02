import java.util.Arrays;

public class ValueCalculator {
    public final float[] values;
    public final int size;

    public ValueCalculator(int size) {
        if (size < 1_000_000) {
            throw new IllegalArgumentException("Минимальный размер массива - 1 000 000");
        }

        this.size = size;
        this.values = new float[size];
    }

    public void doCalc() throws InterruptedException {
        long start = System.currentTimeMillis();

        Arrays.fill(values, 1.0f);

        int half = size / 2;
        float[] arr1 = new float[half];
        float[] arr2 = new float[size - half];

        System.arraycopy(values, 0, arr1, 0, half);
        System.arraycopy(values, half, arr2, 0, size - half);

        Thread thread1 = new Thread(() -> processArray(arr1, 0));
        Thread thread2 = new Thread(() -> processArray(arr2, half));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.arraycopy(arr1, 0, values, 0, half);
        System.arraycopy(arr2, 0, values, half, size - half);

        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
    }

    private void processArray(float[] arr, int offset) {
        for (int i = 0; i < arr.length; i++) {
            int index = i + offset;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + index / 5.0)
                    * Math.cos(0.2f + index / 5.0)
                    * Math.cos(0.4f + index / 2.0));
        }
    }
}

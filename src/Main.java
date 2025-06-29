import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] source = {-2, 5, 0, 9, 3, 6};
        int[] target = {8, -4, 7, 1};

        int[] result = new int[source.length + target.length];

        System.arraycopy(source, 0, result, 0, source.length);
        System.arraycopy(target, 0, result, source.length, target.length);

        System.out.println(Arrays.toString(result));

        int left = 0;

        int right = result.length - 1;
        boolean flag;

        do {
            flag = false;

            for (int i = left; i < right; i++) {
                if (result[i] > result[i + 1]) {
                    int temp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;

            flag = false;
            right--;

            for (int i = right; i > left; i--) {
                if (result[i] < result[i - 1]) {
                    int temp = result[i];
                    result[i] = result[i - 1];
                    result[i - 1] = temp;
                    flag = true;
                }
            }
            left++;

        } while (flag && left <= right);

        System.out.println(Arrays.toString(result));
        

    }
}

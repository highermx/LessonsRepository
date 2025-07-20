package lesson12;

public class ArrayValueCalculator {
    public static int doCalculator(String[][] array) throws ArraySizeException, ArrayDataException {
        validateSize(array);

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum+= Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Некорректные данные: ", i+1, j+1);
                }

            }
        }
        return sum;
    }

    public static void validateSize(String[][]array) throws ArraySizeException {
        if(array.length != 4 || !lineSizeCorrect(array)) {
            throw new ArraySizeException("Error; size of array must be 4x4");
        }

    }

    public static boolean lineSizeCorrect(String[][] array) {
        for(var line: array) {
            if (line.length != 4)
                return false;
        }

        return true;
    }

}



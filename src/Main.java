import lesson12.ArrayDataException;
import lesson12.ArraySizeException;
import lesson12.ArrayValueCalculator;

public class Main {
    public static void main(String[] args) {

        String[][] testData = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        try {
            int result = ArrayValueCalculator.doCalculator(testData);
            System.out.println("Sum: " + result);
        } catch (ArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println(e.getMessage() + " ; error in line " + e.getRow() + " position: " + e.getColumn());
        }


    }
}

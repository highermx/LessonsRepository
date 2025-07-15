import Lesson11.Circle;
import Lesson11.Figure;
import Lesson11.Square;
import Lesson11.Triangle;

import java.util.Arrays;

public class Main {
    public static double sumArea(Figure[] figures) {
         double sum = 0;
         for(Figure sums: figures) {
             sum += sums.findTheArea();
         }
         return sum;

    }

    public static void main(String[] args) {
        Circle circle = new Circle(7);
        Triangle triangle = new Triangle(5, 8);
        Square square = new Square(12);

        circle.findTheArea();
        triangle.findTheArea();
        square.findTheArea();

        System.out.println("------------------");
        System.out.println("Массив других по размеру фигур: ");


        Figure[] allFigures = {
                new Circle(6),
                new Triangle(7, 12),
                new Square(8)

        };

        double arrayAreaSum = sumArea(allFigures);


        System.out.println(Arrays.toString(allFigures));
        System.out.println("Сумма площадей всех фигур в массиве: " + arrayAreaSum);


    }
}

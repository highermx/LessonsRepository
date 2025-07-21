
import lesson12.ArrayDataException;
import lesson12.ArraySizeException;
import lesson12.ArrayValueCalculator;
=======

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


import lesson10.Animal;
import lesson10.AnimalCanSwim;
import lesson10.Cat;
import lesson10.Dog;

import static lesson10.Animal.totalAnimalsCounter;



public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("John", "Java developer", "johnjava@gmail.com", 795195475, 31);
        System.out.println(employee1);

        Car car = new Car();
        car.start();

        
        



        AnimalCanSwim dog = new Dog("Rex");
        System.out.println("Cобаку зовут: " + dog.getName());
        dog.run(426);
        dog.swim(6);

        AnimalCanSwim dog1 = new Dog("Tom");
        System.out.println("Cобаку зовут: " + dog1.getName());
        dog1.run(363);
        dog1.swim(10);

        Animal cat = new Cat("Richard");
        System.out.println("Кота зовут: " + cat.getName());
        cat.run(125);

        Animal cat1 = new Cat("Lusya");
        System.out.println("Кота зовут: " + cat1.getName());
        cat1.run(215);

        dog.animalCounter();
        cat.animalCounter();
        System.out.println("Всего животных: " + Animal.totalAnimalsCounter());







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

}

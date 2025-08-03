lesson14(2)
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AttandanceLogger getUsers = new AttandanceLogger();

        String[][] testVisits = {
                {"user_101", "09:15"},
                {"user_202", "10:00"},
                {"user_101", "09:45"},
                {"user_303", "11:30"},
                {"user_202", "10:20"},
                {"user_404", "14:10"},
                {"user_101", "09:55"},
                {"user_202", "10:45"},
                {"user_404", "14:25"},
                {"user_303", "11:50"},
                {"user_505", "15:00"},
                {"user_101", "16:30"},
                {"user_303", "11:59"}
        };

       
        System.out.println("Добавление посещений:");
        for (String[] visit : testVisits) {
            System.out.printf("- %s в %s%n", visit[0], visit[1]);
            getUsers.addVisit(visit[0], visit[1]);
        }

        
        System.out.println("\nСтатистика посещений:");
        getUsers.getVisitFrequency().forEach((user, count) ->
                System.out.printf("Пользователь %s: %d посещений%n", user, count));

        
        System.out.println("\nАнализ популярности:");
        System.out.println("Самое активное время: " + getUsers.getMostPopularHour());


import phonebook.PhoneDirectory;
import phonebook.Record;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1
        List<String> newtext = new ArrayList<>(Arrays.asList("Cat", "Dog", "Dolph", "Turtle", "Dog", "Parrot", "Cat", "Turtle", "Cat", "Turtle"));
        countOccurance(newtext, "Turtle");

        //2
        int[] randomInts = {1, 3, 6, 3, 7, 9, 12, 64};
        System.out.println(toList(randomInts));

        //3
        List<Integer> numbs = new ArrayList<>(Arrays.asList(12, 65, 12, 53, 74, 12));
        List<Integer> uniqueNumbs = findUnique(numbs);
        System.out.println("Исходный список: " + numbs);
        System.out.println("Уникальный список: " + uniqueNumbs);

        //4
        List<String> fruits = new ArrayList<>(Arrays.asList("BMW", "Toyota", "Honda", "Toyota", "BMW", "Honda", "Honda"));
        calcOccurance(fruits);

        //Задача с телефонной книгой

        PhoneDirectory directory = new PhoneDirectory();
        directory.add(new Record("Сергеев", 43-76-54));
        directory.add(new Record("Михайлов", 75-21-92));
        directory.add(new Record("Сергеев", 20-74-19));
        directory.add(new Record("Сарычев", 52-92-31));

        System.out.println("Первая запись Сергеева: " + directory.find("Сергеев"));
        System.out.println("Все записи Сергеева: " + directory.findAll("Сергеев"));



    }
    
    //Задача 1

    public static void countOccurance(List<String> text, String line) {
        Iterator<String> iter = text.iterator();
        int counter = 0;
        while (iter.hasNext()) {
            String str = iter.next();
            if (str.equals(line)) {
                counter++;
            }
        }
        System.out.println("Данная строка встречается в списке: " + counter + " раз.");

    }

    //Задача 2

    public static List<Integer> toList(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(num);
        }
        return list;

    }

    //Задача 3

    public static List<Integer> findUnique(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        Iterator<Integer> iter = numbers.iterator();

        while (iter.hasNext()) {
            Integer integ = iter.next();
            int count = 0;

            Iterator<Integer> iter2 = numbers.iterator();
            while (iter2.hasNext() && count < 2) {
                if (integ.equals(iter2.next())) {
                    count++;
                }
            }

            if (count == 1) {
                result.add(integ);
            }
        }
        return result;
    }

    //Задача 4

    public static void calcOccurance(List<String> words) {
        HashMap<String, Integer> countMap = new HashMap<>();
        Iterator<String> iter = words.iterator();

        while (iter.hasNext()) {
            String word = iter.next();
            countMap.put(word, countMap.getOrDefault(word,0) + 1);
        }

        ArrayList<String> result = new ArrayList<>();
        for(String key : countMap.keySet()) {
            result.add(key + ": " + countMap.get(key));
        }

        System.out.println(String.join(", ", result));


import lesson13.CustomArrayList;
import lesson13.CustomArrayQueue;

import java.util.Arrays;



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







        //Задание №1
        CustomArrayList list = new CustomArrayList();
        list.add(5);
        list.add(10);
        list.add(15);

        System.out.println("Содержимое списка:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Элемент " + i + ": " + list.get(i));
        }

        System.out.println("Общий размер: " + list.size());

        //Задание №2
        CustomArrayQueue qlist = new CustomArrayQueue();
        int[] arr = qlist.init(3);
        qlist.add(arr,6);
        qlist.add(arr,7);
        qlist.add(arr,8);

        System.out.println("Состояние: " + Arrays.toString(arr));
        System.out.println("Извлечено: " + qlist.poll(arr));
        System.out.println("Новое состояние: " + Arrays.toString(arr));




    }

     }

}


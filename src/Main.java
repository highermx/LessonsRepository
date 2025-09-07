
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FileStorage storage = new FileStorage(Paths.get("/data/storage"));
        storage.put("documents", "report.pdf", Paths.get("local_report.pdf"));

        FileStorageReader reader = new FileStorageReader(storage);
        byte[] fullContent = reader.read("documents", "report.pdf");
        List<byte[]> chunks = reader.read("documents", "report.pdf", 4096);


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

lesson-17
import java.util.Arrays;
import java.util.List;

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


        //Задание 1

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Массив до изменений: " + Arrays.toString(numbers));
        ArraySwapper.swapPairs((numbers));
        System.out.println("Массив после изменений: " + Arrays.toString(numbers));

        String[] cities = {"Moscow", "Samara", "Omsk", "Kemerovo"};
        List<String> citiesList = ListCopy.CopyToList(cities);
        System.out.println("Города страны: " + citiesList);

        //Задание 2

        Box<Apple> appleBox = new Box<>(Apple.class);
        appleBox.add(new Apple(1.0f));
        appleBox.add(new Apple(1.0f));
        appleBox.add(new Apple(1.0f));

        Box<Orange> orangeBox = new Box<>(Orange.class);
        orangeBox.add(new Orange(1.5f));
        orangeBox.add(new Orange(1.5f));
        orangeBox.add(new Orange(1.5f));

        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Сравнение веса коробок: " + appleBox.compare(orangeBox));






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
    public static void main(String[] args) throws InterruptedException {
        ValueCalculator calculator = new ValueCalculator(1000000);
        calculator.doCalc();

        FileLoggerConfiguration config = new FileLoggerConfiguration(
                "C:\\Users\\Максим\\Desktop",
                "Test.txt",
                LoggingLevel.DEBUG,
                1024,
                "[%s][%s] %s");

        Logger logger = new FileLogger(config);

        logger.debug("Запуск приложения");
        logger.info("Пользователь вошёл в систему");
        logger.debug("Отправка запроса к БД");

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




        // Задание 1

        Random random = new Random();
        List<Integer> numbers = IntStream.generate(() -> random.nextInt(1000) + 1 )
                .limit(100)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> topTen = numbers.stream()
                .sorted()
                .limit(10)
                .collect(Collectors.toList());

        LinkedHashSet<Integer> uniqueNumbers = new LinkedHashSet<>(topTen);
        List<Integer> uniqueList = new ArrayList<>(uniqueNumbers);

        List<Integer> finalResult = uniqueList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Исходные числа: " + numbers);
        System.out.println("Топ-10 минимальных: " + topTen);
        System.out.println("Уникальные значения: " + uniqueList);
        System.out.println("Финальный результат (по убыванию): " + finalResult);

        // Задание 2

        List<Integer> numbers1 = List.of(5, 12, 3, 8, 15, 3, 12);
        Collection<Integer> filtered = Filter.filter(numbers, n -> n > 5);

        System.out.println("Начальная коллекция: " + numbers.getClass().getSimpleName());
        System.out.println("Изменённая коллекция: " + filtered.getClass().getSimpleName());
        System.out.println("Результат: " + filtered);

        // Задание 3

        List<String> words = Arrays.asList("hello", "", "world", "!", null);

        String result = FilterCollection.filterAndJoin(words, s -> s != null && !s.isEmpty());
        System.out.println("Результат: " + result);

        // Задание 4

        Collection<Integer> numbers2 = Arrays.asList(3, 1, 2, 2, 4, null, 5, 3);

        System.out.println("ASC: " + CollectionSorter.sortUnique(numbers, CollectionSorter.Direction.ASC));
        System.out.println("DESC: " + CollectionSorter.sortUnique(numbers, CollectionSorter.Direction.DESC));

        // Задание 5

        System.out.println("5! = " + Factorial.calculate(5));    // 120
        System.out.println("0! = " + Factorial.calculate(0));     // 1
        System.out.println("10! = " + Factorial.calculate(10));

        // Задание 6

        List<Boyscout> scouts = Arrays.asList(
                new Boyscout("Олег", 14, ScoutProgram.Team.RED),
                new Boyscout("Константин", 12, ScoutProgram.Team.BLUE),
                new Boyscout("Сергей", 15, ScoutProgram.Team.RED),
                new Boyscout("Эдуард", 13, ScoutProgram.Team.GREEN),
                new Boyscout("Виктор", 11, ScoutProgram.Team.BLUE)
        );

        Camp camp = new Camp(scouts);
        Map<ScoutProgram.Team, List<Boyscout>> result1 = camp.split();

        result1.forEach((team, list) -> {
            System.out.println(team + ": " + list);
        });
    }

     }

}


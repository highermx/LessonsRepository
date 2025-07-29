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


    }
}


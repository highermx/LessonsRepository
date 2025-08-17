import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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





    }
}

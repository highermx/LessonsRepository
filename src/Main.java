import lesson13.CustomArrayList;
import lesson13.CustomArrayQueue;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

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

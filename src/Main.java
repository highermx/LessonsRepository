import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

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

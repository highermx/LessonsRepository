import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AttandanceLogger getUsers = new AttandanceLogger();

        String[][] testVisits = {
                {"user_101", "09:15"},  // Первое посещение user_101
                {"user_202", "10:00"},  // Первое посещение user_202
                {"user_101", "09:45"},   // Второе посещение user_101
                {"user_303", "11:30"},  // Посещение нового пользователя
                {"user_202", "10:20"},   // Второе посещение user_202
                {"user_404", "14:10"},   // Новый пользователь в другое время
                {"user_101", "09:55"},   // Третье посещение user_101
                {"user_202", "10:45"},   // Третье посещение user_202
                {"user_404", "14:25"},   // Второе посещение user_404
                {"user_303", "11:50"},   // Второе посещение user_303
                {"user_505", "15:00"},   // Новый пользователь
                {"user_101", "16:30"},   // Посещение в другое время
                {"user_303", "11:59"}    // Третье посещение user_303
        };

        // 3. Добавление данных через цикл
        System.out.println("Добавление посещений:");
        for (String[] visit : testVisits) {
            System.out.printf("- %s в %s%n", visit[0], visit[1]);
            getUsers.addVisit(visit[0], visit[1]);
        }

        // 4. Вывод статистики
        System.out.println("\nСтатистика посещений:");
        getUsers.getVisitFrequency().forEach((user, count) ->
                System.out.printf("Пользователь %s: %d посещений%n", user, count));

        // 5. Анализ популярного времени
        System.out.println("\nАнализ популярности:");
        System.out.println("Самое активное время: " + getUsers.getMostPopularHour());

    }
}

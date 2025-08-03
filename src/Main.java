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

    }
}

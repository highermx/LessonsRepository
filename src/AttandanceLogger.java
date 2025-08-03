import java.util.*;

public class AttandanceLogger {
    private final Map<String, Integer> userVisits = new HashMap<>();
    private final Map<String, List<String>> hourVisits = new HashMap<>();

    public void addVisit(String userId, String timestamp) {

        updateUserVisits(userId);
        updateHourVisits(timestamp);
    }


    private void updateUserVisits(String userId) {
        Iterator<Map.Entry<String, Integer>> it = userVisits.entrySet().iterator();
        boolean found = false;

        while(it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getKey().equals(userId)) {
                entry.setValue(entry.getValue() + 1);
                found = true;
                break;
            }
        }

        if(!found) {
            userVisits.put(userId, 1);
        }
    }

    private void updateHourVisits(String timestamp) {
        String hour = timestamp.substring(0, 2) + ":00";
        List<String> visits = hourVisits.getOrDefault(hour, new ArrayList<>());
        visits.add(timestamp);
        hourVisits.put(hour, visits);
    }

    public Map<String, Integer> getVisitFrequency() {
        Map<String, Integer> result = new HashMap<>();
        Iterator<Map.Entry<String, Integer>> it = userVisits.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public String getMostPopularHour() {
        if(hourVisits.isEmpty()) return "Нет данных";

        String popularHour = "";
        int maxCount = 0;

        Iterator<Map.Entry<String, List<String>>> it = hourVisits.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, List<String>> entry = it.next();
            int currentCount = entry.getValue().size();

            if(currentCount > maxCount ||
                    (currentCount == maxCount && entry.getKey().compareTo(popularHour) < 0)) {
                maxCount = currentCount;
                popularHour = entry.getKey();
            }
        }

        return formatHourReport(popularHour, maxCount);
    }

    private String formatHourReport(String hour, int count) {
        List<String> times = hourVisits.getOrDefault(hour, Collections.emptyList());
        return String.format("%s (%d посещения: %s)",
                hour, count, String.join(", ", times));
    }
}

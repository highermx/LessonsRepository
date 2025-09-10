import java.util.stream.Collectors;
import java.util.function.Predicate;
import java.util.Collection;

public class FilterCollection {

    public static String filterAndJoin(Collection<String> strings, Predicate<String> predicate) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }

        return strings.stream()
                .filter(predicate)
                .collect(Collectors.joining("|"));
    }
}

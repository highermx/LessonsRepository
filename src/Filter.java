import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {
    public static <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate) {
        return collection.stream()
                .filter(predicate)
                .collect(Collectors.toCollection(() -> createNewCollection(collection)));
    }

    @SuppressWarnings("unchecked")
    private static <T> Collection<T> createNewCollection(Collection<T> source) {
        try {
            return source.getClass()
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {

            return new ArrayList<>();
        }
    }
}

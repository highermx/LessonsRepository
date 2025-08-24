import java.util.*;
import java.util.stream.Collectors;

public class CollectionSorter {
    public enum Direction { ASC, DESC }

    public static <T extends Comparable<? super T>> List<T> sortUnique(Collection<T> numbers, Direction direction) {
        if (numbers == null || numbers.isEmpty()) {
            return Collections.emptyList();
        }

        Comparator<T> comparator = direction == Direction.ASC
                ? Comparator.naturalOrder()
                : Comparator.reverseOrder();

        return numbers.stream()
                .filter(Objects::nonNull)
                .distinct()
                .sorted(comparator)
                .collect(Collectors.toList());

    }
}

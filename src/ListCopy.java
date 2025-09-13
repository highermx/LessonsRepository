import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCopy {
    public static <T> List<T> CopyToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));

    }
}

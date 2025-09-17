package framework.assertions;

import java.util.Objects;

public class Assertions {

    public static <T> void equals(T expected, T actual) throws AssertException{
        boolean success = Objects.equals(expected, actual);
        throw new AssertException(new AssertEqualsResult<>(actual, expected, success));
    }

    public static void contains(String input, String expected) throws AssertException {
        boolean success = input != null && expected != null && input.contains(expected);
        throw new AssertException(new AssertContainsResult(success, input, expected));
    }
}

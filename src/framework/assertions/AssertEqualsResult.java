package framework.assertions;

public class AssertEqualsResult <T> extends TestResult {
    private final T actual;
    private final T expected;

    public AssertEqualsResult(T actual, T expected, boolean success) {
        super(success);
        this.actual = actual;
        this.expected = expected;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-20s", "actual=" + actual, "expected=" + expected);
    }
}

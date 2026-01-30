package framework.executions;

import framework.assertions.TestResult;

import java.lang.reflect.Method;
import java.time.Duration;

public class ExecutionItem {
    private Method method;
    private TestResult assertResult;
    private String status;

    public ExecutionItem(Method method, TestResult assertResult) {
        this.method = method;
        this.assertResult = assertResult;
    }

    public ExecutionItem(String name, String passed, Duration zero) {
    }

    public Method getMethod() {
        return method;
    }

    public TestResult getAssertResult() {
        return assertResult;
    }

    @Override
    public String toString() {
        return "ExecutionItem{" +
                "method=" + method +
                ", assertResult=" + assertResult +
                '}';
    }

    public String getStatus() {
        return status;
    }
}

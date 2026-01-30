package framework.runner;

import framework.assertions.AssertException;
import framework.executions.Execution;
import framework.executions.ExecutionItem;
import framework.marker.Test;
import framework.printer.Printer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestAutomationRunner implements Runner{
    private final Printer printer;

    public TestAutomationRunner(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run(List<Class<?>> testClasses) {
        List<Execution> executions = testClasses.stream()
                .map(this::runTestClass)
                .toList();

        printer.write(executions);
    }

    private Execution runTestClass(Class<?> testClass) {
        Object testClassInstance = getTestClassInstance(testClass);
        LocalDateTime startTime = LocalDateTime.now();
        List<ExecutionItem> executionItems = Arrays.stream(testClass.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Test.class))
                .map(method -> runTestMethod(method, testClassInstance))
                .toList();

        return new Execution(testClass, executionItems, startTime, LocalDateTime.now());
    }

    private Object getTestClassInstance(Class<?> testClass) {
        try {
            return testClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            String error = "Test class must contain public constructor without params: " + testClass.getName();
            throw new RuntimeException(error);
        }
    }

    private ExecutionItem runTestMethod(Method method, Object testClassInstance) {
        try {
            method.invoke(testClassInstance);
        } catch (InvocationTargetException e) {
            if(e.getCause() instanceof AssertException assertException) {
                return new ExecutionItem(method, assertException.getAssertResult());
            }

            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("Error: test method " + method+" didn't throw AssertException");
    }
}

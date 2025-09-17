package framework.printer;

import framework.executions.Execution;
import framework.executions.ExecutionItem;
import framework.marker.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.*;

public class TestExecutor {
    private final Map<Class<?>, List<Method>> testMethodsCache = new HashMap<>();

    public List<Execution> executeTests(List<Class<?>> testClasses) {
        return testClasses.stream()
                .map(this::processClass)
                .filter(Objects::nonNull)
                .toList();
    }

    private Execution processClass(Class<?> testClass) {
        try {
            Object instance = testClass.getDeclaredConstructor().newInstance();
            List<ExecutionItem> items = new ArrayList<>();

            LocalDateTime start = LocalDateTime.now();
            invokeMethods(instance, testClass.getDeclaredMethods(), items);
            LocalDateTime end = LocalDateTime.now();

            return new Execution(testClass, items, start, end);
        } catch (Exception e) {
            System.err.println("Ошибка выполнения тестов: " + e.getMessage());
            return null;
        }
    }

    private void invokeMethods(Object instance, Method[] methods, List<ExecutionItem> items) {
        Arrays.stream(methods)
                .filter(m -> m.isAnnotationPresent(Test.class))
                .forEach(m -> {
                    try {
                        m.invoke(instance);
                        items.add(new ExecutionItem(m.getName(), "PASSED", Duration.ZERO));
                    } catch (InvocationTargetException e) {
                        Temporal startTime = null;
                        items.add(new ExecutionItem(
                                m.getName(),
                                "FAILED",
                                Duration.between(startTime, LocalDateTime.now())
                        ));
                    } catch (IllegalAccessException e) {
                        System.err.println("Ошибка доступа: " + e.getMessage());
                    }
                });
    }
}

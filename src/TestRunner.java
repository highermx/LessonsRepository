import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void start(Class<?> testClass) throws Exception {
        Object instance = testClass.getDeclaredConstructor().newInstance();

        // Обработка BeforeSuite
        Method beforeSuite = findSingleAnnotation(testClass, BeforeSuite.class);
        if (beforeSuite != null) {
            invokeMethod(instance, beforeSuite);
        }

        // Обработка тестов
        List<Method> testMethods = getAnnotatedMethods(testClass, Test.class);
        testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).order()));

        for (Method testMethod : testMethods) {
            invokeMethod(instance, testMethod);
        }

        // Обработка AfterSuite
        Method afterSuite = findSingleAnnotation(testClass, AfterSuite.class);
        if (afterSuite != null) {
            invokeMethod(instance, afterSuite);
        }
    }

    private static Method findSingleAnnotation(Class<?> clazz, Class annotation) throws Exception {
        List<Method> methods = getAnnotatedMethods(clazz, annotation);
        if (methods.size() > 1) {
            throw new IllegalStateException("Найдено более одного метода с аннотацией @" + annotation.getSimpleName());
        }
        return methods.isEmpty() ? null : methods.get(0);
    }

    private static List<Method> getAnnotatedMethods(Class<?> clazz, Class annotation) {
        List<Method> result = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotation)) {
                result.add(method);
            }
        }
        return result;
    }

    private static void invokeMethod(Object instance, Method method) throws Exception {
        method.setAccessible(true);
        method.invoke(instance);
    }
}

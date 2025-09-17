package framework.printer;

import framework.executions.Execution;
import framework.executions.ExecutionItem;
import framework.runner.Runner;

import javax.print.PrintException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ExtendedTestAutomationRunner implements Runner {
    private final Set<Printer> printers = new CopyOnWriteArraySet<>();
    private final TestExecutor executor = new TestExecutor();

    // Добавление принтера с контролем уникальности типа
    public void addPrinter(Printer printer) {
        if (printer == null) throw new IllegalArgumentException("Принтер не может быть null");

        boolean typeExists = printers.stream()
                .anyMatch(p -> p.getClass().equals(printer.getClass()));

        if (typeExists) {
            throw new IllegalStateException("Принтер типа " +
                    printer.getClass().getSimpleName() + " уже зарегистрирован");
        }
        printers.add(printer);
    }

    @Override
    public void run(List<Class<?>> testClasses) {
        List<Execution> results = executor.executeTests(testClasses);
        distributeResults(results);
    }

    private void distributeResults(List<Execution> results) {
        printers.parallelStream().forEach(printer -> {
            printer.write(results);
        });
    }

    private void handlePrintError(Printer printer, Exception e) {
        System.err.printf("Ошибка в %s: %s%n",
                printer.getClass().getSimpleName(),
                e.getMessage());
    }
}

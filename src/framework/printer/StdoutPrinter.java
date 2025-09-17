package framework.printer;

import framework.executions.Execution;
import framework.utils.ConsoleColors;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class StdoutPrinter implements Printer{

    private final String template;

    public StdoutPrinter(String template) {
        this.template = template;
    }

    @Override
    public void write(List<Execution> executions) {
        for (var execution: executions) {
            System.out.println("Class: " + execution.getTestClass().getName());

            DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern(template);
            System.out.println("Start time: " + simpleDateFormat.format(execution.getStartTime()));
            System.out.println("End time: " + simpleDateFormat.format(execution.getEndTime()));
            System.out.println("\n---------------------------------------Tests------------------------------------");
            execution.getExecutionItems().forEach(item -> {
                String colorCode = item.getAssertResult().isSuccess() ? ConsoleColors.GREEN : ConsoleColors.RED;
                System.out.print(colorCode);
                System.out.printf("%20s | %s%n", item.getMethod().getName(), item.getAssertResult().toString());
            });

            System.out.print(ConsoleColors.RESET);
            System.out.println("-".repeat(80));

            System.out.println("\n\n");
        }
    }
}

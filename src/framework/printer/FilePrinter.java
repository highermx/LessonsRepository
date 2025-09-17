package framework.printer;

import framework.executions.Execution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;

public class FilePrinter {
    private final List<Execution> executions;
    private final String template;
    private final Path target;

    public FilePrinter(List<Execution> executions, String template, Path target) {
        this.executions = Objects.requireNonNull(executions, "Executions list cannot be null");
        this.template = Objects.requireNonNull(template, "Template cannot be null");
        this.target = Objects.requireNonNull(target, "Target path cannot be null");
    }

    public void write() {
        try {
            Files.writeString(
                    target,
                    formatContent(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String formatContent() {
        StringBuilder content = new StringBuilder();
        executions.forEach(execution ->
                content.append(formatExecution(execution)).append("\n")
        );
        return content.toString();
    }

    private String formatExecution(Execution execution) {
        return template
                .replace("%className%", execution.getTestClass().getSimpleName())
                .replace("%start%", execution.getStartTime().toString())
                .replace("%end%", execution.getEndTime().toString())
                .replace("%passed%", String.valueOf(
                        execution.getExecutionItems().stream()
                                .filter(i -> "PASSED".equals(i.getStatus()))
                                .count()
                ))
                .replace("%total%", String.valueOf(execution.getExecutionItems().size()));
    }
}


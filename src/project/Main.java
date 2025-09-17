
import framework.printer.StdoutPrinter;
import framework.runner.Runner;
import framework.runner.TestAutomationRunner;
import project.tests.CalculatorLineTest;
import project.tests.CalculatorTest;

import java.util.List;

public class Main {
    public static void main(String[] args) {
            var printer = new StdoutPrinter("yyyy-MM-dd HH:mm:ss");
            Runner runner = new TestAutomationRunner(printer);
            runner.run(List.of(CalculatorTest.class, CalculatorLineTest.class));

    }
}

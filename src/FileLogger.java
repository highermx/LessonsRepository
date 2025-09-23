import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {
    private FileLoggerConfiguration config;
    private int currentFileIndex = 1;
    private long currentSize = 0;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
        initializeLogFile();
    }

    private void initializeLogFile() {
        File logFile = new File(config.getFullPath());
        currentSize = logFile.exists() ? logFile.length() : 0;
    }

    @Override
    public void debug(String message) {
        log(LoggingLevel.DEBUG, message);
    }

    @Override
    public void info(String message) {
        log(LoggingLevel.INFO, message);
    }

    private void log(LoggingLevel level, String message) {
        if (!config.level().isEnabled(level)) return;

        String formattedMessage = formatMessage(level, message);
        checkFileSize(formattedMessage.length());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                config.getFullPath(), true))) {
            writer.write(formattedMessage);
            writer.newLine();
            currentSize += formattedMessage.getBytes().length + 1;
        } catch (IOException e) {
            System.err.println("Ошибка записи в лог: " + e.getMessage());
        }
    }

    private String formatMessage(LoggingLevel level, String message) {
        return String.format(config.pattern(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                level.name(),
                message);
    }

    private void checkFileSize(int messageSize) {
        if (currentSize + messageSize > config.getMaxSize()) {
            rotateLogFile();
        }
    }

    private void rotateLogFile() {
        File oldFile = new File(config.getFullPath());
        String newFilename = config.getFilename().replace(".log",
                "_" + currentFileIndex++ + ".log");
        File newFile = new File(config.getPath(), newFilename);
        oldFile.renameTo(newFile);
        currentSize = 0;
    }


}


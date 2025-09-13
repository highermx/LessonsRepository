import java.io.File;

public class FileLoggerConfiguration implements LoggerConfiguration {
    private final String path;
    private final String filename;
    private final LoggingLevel level;
    private final long maxSize;
    private final String pattern;

    public FileLoggerConfiguration(String path, String filename,
                                   LoggingLevel level, long maxSize, String pattern) {
        this.path = path;
        this.filename = filename;
        this.level = level;
        this.maxSize = maxSize;
        this.pattern = pattern;
    }
    @Override
    public LoggingLevel level() {
        return level;
    }

    @Override
    public String pattern() {
        return pattern;
    }

    public String getFullPath() {
        return path + File.separator + filename;
    }
    public long getMaxSize() {
        return maxSize;
    }

    public String getFilename() {
        return filename;
    }

    public String getPath() {
        return path;
    }

}

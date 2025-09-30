public enum LoggingLevel {
    INFO,
    DEBUG;

    public boolean isEnabled(LoggingLevel other) {
        return this.ordinal() >= other.ordinal();
    }
}

public class Main {
    public static void main(String[] args) {
        FileLoggerConfiguration config = new FileLoggerConfiguration(
                "C:\\Users\\Максим\\Desktop",
                "Test.txt",
                LoggingLevel.DEBUG,
                1024,
                "[%s][%s] %s");

        Logger logger = new FileLogger(config);

        logger.debug("Запуск приложения");
        logger.info("Пользователь вошёл в систему");
        logger.debug("Отправка запроса к БД");

    }
}

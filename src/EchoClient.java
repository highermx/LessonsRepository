import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            System.out.println("Подключено к серверу");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleIn = new BufferedReader(
                    new InputStreamReader(System.in));

            // Поток приема сообщений
            new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println("Сервер: " + response);
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка чтения: " + e.getMessage());
                }
            }).start();

            // Поток отправки сообщений
            new Thread(() -> {
                try {
                    String userInput;
                    while ((userInput = consoleIn.readLine()) != null) {
                        out.println(userInput);
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка ввода: " + e.getMessage());
                }
            }).start();

            // Удержание главного потока
            Thread.currentThread().join();

        } catch (IOException | InterruptedException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
    }
}

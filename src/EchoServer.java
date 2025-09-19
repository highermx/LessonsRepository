import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Сервер запущен на порту 8080...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключен: " + clientSocket.getInetAddress());

            // Потоки данных
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader consoleIn = new BufferedReader(
                    new InputStreamReader(System.in));

            // Поток чтения от клиентаа
            new Thread(() -> {
                try {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Клиент: " + inputLine);
                        out.println("Echo: " + inputLine);
                    }
                } catch (IOException e) {
                    System.err.println("Ошибка чтения: " + e.getMessage());
                }
            }).start();

            // Поток отправки сообщений сервером
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
            e.printStackTrace();
        }
    }
}

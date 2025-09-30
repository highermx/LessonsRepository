import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class EchoServer {
    private static final int PORT = 7;
    private static final int MAX_CLIENTS = 3;
    private static final ExecutorService pool = Executors.newFixedThreadPool(MAX_CLIENTS);
    private static final CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        System.out.println("Echo Server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            new Thread(EchoServer::handleConsoleInput).start();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                if (clients.size() < MAX_CLIENTS) {
                    ClientHandler clientHandler = new ClientHandler(clientSocket);
                    clients.add(clientHandler);
                    pool.execute(clientHandler);
                } else {
                    clientSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleConsoleInput() {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String message = consoleReader.readLine();
                if (message != null) {
                    broadcast("Server: " + message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received from client: " + inputLine);
                    sendMessage("Echo: " + inputLine);
                }
            } catch (IOException e) {
                System.out.println("Client disconnected");
            } finally {
                try {
                    clients.remove(this);
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {
    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try {
                BufferedReader fromSocket = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream(), true);
                System.out.println("Connection accepted " + clientSocket.getInetAddress());
                if(fromSocket.ready()) {
                    String message = fromSocket.readLine();
                    System.out.println("Message from client : " + message);
                }
                toSocket.println("Hello from server");
                toSocket.flush();
                fromSocket.close();
                toSocket.close();
                clientSocket.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        int port = 8010;
        Server server = new Server();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread thread = new Thread(() -> server.getConsumer().accept(clientSocket));
                thread.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
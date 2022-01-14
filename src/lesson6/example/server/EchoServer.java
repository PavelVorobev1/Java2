package lesson6.example.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static final int PORT = 8189;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Серввер начал свою работу");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            processClientConnection(input, output);

        } catch (IOException e) {
            System.err.println("Ошибка подключения к порту + " + PORT);
            e.printStackTrace();
        }
    }

    private static void processClientConnection(DataInputStream input, DataOutputStream output) {
        while (true) {
            try {
                String message = input.readUTF();
                if (message.equals("/end")) {
                    break;
                }
                output.writeUTF("Echo " + message);
            } catch (IOException e) {
                System.out.println("Соеденение было закрыто");
                break;
            }
        }
    }

}

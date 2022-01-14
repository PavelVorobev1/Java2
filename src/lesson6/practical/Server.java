package lesson6.practical;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {

    public static final int PORT = 8189;

    public static void main(String[] args) throws IOException {
        createServer();

    }

    private static void createServer() throws IOException {
        Socket socket = null;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер ожидает подключения");
            socket = serverSocket.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            System.out.println("Клиент подключился к серверу");
            receivingMessages(input);
            sendMessage(output);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket != null){
                socket.close();
            }
        }

    }

    private static void receivingMessages(DataInputStream input) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String message = input.readUTF();
                        System.out.println(message);
                        if (message.equals("/end")) {
                            System.exit(0);
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Подключение закрыто.");
                }
            }
        }).start();
    }

    private static void sendMessage(DataOutputStream output) {
        Scanner scanner = new Scanner(System.in);
            while (true){
                try {
                    String text = scanner.next();
                    output.writeUTF("Server message: " + text);
                    if(text.equals("/end")){
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}


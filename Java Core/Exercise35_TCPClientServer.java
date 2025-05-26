// Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");
        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String clientMsg, serverMsg;

        while ((clientMsg = in.readLine()) != null) {
            System.out.println("Client: " + clientMsg);
            serverMsg = keyboard.readLine();
            out.println(serverMsg);
        }

        socket.close();
        serverSocket.close();
    }
}

// Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String userInput, serverReply;

        while ((userInput = keyboard.readLine()) != null) {
            out.println(userInput);
            serverReply = in.readLine();
            System.out.println("Server: " + serverReply);
        }

        socket.close();
    }
}
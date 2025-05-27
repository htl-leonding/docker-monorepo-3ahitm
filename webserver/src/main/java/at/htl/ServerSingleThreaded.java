package at.htl;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class ServerSingleThreaded {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = ServerSocketFactory
                .getDefault()
                .createServerSocket(8080)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleConnect(clientSocket);
                clientSocket.close();
            }
        }


    }

    private static void handleConnect(Socket clientSocket) throws IOException {
            var outputStream = clientSocket.getOutputStream();
            var inputStream = clientSocket.getInputStream();
            var scanner = new Scanner(inputStream);
            int counter = 0;
            while (scanner.hasNextLine() ) {
                String line = scanner.nextLine();
                System.out.println(line);
                if (line.isEmpty()) {
                    break;
                }
            }
            var printWriter = new PrintWriter(outputStream, true, StandardCharsets.UTF_8);

            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type: text/html");
            printWriter.println("Connection: close");
            printWriter.println("\r\n");
            printWriter.println("<html><body><h1>Welcome</h1></body></html>\n");

    }
}
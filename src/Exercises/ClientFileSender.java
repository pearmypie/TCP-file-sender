package Exercises;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientFileSender {
    public static void main(String[] args) throws IOException {
        File f = new File("data.txt");
        Scanner scanner = new Scanner(f);

        Socket clientSocket;
        PrintWriter writer;
        BufferedReader reader;

        while (scanner.hasNext()) {
            clientSocket = new Socket("127.0.0.1", 4801);
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String s = scanner.nextLine();

            writer.println(s);
            System.out.println("Client sent: " + s);

            String r = reader.readLine();
            System.out.println("Server replied: " + r);

            writer.close();
            reader.close();
            clientSocket.close();
        }

        scanner.close();
    }
}

package rayasockettcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        int port = 5002;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Socket client = new Socket("localhost", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));

                System.out.println("Inserte el comnado");
                String comando = scanner.nextLine();

                toServer.println(comando);

                String result = fromServer.readLine();
                System.out.println(result);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

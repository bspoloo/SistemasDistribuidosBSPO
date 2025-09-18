/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.SocketsTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Animetx
 */
public class SeverTCP {

    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Server starte successfully");

            while (true) {
                Socket client = server.accept();
                PrintStream toClient = new PrintStream(client.getOutputStream());

                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Cliente conectado....");
                String received = fromClient.readLine();
                System.out.println("El cliente envio un mensaje: " + received);

                toClient.println("Hola mundo desde el servidor pa xd .....");
            }
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.SocketsTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author Animetx
 */
public class ClientTCP {

    public static void main(String[] args) {
        int port = 5002;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());

            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toServer.println("Hola mundo desde el cliente....");

            String result = fromServer.readLine();
            System.out.println("Respuesta del servidor: " + result);
        } catch (IOException e) {
            System.out.println("Erro IO: " + e.getMessage());
        }
    }
}

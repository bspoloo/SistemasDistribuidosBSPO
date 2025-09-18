/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.SocketsMultihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Animetx
 */
public class ServerMutithread {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5056);

        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("Cliente nuevo conectado: " + socket);

                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                System.out.println("Asignado nuevo hilo para este cliente...");
                Thread t = new ClientHandler(socket, dis, dos);
                t.start();
            } catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }
}

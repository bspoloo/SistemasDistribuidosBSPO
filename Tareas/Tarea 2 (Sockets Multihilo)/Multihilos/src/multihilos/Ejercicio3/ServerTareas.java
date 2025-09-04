/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihilos.Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Animetx
 */
public class ServerTareas {

    public static ArrayList<String> tareas = new ArrayList<>();
    public static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(5056);
        while (true) {
            Socket s = null;

            try {
                s = ss.accept();
                System.out.println("Un nuevo cliente se ha conectado: " + s);

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Aginado un nuevo hilo para este cliente: " + s);

                Thread t = new ClientHandler(s, dis, dos);
                clients.add((ClientHandler) t);
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}

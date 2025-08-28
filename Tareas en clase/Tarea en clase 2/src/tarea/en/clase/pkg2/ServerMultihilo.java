/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.en.clase.pkg2;

/**
 *
 * @author Carlos
 */
// Java implementation of Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java
import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

// Server class
public class ServerMultihilo {

    static List<Thread> clientsHandlers = new ArrayList<Thread>();

    public static void main(String[] args) throws IOException {
        // Escuchandoen el puerto 5056
        String host = "0.0.0.0";
        ServerSocket ss = new ServerSocket(5056, 50, InetAddress.getByName(host));

        //ciclo al infinito
        while (true) {
            Socket s = null;

            try {
                // Coneccion del cliente
                s = ss.accept();

                System.out.println("Un nuevo cliente se ha conectado: " + s);

                // obtener su entrada y salida de stream
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Aginar un nuevo hilopara este cliente: "+s);

                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);
                clientsHandlers.add(t);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}

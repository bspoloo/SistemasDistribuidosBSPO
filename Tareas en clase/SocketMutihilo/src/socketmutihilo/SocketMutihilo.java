/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socketmutihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class SocketMutihilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String host = "0.0.0.0";
        ServerSocket ss = new ServerSocket(5056, 50, InetAddress.getByName(host));

        //ciclo al infinito
        while (true) {
            Socket s = null;

            try {
                // Coneccion del cliente
                s = ss.accept();

                System.out.println("un nuevo cliente se ha conectado : " + s);

                // obtener su entrada y salida de stream
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Aginar unnuevo hilo para este cliente ");

                // create a new thread object
                Thread t = new ServerHandler(s, dis, dos);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
    
}

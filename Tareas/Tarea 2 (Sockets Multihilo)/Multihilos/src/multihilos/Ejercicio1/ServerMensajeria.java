package multihilos.Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMensajeria {
    static ArrayList<Thread> clients = new ArrayList<Thread>();

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(5056);

        while (true) {
            Socket s = null;

            try {
                // Coneccion del cliente
                s = ss.accept();

                System.out.println("Un nuevo cliente se ha conectado: " + s);

                // obtener su entrada y salida de stream
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Aginar un nuevo hilopara este cliente: " + s);

                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);
                clients.add(t);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}

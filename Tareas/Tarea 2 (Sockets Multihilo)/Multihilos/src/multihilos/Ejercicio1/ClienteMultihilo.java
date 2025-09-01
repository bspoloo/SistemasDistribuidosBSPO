/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multihilos.Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author rabbit
 */
class Escuchar extends Thread {

    final DataInputStream dis;

    public Escuchar(DataInputStream dis) {
        this.dis = dis;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = dis.readUTF();
                String[] respuesta = received.split(":");
                System.out.println("\n[" + respuesta[1] + "]: " + respuesta[2]);
            }
        } catch (IOException e) {
            System.out.println("Conexión cerrada.");
        }
    }
}

public class ClienteMultihilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerMessage = new Scanner(System.in);

        try {

            String mens = null;
            int opcion = 0;

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");
            //InetAddress ip = InetAddress.getByName("10.8.221.126");
            //InetAddress ip = InetAddress.getByName("192.168.0.102");            
            InetAddress ipUser = InetAddress.getLocalHost();

            // establish the connection with server port 5056
            Socket s = new Socket(ip, 5056);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            String tosend = null;
            Thread t = new Escuchar(dis);
            t.start();
            while (opcion != 3) {
                System.out.println("""
                             CHAT GRUPAL
                             1.- Enviar Mensaje:
                             2.- Leer Mensajes:
                             3.--Salir--""");
                opcion = scannerInt.nextInt();
                //opcion = 1;
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca el Mensaje a enviar:");
                        mens = scannerMessage.nextLine();
                        tosend = "message:" + ipUser.getHostAddress() + ":" + mens;
                        break;
                    case 2:
                        System.out.println("no hay opcion");
                        break;
                    default:
                        System.out.println("Erro en opciones:");
                        break;
                }

                dos.writeUTF(tosend);
                System.out.println("Mensaje Enviado....");

                //String tosend = scannerInt.nextLine();
                // If client sends exit,close this connection
                // and then break from the while loop
                // printing date or time as requested by client
            }

            // closing resources
            scannerInt.close();
            scannerMessage.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

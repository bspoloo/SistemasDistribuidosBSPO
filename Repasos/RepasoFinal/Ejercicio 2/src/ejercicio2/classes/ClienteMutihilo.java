/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2.classes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Animetx
 */
class Escuchar extends Thread {

    private final DataInputStream dis;
    private final DataOutputStream dos;
    private String id;

    public Escuchar(DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = dis.readUTF();
                String[] parts = received.split(":");
                System.out.println(received);
                if (parts[0].equals("message")) {
                    System.out.println("[mensaje del servidor]: " + parts[1]);
                } else if (parts[0].equals("reporte")) {
                    System.out.println("[reporte del servidor]: " + parts[1]);
                } else {
                    System.out.println("formato incorrecto...");
                }
            }
        } catch (IOException e) {
            System.out.println("Conexión cerrada.");
        }
    }
}

public class ClienteMutihilo {

    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress ip = InetAddress.getByName("localhost");
        Socket s = new Socket(ip, 5056);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Thread t = new Escuchar(dis, dos);
        Scanner scannerN = new Scanner(System.in);
        Scanner scannerS = new Scanner(System.in);
        String toSend = "";
        t.start();
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("""
                             GESTION DE SENSORES
                             1.- Agregar:
                             2.- Reporte:
                             3.- Salir--""");
            opcion = scannerN.nextInt();
            //opcion = 1;
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el ID del sensor: ");
                    String id = scannerS.nextLine();
                    System.out.println("Introduzca el Estado del sensor: LOW-MIDDLE-HIGHER");
                    String status = scannerS.nextLine();
                    toSend = "agregar:" + id + "-" + status;
                    break;
                case 2:
                    toSend = "reporte:ver-max-status";
                    break;
                case 4:
                    System.out.println("Saliendo.. ");
                    scannerN.close();
                    scannerS.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error en opciones:");
                    break;
            }
            dos.writeUTF(toSend);
            System.out.println("Mensaje Enviado....");
        }
        scannerN.close();
        scannerS.close();
        dis.close();
        dos.close();
    }
}

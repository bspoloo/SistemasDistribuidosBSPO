package multihilos.Ejercicio3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

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
                if (parts.length > 2 && parts[0].equals("message")) {
                    String[] lista = parts[2].split(",");
                    System.out.println("--------------" + parts[1].toUpperCase() + "--------------");
                    for (int i = 0; i < lista.length; i++) {
                        System.out.println((i+1)+".- "+lista[i]);
                    }
                } else if (parts[0].equals("message")) {
                    System.out.println("[mensaje del servidor]: " + parts[1]);
                } else {
                    System.out.println("formato incorrecto...");
                }
            }
        } catch (IOException e) {
            System.out.println("Conexión cerrada.");
        }
    }
}

public class ClienteMultihilo {

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
                             GESTION DE TAREAS
                             1.- Agregar:
                             2.- Eliminar:
                             3.- Listar:
                             4.--Salir--""");
            opcion = scannerN.nextInt();
            //opcion = 1;
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el la nueva tarea: ");
                    String tarea = scannerS.nextLine();
                    toSend = "agregar:" + tarea;
                    break;
                case 2:
                    System.out.println("Introduzca el id de la tarea a eliminar: ");
                    int id = scannerN.nextInt();
                    toSend = "eliminar:" + (id-1);
                    break;
                case 3:
                    System.out.println("Introduzca el la nueva tarea: ");
                    String listas = "listar tareas";
                    toSend = "listar:" + listas;
                    break;
                case 4:
                    System.out.println("Saliendo.. ");
                    scannerN.close();
                    scannerS.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Erro en opciones:");
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

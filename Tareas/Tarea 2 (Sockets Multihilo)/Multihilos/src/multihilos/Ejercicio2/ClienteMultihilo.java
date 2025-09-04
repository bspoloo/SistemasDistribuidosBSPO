package multihilos.Ejercicio2;

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
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String received = dis.readUTF();
                String[] parts = received.split(":");
                if (parts[0].equals("pregunta")) {
                    System.out.println("------------------" + parts[1] + "------------------");
                    String[] opciones = parts[2].split(",");
                    for (int i = 0; i < opciones.length; i++) {
                        System.out.println(i + ".- " + opciones[i]);
                    }
                    System.out.print("Inserte una opcion: ");
                    int opcion = scanner.nextInt();
                    dos.writeUTF("respuesta:" + id + ":" + opcion);
                } else if (parts[0].equals("message")) {
                    System.out.println(parts[1]);
                } else if (parts[0].equals("setting")) {
                    this.id = parts[2];
                    System.out.println("Id asignado: " + id);
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
        t.start();
        t.join();

        dis.close();
        dos.close();
    }
}

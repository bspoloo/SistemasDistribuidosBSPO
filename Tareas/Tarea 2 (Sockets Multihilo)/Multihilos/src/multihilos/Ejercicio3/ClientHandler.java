package multihilos.Ejercicio3;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final Socket s;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    public void sentMessage(String message) throws IOException {
        dos.writeUTF(message);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = dis.readUTF();
                System.out.println(received);
                String[] parts = received.split(":", 3);
                if (parts.length < 1) {
                    dos.writeUTF("Formato incorrecto");
                    continue;
                }

                String command = parts[0];
                String data = parts[1];
                switch (command) {
                    case "agregar":
                        ServerTareas.tareas.add(data);
                        for (ClientHandler c : ServerTareas.clients) {
                            if (c != this) {
                                c.sentMessage("message: se ha agregado una nueva tarea");
                            }
                        }
                        break;
                    case "eliminar":
                        try {
                            int index = Integer.parseInt(data);
                            if (index < 0 || index > ServerTareas.tareas.size()) {
                                this.sentMessage("message: el id " + index + " no esta fuera de rango");
                                break;
                            }
                            ServerTareas.tareas.remove(index);
                            for (ClientHandler c : ServerTareas.clients) {
                                if (c != this) {
                                    c.sentMessage("message: se ha eliminado una tarea con id " + index);
                                }
                            }
                        } catch (NumberFormatException e) {
                            this.sentMessage("message:" + data + " no es el id de una tarea");
                        }
                        break;
                    case "listar":
                        String response = "message:La lista es:";
                        for (String tarea : ServerTareas.tareas) {
                            response += tarea + ",";
                        }
                        this.sentMessage(response);
                        break;
                    case "exit":
                        System.out.println("Cliente " + s + " desconectado.");
                        ServerTareas.clients.remove(this);
                        s.close();
                        return;

                    default:
                        dos.writeUTF("Comando inválido");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Cliente " + s + " cerró la conexión.");
        }
    }
}

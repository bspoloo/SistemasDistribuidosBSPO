package tarea.en.clase.pkg2;

import java.io.*;
import java.net.*;

class ClientHandler extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }
    public void sentMessage(String message) throws IOException {
        this.dos.writeUTF(message);
    }
    @Override
    public void run() {
        String received;

        while (true) {
            try {
                received = dis.readUTF();
                System.out.println("mensaje recibido: " + received);

                String[] parts = received.split(":", 3);
                if (parts.length < 3) {
                    dos.writeUTF("Formato incorrecto. Use: comando:usuario:mensaje");
                    continue;
                }

                String command = parts[0];
                String user = parts[1];
                String message = parts[2];

                switch (command) {
                    case "message":
                        String response = "message:" + user + ":" + message;

                        for (Thread c : ServerMultihilo.clientsHandlers) {
                            ClientHandler client = (ClientHandler) c;
                            if (client != this) {
                                client.sentMessage(response);
                            }
                        }
                        break;

                    case "exit":
                        System.out.println("Cliente " + s + " (" + user + ") se desconectó.");
                        s.close();
                        ServerMultihilo.clientsHandlers.remove(this);
                        return;

                    default:
                        dos.writeUTF("Comando inválido");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

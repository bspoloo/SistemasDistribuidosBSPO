package multihilos.Ejercicio2;

import java.io.*;
import java.net.Socket;
import multihilos.Ejercicio2.classes.Pregunta;

public class ClientHandler extends Thread {

    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final Socket s;
    private Pregunta preguntaActual;
    private int puntuacion;
    private final int idCliente;

    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos, int idCliente) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.idCliente = idCliente;
        this.puntuacion = 0;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setPreguntaActual(Pregunta p) {
        this.preguntaActual = p;
    }

    public void sentMessage(String message) throws IOException {
        dos.writeUTF(message);
    }

    public void incrementarPuntuacion() {
        System.out.println("aumentando puntuacion");
        puntuacion++;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = dis.readUTF();
                System.out.println(received);
                String[] parts = received.split(":", 3);
                if (parts.length < 3) {
                    dos.writeUTF("Formato incorrecto. Use: comando:id:opcion");
                    continue;
                }

                String command = parts[0];
                int userId = Integer.parseInt(parts[1]);
                int opcion = Integer.parseInt(parts[2]);

                switch (command) {
                    case "respuesta":
                        if (preguntaActual != null && opcion + 1 == preguntaActual.getOpcionCorrecta()) {
                            this.incrementarPuntuacion();
                            dos.writeUTF("message:¡Correcto! +1 punto. Total " + this.getPuntuacion());
                        } else {
                            dos.writeUTF("message:Opción incorrecta");
                        }

                        for (ClientHandler c : ServerPreguntas.clients) {
                            if (c.getIdCliente() != this.idCliente) {
                                c.sentMessage("message:El usuario " + userId + " ya ha respondido la pregunta");
                            }
                        }
                        break;

                    case "exit":
                        System.out.println("Cliente " + idCliente + " desconectado.");
                        ServerPreguntas.clients.remove(this);
                        s.close();
                        return;

                    default:
                        dos.writeUTF("Comando inválido");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Cliente " + idCliente + " cerró la conexión.");
        }
    }
}

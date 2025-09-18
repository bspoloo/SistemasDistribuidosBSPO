/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.SocketsMultihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Animetx
 */
public class ClientHandler extends Thread {

    DateFormat forDate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat forTime = new SimpleDateFormat("hh:mm:ss");

    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final Socket socket;

    public ClientHandler(Socket socket, DataInputStream dis, DataOutputStream dos) {
        this.socket = socket;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        String toReturn;

        while (true) {
            try {
                dos.writeUTF("Fecha hora? [Date | Time]..\n" + "Escribir Exit para terminar la conexion:");
                received = dis.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.socket + " sends exit");
                    System.out.println("Closing connection");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                Date date = new Date();
                switch (received) {
                    case "Date":
                        toReturn = forDate.format(date);
                        dos.writeUTF(toReturn);
                        break;
                    case "Time":
                        toReturn = forTime.format(date);
                        dos.writeUTF(toReturn);
                        break;
                    default:
                        dos.writeUTF("Invalid Input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.dis.close();
            this.dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

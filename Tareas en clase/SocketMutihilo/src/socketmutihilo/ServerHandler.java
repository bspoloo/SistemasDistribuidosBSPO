/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketmutihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import socketmutihilo.clases.ProcesadorProtocolo;

/**
 *
 * @author Admin
 */
class ServerHandler extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    // Constructor
    public ServerHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        String numeros = "";
        while (true) {
            try {

                // Ask user what he wants
                dos.writeUTF("Inserte los comandos por favor");
                
                
                // receive the answer from client
                
                received = dis.readUTF();
                String respuesta;
                if(received.split(":").length > 2) {
                    numeros = received.split(":")[2];
                }
                ProcesadorProtocolo procesador = new ProcesadorProtocolo(this.s, numeros);
                respuesta = procesador.procesar(received);
                dos.writeUTF(respuesta);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

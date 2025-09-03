/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multihilos.Ejercicio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ServerPreguntas {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5056);
        while (true) {
            Socket s = null;

            try {

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
}

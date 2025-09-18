/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.SocketsUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author Animetx
 */
public class ClientUDP {

    public static void main(String[] args) {
        int port = 6789;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Introduzca su nombre");
            String data = scanner.nextLine();
            String ip = "localhost";

            DatagramSocket socketUDP = new DatagramSocket();
            byte[] message = data.getBytes();
            InetAddress serverHost = InetAddress.getByName(ip);

            DatagramPacket peticion = new DatagramPacket(message, data.length(), serverHost, port);

            socketUDP.send(peticion);

            byte[] buffer = new byte[1000];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(response);

            System.out.println("Respuesta del server: " + new String(response.getData()));
            socketUDP.close();

        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }
}

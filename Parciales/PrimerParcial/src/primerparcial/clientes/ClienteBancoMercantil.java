/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.clientes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author USUARIO
 */
public class ClienteBancoMercantil {
    public static String consultarCuentas(String ci, String nombres, String apellidos) {
        int port1 = 6060;
        
        try {
            System.out.println("------CLIENTE BANCO MERCANTIL-----");
            System.out.println("ci: " + ci);
            System.out.println("nombres: " + nombres);
            System.out.println("apellidos: " + apellidos);

            String ip = "26.5.198.9";
            DatagramSocket socketUDP = new DatagramSocket();
            String data = "Buscar:" + ci + "-" + nombres + "-" + "-" + apellidos;
            byte[] mensaje = data.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            DatagramPacket peticion = new DatagramPacket(mensaje, data.length(), hostServidor, port1);
            socketUDP.send(peticion);

            byte[] buffer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(respuesta);

            String resultado = new String(respuesta.getData());
            System.out.println("Respuesta del servidor " + resultado);

            socketUDP.close();
            return resultado;
        } catch (SocketException e) {
            System.out.println("Error socket: " + e.getMessage());
            return "error:" + e.getMessage();
        } catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());
            return "error:" + e.getMessage();
        }
        
    }
    public static void main(String[] args) {
        int port1 = 6060;
        String ci = "11021654";
        String nombres = "Juan Perez";
        String apellidos = "Segovia";
        try {
            System.out.println("------CLIENTE BANCO MERCANTIL-----");
            System.out.println("ci: " + ci);
            System.out.println("nombres: " + nombres);
            System.out.println("apellidos: " + apellidos);

            String ip = "26.5.198.9";
            DatagramSocket socketUDP = new DatagramSocket();
            String data = "Buscar:" + ci + "-" + nombres + "-" + "-" + apellidos;
            byte[] mensaje = data.getBytes();
            InetAddress hostServidor = InetAddress.getByName(ip);

            DatagramPacket peticion = new DatagramPacket(mensaje, data.length(), hostServidor, port1);
            socketUDP.send(peticion);

            byte[] buffer = new byte[1000];
            DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(respuesta);

            String resultado = new String(respuesta.getData());
            System.out.println("Respuesta del servidor " + resultado);

            socketUDP.close();
        } catch (SocketException e) {
            System.out.println("Error socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());
        }
    }
}

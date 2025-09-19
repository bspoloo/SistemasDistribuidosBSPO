/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.servidores.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author USUARIO
 */
public class ServidorBancoBCP {

    public static void main(String[] args) {
        int port = 5001;
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] buffer = new byte[1000];

            while (true) {
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(peticion);
                System.out.println("Datagrama recibido del host " + peticion.getAddress());
                System.out.println("Desde el puerto " + peticion.getPort());

                String cadena = new String(peticion.getData(), 0, peticion.getLength()).trim();
                String protocolo = cadena.split(":")[0];
                String data = cadena.split(":")[1];
                String ci = data.split("-")[0];
                String nombres = data.split("-")[1];
                String apellidos = data.split("-")[2];
                
                String response = "";
                if (protocolo.equals("Buscar")) {
                    System.out.println("--------SERVIDOR BANCO BCP----------");
                    System.out.println("ci: " + ci);
                    System.out.println("nombres: " + nombres);
                    System.out.println("apellidos: " + apellidos);
                    
                    response = "1115-5200:657654-6000";
                }else {
                    System.out.println("Error en el servidor");
                }
                
                byte[] mensaje = response.getBytes();

                DatagramPacket respuesta = new DatagramPacket(mensaje, response.length(), peticion.getAddress(), peticion.getPort());
                socketUDP.send(respuesta);
            }

        } catch (SocketException e) {
            System.out.println("Error socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());
        }
    }
}

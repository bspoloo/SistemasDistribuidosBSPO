/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.SocketsUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Animetx
 */
public class ServerUDP {
    public static void main(String[] args) {
        int port = 6789; //definimos el puerto a escuchar
        try{
            DatagramSocket socketUDP= new DatagramSocket(port);
            byte[] bufer = new byte[1000];
            
            while(true){
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
                
                //leemos la peticion del Socket
                socketUDP.receive(peticion);
                
                System.out.println("Datagrama recibido del host: "+ peticion.getAddress());
                System.out.println("Desde el puerto remoto: "+ peticion.getPort());
                
                String data = new String(peticion.getData());
                String response = "Hola "+ data;
                
                byte[] message = response.getBytes();
                DatagramPacket serverResponse = new DatagramPacket(message, response.length(), peticion.getAddress(), peticion.getPort());
                
                socketUDP.send(serverResponse);
            }
        }catch(SocketException e) {
            System.out.println("Socket error: "+ e.getMessage());
        }catch(IOException e) {
            System.out.println("Socket error: "+ e.getMessage());
        }
    }
}

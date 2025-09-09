package practica3.rmi.sockets.clients;


import java.net.*;

public class ClienteSERECI {
    public static String verificarFecha(String datos) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");
            byte[] sendData = datos.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, 54321);
            socket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);

            return new String(receivePacket.getData(), 0, receivePacket.getLength());

        } catch (Exception e) {
            return "no:Error de conexión con SERECI";
        }
    }
}

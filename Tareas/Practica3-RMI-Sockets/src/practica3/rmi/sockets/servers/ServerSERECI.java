package practica3.rmi.sockets.servers;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerSERECI {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(54321)) {
            System.out.println("Servidor SERECI (UDP) escuchando en puerto 54321...");
            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String request = new String(packet.getData(), 0, packet.getLength());
                System.out.println("El cliente envio: " + request);

                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();

                String response;
                if (request.startsWith("Ver-fecha:")) {
                    String[] partes = request.substring("Ver-fecha:".length()).split(",");
                    if (partes.length == 3) {
                        String nombres = partes[0];
                        String apellidos = partes[1];
                        String fecha = partes[2];

                        // Verificar fecha (ejemplo: 11-02-1996)
                        if ("11-02-1996".equals(fecha)) {
                            response = "si:verificación correcta";
                        } else {
                            response = "no:error fecha nacimiento no correcta";
                        }
                    } else {
                        response = "no:formato inválido";
                    }
                } else {
                    response = "no:solicitud inválida";
                }

                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseData, responseData.length, clientAddress, clientPort);
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            System.err.println("Error en servidor SERECI: " + e.getMessage());
        }
    }
}

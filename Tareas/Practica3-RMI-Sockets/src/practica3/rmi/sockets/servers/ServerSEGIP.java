package practica3.rmi.sockets.servers;


import practica3.rmi.sockets.classes.RespuestaSEGIP;
import practica3.rmi.sockets.interfaces.IServerSEGIP;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ServerSEGIP extends UnicastRemoteObject implements IServerSEGIP{
    public ServerSEGIP() throws RemoteException {
        super();
    }

    @Override
    public RespuestaSEGIP verificarDatos(String ci, String nombres, String apellidos) {
        // Lógica de verificación (ejemplo)
        if ("1140506".equals(ci) && "Walter Jhamil".equals(nombres) &&
                "Segovia Arellano".equals(apellidos)) {
            return new RespuestaSEGIP(true, "Los Datos son correctos");
        } else {
            return new RespuestaSEGIP(false, "Los Datos del CI no son correctos");
        }
    }

    public static void main(String[] args) {
        try {
            ServerSEGIP servidor = new ServerSEGIP();
            LocateRegistry.createRegistry(1100); // Puerto diferente
            Naming.bind("rmi://localhost:1100/ServidorSEGIP", servidor);
            System.out.println("Servidor SEGIP RMI listo...");
        } catch (Exception e) {
            System.err.println("Error en servidor SEGIP: " + e.getMessage());
        }
    }
}

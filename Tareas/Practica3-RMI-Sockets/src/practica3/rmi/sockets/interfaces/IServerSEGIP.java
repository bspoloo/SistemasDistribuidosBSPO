package practica3.rmi.sockets.interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import practica3.rmi.sockets.classes.RespuestaSEGIP;

public interface IServerSEGIP extends Remote{
    public RespuestaSEGIP verificarDatos(String ci, String nombres, String apellidos)
            throws RemoteException;
}

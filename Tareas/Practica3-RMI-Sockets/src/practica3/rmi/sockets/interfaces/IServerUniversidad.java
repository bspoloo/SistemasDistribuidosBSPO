package practica3.rmi.sockets.interfaces;



import java.rmi.Remote;
import java.rmi.RemoteException;
import practica3.rmi.sockets.classes.Diploma;

public interface IServerUniversidad extends Remote{
    public Diploma emitirDiploma(String ci, String nombres, String primerApellido,
                                 String segundoApellido, String fechaNacimiento, String carrera)
            throws RemoteException;
}

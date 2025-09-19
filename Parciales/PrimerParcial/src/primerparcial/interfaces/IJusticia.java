/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import primerparcial.clases.Cuenta;
import primerparcial.clases.Respuesta;
/**
 *
 * @author USUARIO
 */
public interface IJusticia extends Remote{
    public Respuesta consultarCuentas(String ci, String nombres, String apellidos) throws RemoteException;
}

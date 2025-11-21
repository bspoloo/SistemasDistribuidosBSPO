/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Animetx
 */
public interface ICadena extends Remote {
    
    boolean guardarFrase(String frase) throws RemoteException;

    String convertirMayusculas() throws RemoteException;

    String duplicarEspacios(int n) throws RemoteException;

    String concatenar(String extra) throws RemoteException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package operacionesrmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Admin
 */
public interface IOperacion extends Remote {
    int sumar(int a, int b) throws RemoteException;

    int restar(int a, int b) throws RemoteException;

    int multiplicar(int a, int b) throws RemoteException;

    int dividir(int a, int b) throws RemoteException;
}

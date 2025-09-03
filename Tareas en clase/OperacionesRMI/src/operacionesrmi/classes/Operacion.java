/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacionesrmi.classes;

import operacionesrmi.interfaces.IOperacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Admin
 */
public class Operacion extends UnicastRemoteObject implements IOperacion {

    protected Operacion() throws RemoteException {
        super();
    }

    @Override
    public int sumar(int a, int b) throws RemoteException {
        return 0;
    }

    @Override
    public int restar(int a, int b) throws RemoteException {
        return 0;
    }

    @Override
    public int multiplicar(int a, int b) throws RemoteException {
        return 0;
    }

    @Override
    public int dividir(int a, int b) throws RemoteException {
        return 0;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.RMI.classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import repasos.RMI.interfaces.IOperation;

/**
 *
 * @author Animetx
 */
public class Operation extends UnicastRemoteObject implements IOperation {

    public Operation() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int rest(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public int divide(int a, int b) throws RemoteException {
        return a / b;
    }

}

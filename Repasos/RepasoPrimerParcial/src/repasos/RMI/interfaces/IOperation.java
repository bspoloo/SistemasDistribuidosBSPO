/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.RMI.interfaces;
import java.rmi.RemoteException;
import java.rmi.Remote;
/**
 *
 * @author Animetx
 */
public interface IOperation extends Remote{
    public int add(int a, int b) throws RemoteException;
    public int rest(int a, int b) throws RemoteException;
    public int multiply(int a, int b) throws RemoteException;
    public int divide(int a, int b) throws RemoteException;
}

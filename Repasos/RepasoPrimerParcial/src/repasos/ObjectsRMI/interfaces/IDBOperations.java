/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.ObjectsRMI.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import repasos.ObjectsRMI.classes.Person;
import repasos.ObjectsRMI.classes.Response;

/**
 *
 * @author Animetx
 */
public interface IDBOperations extends Remote {
    public Response insert(Person person) throws RemoteException;
    public Response update(Person person) throws RemoteException;
    public Response getAll() throws RemoteException;
    public Response getById(int id) throws RemoteException;
    public Response deleteById(int id) throws RemoteException;
}

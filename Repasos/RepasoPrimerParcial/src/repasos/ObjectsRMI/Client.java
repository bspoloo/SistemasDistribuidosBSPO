/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.ObjectsRMI;

import repasos.ObjectsRMI.interfaces.IDBOperations;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Animetx
 */
public class Client {

    public static void main(String[] args) {
        try {
            IDBOperations dbOperation = (IDBOperations) Naming.lookup("rmi://localhost/db_operations");
            //hacer la logica con scanners y demas aqui para manejar las insersiones xd
            
        } catch (NotBoundException ex) {
            System.getLogger(Client.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (MalformedURLException ex) {
            System.getLogger(Client.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (RemoteException ex) {
            System.getLogger(Client.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}

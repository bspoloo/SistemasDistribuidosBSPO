/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.servidores.RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import primerparcial.clases.ASFI;
import primerparcial.clases.Cuenta;
import primerparcial.clientes.ClienteBancosUPD;
import primerparcial.enums.Banco;
import primerparcial.interfaces.IASFI;

/**
 *
 * @author USUARIO
 */
public class ServidorASFI {

    public static void main(String[] args) {
        try {
            ASFI asfi = new ASFI();
            LocateRegistry.createRegistry(1099);
            Naming.bind("asfi", asfi);
            
        } catch (RemoteException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        } catch (AlreadyBoundException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        } catch (MalformedURLException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
    }
}

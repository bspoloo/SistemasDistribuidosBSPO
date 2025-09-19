/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.servidores.RMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import primerparcial.clases.ASFI;
import primerparcial.clases.Justicia;

/**
 *
 * @author USUARIO
 */
public class ServidorJusticia {
    public static void main(String[] args) {
        try {
            Justicia justicia = new Justicia();
            LocateRegistry.createRegistry(2099);
            Naming.bind("justicia", justicia);

        } catch (RemoteException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        } catch (AlreadyBoundException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        } catch (MalformedURLException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
    }
}

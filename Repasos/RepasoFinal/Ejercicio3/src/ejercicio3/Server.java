/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio3;

import ejercicio3.classes.Cadena;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author Animetx
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        {
            try {
                Cadena operacion = new Cadena();
                LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
                Naming.bind("cadenas", operacion);

            } catch (RemoteException ex) {
                System.getLogger(Server.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (AlreadyBoundException ex) {
                System.getLogger(Server.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (MalformedURLException ex) {
                System.getLogger(Server.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }

}

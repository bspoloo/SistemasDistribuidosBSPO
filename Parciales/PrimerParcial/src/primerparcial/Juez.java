/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primerparcial;

import java.util.Scanner;
import primerparcial.interfaces.IJusticia;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import primerparcial.clases.Cuenta;
import primerparcial.clases.Respuesta;
import primerparcial.servidores.RMI.ServidorASFI;

/**
 *
 * @author USUARIO
 */
public class Juez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            IJusticia justicia = (IJusticia) Naming.lookup("rmi://localhost/justicia");
            System.out.println("------CLIENTE JUSTICIA---------");
            System.out.println("CI: ");
            String ci = scanner.nextLine();
            System.out.println("Nombres: ");
            String nombres = scanner.nextLine();
            System.out.println("Apellidos:");
            String apellidos = scanner.nextLine();

            Respuesta respuesta = justicia.consultarCuentas(ci, nombres, apellidos);
            System.out.println("--------RESPUESTA--------");
            if (respuesta.getCuentas() == null) {
                System.out.println("No hay cuentas por mostrar!!!");
            } else {
                for (Cuenta cuenta : respuesta.getCuentas()) {
                    System.out.println(cuenta.getBanco() + " " + cuenta.getNro_cuenta() + " " + cuenta.getSaldo());
                }
            }
        } catch (RemoteException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        } catch (MalformedURLException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        } catch (NotBoundException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
    }
}

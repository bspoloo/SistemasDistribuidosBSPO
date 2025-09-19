/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.clientes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import primerparcial.clases.Cuenta;
import primerparcial.clases.Respuesta;
import primerparcial.interfaces.IASFI;
import primerparcial.interfaces.IJusticia;
import primerparcial.servidores.RMI.ServidorASFI;

/**
 *
 * @author USUARIO
 */
public class ClienteASFI {

    public static List<Cuenta> consultarCuentas(String ci, String nombres, String apellidos) {
        try {
            IASFI asfi = (IASFI) Naming.lookup("rmi://localhost/asfi");

            List<Cuenta> cuentas = asfi.consultarCuentas(ci, nombres, apellidos);
            System.out.println("--------RESPUESTA--------");
            for (Cuenta cuenta : cuentas) {
                System.out.println(cuenta.getBanco() + " " + cuenta.getNro_cuenta() + " " + cuenta.getSaldo());
            }
            return cuentas;
        } catch (RemoteException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
            return new ArrayList<>();
        } catch (MalformedURLException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
            return new ArrayList<>();
        } catch (NotBoundException e) {
            System.getLogger(ServidorASFI.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
            return new ArrayList<>();
        }
    }
}

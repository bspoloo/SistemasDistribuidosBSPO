/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.clases;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import primerparcial.clientes.ClienteBancosUPD;
import primerparcial.enums.Banco;
import primerparcial.interfaces.IASFI;

/**
 *
 * @author USUARIO
 */
public class ASFI extends UnicastRemoteObject implements IASFI {

    public ASFI() throws RemoteException {
        super();
    }

    @Override
    public List<Cuenta> consultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        String respuesta = ClienteBancosUPD.consultarCuentas(ci, nombres, apellidos);
        String[] cuentasText = respuesta.split(":");
        List<Cuenta> cuentas = new ArrayList<>();
        for (int i = 0; i < cuentasText.length; i++) {
            String nro_cuenta = cuentasText[i].split("-")[0];
            String saldo = cuentasText[i].split("-")[1];
            Cuenta cuenta = new Cuenta(ci, nombres, apellidos, nro_cuenta, Double.parseDouble(saldo), Banco.BancoBCP);
            cuentas.add(cuenta);
        }
        return cuentas;
    }
}

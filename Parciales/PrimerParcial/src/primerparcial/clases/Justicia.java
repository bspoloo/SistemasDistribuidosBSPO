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
import primerparcial.clientes.ClienteSEGIP;
import primerparcial.enums.Banco;
import primerparcial.interfaces.IASFI;
import primerparcial.interfaces.IJusticia;

/**
 *
 * @author USUARIO
 */
public class Justicia extends UnicastRemoteObject implements IJusticia {

    public Justicia() throws RemoteException {
        super();
    }

    @Override
    public Respuesta consultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {

        String data = ClienteSEGIP.consultarCuentas(ci, nombres, apellidos);
        String resultado = data.split(":")[1];
        if (resultado.equals("encontrado")) {
            String respuesta = ClienteBancosUPD.consultarCuentas(ci, nombres, apellidos);
            String[] cuentasText = respuesta.split(":");
            List<Cuenta> cuentas = new ArrayList<>();
            for (int i = 0; i < cuentasText.length; i++) {
                String nro_cuenta = cuentasText[i].split("-")[0];
                String saldo = cuentasText[i].split("-")[1];
                Cuenta cuenta = new Cuenta(ci, nombres, apellidos, nro_cuenta, Double.parseDouble(saldo), Banco.BancoBCP);
                cuentas.add(cuenta);
            }
            Respuesta response = new Respuesta(true, null, cuentas);
            return response;
        } else {
            return new Respuesta(false, "Error usuario con ci " + ci + " no encontrado", null);
        }
    }
}

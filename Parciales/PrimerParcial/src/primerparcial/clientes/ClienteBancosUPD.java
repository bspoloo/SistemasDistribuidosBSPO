/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.clientes;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author USUARIO
 */
public class ClienteBancosUPD {

    public static String consultarCuentas(String ci, String nombres, String apellidos) {
        String cuentasBancoBCP = "";
        String cuentasBancoMercantil = "";

        try {
            cuentasBancoBCP = ClienteBancoBCP.consultarCuentas(ci, nombres, apellidos);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        try {
            cuentasBancoMercantil = ClienteBancoMercantil.consultarCuentas(ci, nombres, apellidos);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return cuentasBancoBCP + ":" + cuentasBancoMercantil;
    }

    public static void main(String[] args) {
        String ci = "11021654";
        String nombres = "Juan Perez";
        String apellidos = "Segovia";
    }
}

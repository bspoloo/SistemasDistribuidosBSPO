/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.clientes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author USUARIO
 */
public class ClienteSEGIP {

    public static String consultarCuentas(String ci, String nombres, String apellidos) {
        int port = 5551;
        try {
            System.out.println("------CLIENTE BANCO SEGIP------------");
            Socket client = new Socket("10.79.85.166", port);
            String data = "Buscar:" + ci + "-" + nombres + "-" + apellidos;
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            toServer.println(data);
            String result = fromServer.readLine();
            System.out.println("Resultado es: " + result);
            return result;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "Error " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        int port = 5551;
        String ci = "11021654";
        String nombres = "Juan Perez";
        String apellidos = "Segovia";
        try {
            System.out.println("------CLIENTE BANCO SEGIP------------");
            Socket client = new Socket("10.79.85.166", port);
            String data = "Buscar:" + ci + "-" + nombres + "-" + apellidos;
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));

            toServer.println(data);
            String result = fromServer.readLine();
            System.out.println("Resultado es: " + result);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

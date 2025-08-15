/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketstcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Cliente {

    public static void main(String[] args) {
        int port = 5002;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduzca un numero: ");
            String numero = scanner.next();
            
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            
            toServer.println(numero);
            
            String result = fromServer.readLine();
            System.out.println("cadena devuelta por el servidor es: " + result);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

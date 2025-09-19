/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial.servidores.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author USUARIO
 */
public class ServidorBancoSEGIP {
    public static void main(String[] args) {
        int port = 6001;
        ServerSocket server;
        try{
            server = new ServerSocket(port);
            System.out.println("-------SERVIDOR BANCO SEGIP TCP----------");
            while(true) {
                Socket client;
                PrintStream toClient;
                
                client = server.accept();
                BufferedReader fronClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println("Cliente se conecto....");
                
                String recibido = fronClient.readLine();
                
                System.out.println("El cliente mando el protocolo -> "+recibido);
                String protocolo = recibido.split(":")[0];
                String data = recibido.split(":")[1];
                String ci = recibido.split("-")[0];
                String nombres = data.split("-")[1];
                String apellidos = data.split("-")[2];
                String resultado = "resultado:";
                if(protocolo.equals("buscar")) {
                    if(ci.equals("11021654") && nombres.equals("Juan Perez") && apellidos.equals("Segovia")){
                       resultado += "encontrado"; 
                    }else{
                        resultado += "no-encontrado";
                    }
                }else {
                    resultado +="comandos-erroneos";
                }
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(resultado);
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

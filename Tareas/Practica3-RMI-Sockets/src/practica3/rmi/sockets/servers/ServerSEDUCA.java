/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3.rmi.sockets.servers;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class ServerSEDUCA {
    Scanner sc = new Scanner(System.in);
    //String[] datos = ["Jhamil", "Segovia", "Arellano", "11-02-1996"];
    String rudeActual = "WaSeAr11021996";
//    CI:1140506
//Nombres:Walter Jhamil
//1erApellido: Segovia
//2doApellido: Arellano
//fecha_nacimiento : 11-02-1996
//Carrera:Ing. en Ciencias de la Computación
//RUDE:WaSeAr11021996

    public static void main(String[] args) {
        int port = 5002;
        ServerSEDUCA servidor = new ServerSEDUCA();
        ServerSocket server;
        try {
            // TODO code application logic here
            server = new ServerSocket(port);
                System.out.println("Se inicio el servidor con éxito");
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                System.out.println("Cliente se conecto");
                //String recibido = fromClient.readLine();
            while (true) {
                String recibido = fromClient.readLine();
                System.out.println("El cliente envio:" + recibido);
                String mensajeRegreso = servidor.ProcesarSolicitud(recibido);
               
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(mensajeRegreso);    
            }
            
            
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    //verificarrude: xxx,xxxxx,xxxxx,27-14-2025
    public  String ProcesarSolicitud(String recibido){
        String[] comando = recibido.split(":");
        if(comando[0].equals("verificar-rude")){
            // xxx,xxxxx,xxxxx,27-14-2025
            String[] entradas = comando[1].split(",");
            String newrude = null;
            String[] fecha = null;
            if(entradas.length>=4){
                fecha = entradas[3].split("-");
                newrude =entradas[0].substring(0,2)+ entradas[1].substring(0,2) + entradas[2].substring(0,2) + fecha[0] + fecha[1] + fecha[2];
                System.out.println("Rude Calculado" + newrude);
                if(newrude.equals(rudeActual)){
                    return "mensaje:verificado con exito";
                }
                else{
                    return "mensaje:no se encontró el titulo de bachiller";
                }
            }
            else{
                return "mensaje:error|no se proceso bien los datos";

            }
            
        }
        else{
            return "mensaje:comando-invalido";
        }
        
    }

}

//Error:casillla ocupada
//aceptada: estado, mensaje
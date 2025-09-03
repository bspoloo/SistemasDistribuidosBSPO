/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rayasockettcp;

import rayasockettcp.classes.Jugador;
import rayasockettcp.classes.Tablero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Admin
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    static Jugador jugadorX = new Jugador("X");
    static Jugador jugadorO = new Jugador("O");
    static Tablero tablero = new Tablero(jugadorO, jugadorX);

    public static void main(String[] args) {
        
        String host = "0.0.0.0";
        int port = 5002;
        ServerSocket server;
        try {
            // TODO code application logic here
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            while (true) {
                Socket client;
                PrintStream toClient;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector

                System.out.println("Cliente se unio a la partida");

                String recibido = fromClient.readLine();
                toClient = new PrintStream(client.getOutputStream());
                procesarSolicitud(recibido, toClient);

                //toClient.println("Hola Mundo desde el Servidor");
            }
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public static void procesarSolicitud(String recibido, PrintStream toServerClient) {
        String[] comando = recibido.split(":");
        System.out.println("el comando es" + recibido);
        if (comando[0].equals("iniciar")) {
            tablero.iniciarJuego(toServerClient);
        } else {
            int posicion = Integer.parseInt(recibido.split(":")[1]);
            tablero.setPosicionJugador(posicion);
        }
    }
}

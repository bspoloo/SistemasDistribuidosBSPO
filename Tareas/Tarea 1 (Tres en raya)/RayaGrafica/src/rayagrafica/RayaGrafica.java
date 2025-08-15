/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rayagrafica;

import rayagrafica.classes.Jugador;

import java.text.Normalizer.Form;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class RayaGrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tablero tablero = new Tablero();
        Jugador jugadorX = new Jugador("X");
        Jugador jugadorO = new Jugador("O");
        tablero.setJugadorX(jugadorX);
        tablero.setJugadorO(jugadorO);
        tablero.show();
    }
    
}

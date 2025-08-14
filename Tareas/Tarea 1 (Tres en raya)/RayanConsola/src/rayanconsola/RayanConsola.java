/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rayanconsola;

import rayanconsola.classes.Jugador;
import rayanconsola.classes.Tablero;

/**
 *
 * @author Admin
 */
public class RayanConsola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jugador jugadorX = new Jugador("X");
        Jugador jugadorO = new Jugador("O");
        Tablero tablero = new Tablero(jugadorX, jugadorO);
        tablero.iniciarJuego();
    }
}

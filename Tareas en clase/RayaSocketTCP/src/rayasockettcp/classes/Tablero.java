package rayasockettcp.classes;

import rayasockettcp.classes.condiciones.Condicion;
import rayasockettcp.interfaces.ICondicion;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Tablero {
    private Jugador jugadorX;
    private Jugador jugadorO;
    private Jugador jugadorActual;
    private char[][] tablero;
    private CondicionesManager condicionesManger;
    private PrintStream toServerClient;
    private Scanner scanner = new Scanner(System.in);

    public Tablero(Jugador jugadorO, Jugador jugadorX) {
        this.jugadorO = jugadorO;
        this.jugadorX = jugadorX;
        this.condicionesManger = new CondicionesManager();
    }

    public void iniciarTablero() {
        this.tablero = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.tablero[i][j] = '*';
            }
        }
    }

    public Jugador getJugadorActual() {
        return this.jugadorActual;
    }

    public void finalizarJuego() {
        mostrarTablero();
        System.out.println("El jugador " + jugadorActual.getEtiqueta() + " Ha ganado la partida!!!!");
        System.exit(0);
    }

    public void mostrarTablero() {
        if (this.tablero == null || this.tablero[0].length <= 0) {
            this.iniciarTablero();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + this.tablero[i][j] + "|");
            }
            System.out.println(" ");
        }
    }

    public void iniciarJuego(PrintStream toServerClient) {
        this.toServerClient = toServerClient;
        this.setJugadorActual();
        this.mostrarTablero();
        this.cambiarJugador();
        this.mostrarMensaje("Inicio:Ok");
    }

    private void mostrarMensaje(String message) {
        this.toServerClient.println(message);
    }

    public void setPosicionJugador(int posicion) {
        if (posicion <= 0 || posicion > 9) {
            this.mostrarMensaje("Posicion " + posicion + " es equivocada!!");
            return;
        }
        posicion--;
        int contador = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (contador == posicion) {
                    char valor = jugadorActual.getEtiqueta().charAt(0);
                    if (tablero[i][j] != '*') {
                        this.mostrarMensaje("La pocision " + (posicion + 1) + " ya esta ocupada");
                    } else {
                        this.tablero[i][j] = valor;
                        ICondicion condicion = new Condicion(condicionesManger
                                .getPosicionCondicion(posicion + 1)
                        );
                        condicion.verificarCondicion(this);
                        this.cambiarJugador();
                        this.esEmpate();
                    }
                }
                contador++;
            }
        }
    }

    private void cambiarJugador() {
        if (jugadorActual == jugadorX) {
            jugadorActual = jugadorO;
            this.toServerClient.println("Es su turno " + jugadorActual.getEtiqueta());
            return;
        }else {

        jugadorActual = jugadorX;
        System.out.println("Turno del jugador " + jugadorActual.getEtiqueta());
        int posicion = scanner.nextInt();
        this.setPosicionJugador(posicion);
        }

    }

    private void setJugadorActual() {
        Random rand = new Random();
        int jugador = rand.nextInt(2);
        if (jugador == 1) {
            jugadorActual = jugadorX;
            return;
        }
        jugadorActual = jugadorO;
    }

    public char getValorPoscion(int posicion) {
        posicion--;
        int contador = 0;
        char valor = ' ';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (posicion == contador) {
                    valor = this.tablero[i][j];
                }
                contador++;
            }
        }
        return valor;
    }

    private void esEmpate() {
        int contadorVacio = 0;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != '*') {
                    contadorVacio++;
                }
            }
        }
        int casillas = tablero.length * tablero[0].length;
        if (contadorVacio >= (casillas)) {
            System.out.println("Es empate!!!");
            System.exit(0);
        }
    }

    public char getValor(int i, int j) {
        return this.tablero[i][j];
    }
}

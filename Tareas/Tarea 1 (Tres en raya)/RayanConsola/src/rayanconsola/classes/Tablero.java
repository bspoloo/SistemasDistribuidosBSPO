package rayanconsola.classes;

import rayanconsola.classes.condicones.Condicion;
import rayanconsola.interfaces.ICondicion;

import java.util.Random;
import java.util.Scanner;

public class Tablero {
    private Jugador jugadorX;
    private Jugador jugadorO;
    private Jugador jugadorActual;
    private char[][] tablero;
    private CondicionesManger condicionesManger;

    public Tablero(Jugador jugadorO, Jugador jugadorX) {
        this.jugadorO = jugadorO;
        this.jugadorX = jugadorX;
        this.condicionesManger = new CondicionesManger();
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

    public void iniciarJuego() {
        this.setJugadorActual();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                boolean esValido = false;
                while (esValido == false) {
                    this.mostrarTablero();
                    System.out.println("Turno del jugador " + jugadorActual.getEtiqueta());
                    System.out.print("Seleccione la posicion a insertar: ");
                    int posicion = scanner.nextInt();
                    esValido = this.setPosicionJugador(posicion);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private boolean setPosicionJugador(int posicion) {
        if (posicion <= 0 || posicion > 9) {
            System.out.println("Posicion " + posicion + " es equivocada!!");
            return false;
        }
        posicion--;
        int contador = 0;
        boolean isValid = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (contador == posicion) {
                    char valor = jugadorActual.getEtiqueta().charAt(0);
                    if (tablero[i][j] != '*') {
                        System.out.println("La pocision " + (posicion + 1) + " ya esta ocupada");
                    } else {
                        this.tablero[i][j] = valor;
                        ICondicion condicion = new Condicion(condicionesManger
                                .getPosicionCondicion(posicion + 1)
                        );
                        condicion.verificarCondicion(this);
                        this.cambiarJugador();
                        isValid = true;
                    }
                }
                contador++;
            }
        }
        return isValid;
    }

    private void cambiarJugador() {
        if (jugadorActual == jugadorX) {
            jugadorActual = jugadorO;
            return;
        }
        jugadorActual = jugadorX;
    }

    private void setJugadorActual() {
        Random rand = new Random();
        int jugador = rand.nextInt(1);
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
    public char getValor(int i, int j){
        return this.tablero[i][j];
    }
}

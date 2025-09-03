package rayasockettcp.classes.condiciones;

import rayasockettcp.classes.Tablero;
import rayasockettcp.interfaces.ICondicion;

public class Condicion implements ICondicion {
    private int[][] posicion;

    public Condicion(int[][] posicion) {
        this.posicion = posicion;
    }

    @Override
    public void verificarCondicion(Tablero tablero) {
        int contadorCorrectos = 0;

        for (int[] ints : this.posicion) {
            for (int j = 0; j < this.posicion[0].length; j++) {
                char valor = tablero.getValorPoscion(ints[j]);
                char etiqueta = tablero.getJugadorActual().getEtiqueta().charAt(0);
                if (valor == etiqueta) {
                    contadorCorrectos++;
                }
                if (contadorCorrectos == 3) {
                    tablero.finalizarJuego();
                }
            }
            contadorCorrectos = 0;
        }
    }
}

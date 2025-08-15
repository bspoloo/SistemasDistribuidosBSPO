package rayagrafica.classes.condicion;

import rayagrafica.Tablero;
import rayagrafica.interfaces.ICondicion;

import java.util.Objects;

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
                String valor = tablero.getValorPoscion(ints[j]);
                String etiqueta = tablero.getJugadorActual().getEtiqueta();
                if (Objects.equals(valor, etiqueta)) {
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

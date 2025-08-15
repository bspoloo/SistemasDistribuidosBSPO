package rayagrafica.classes;

import java.util.HashMap;

public class CondicionesManger {
    HashMap<Integer, int[][]> posiciones = new HashMap<>();
    public CondicionesManger() {
        posiciones.put(1, new int[][]{
                {1, 2, 3},
                {1, 4, 5},
                {1, 4, 7}
        });
        posiciones.put(2, new int[][]{
                {1, 2, 3},
                {2, 5, 8},
        });
        posiciones.put(3, new int[][]{
                {3, 2, 1},
                {3, 5, 7},
                {3, 6, 9}
        });
        posiciones.put(4, new int[][]{
                {4, 7, 1},
                {4, 5, 6},
        });
        posiciones.put(5, new int[][]{
                {5, 9, 1},
                {5, 7, 3},
                {5, 6, 4},
                {5, 8, 2},
        });
        posiciones.put(6, new int[][]{
                {6, 5, 4},
                {6, 9, 3},
        });
        posiciones.put(7, new int[][]{
                {7, 4, 1},
                {7, 8, 9},
                {7, 5, 3},
        });
        posiciones.put(8, new int[][]{
                {8, 9, 7},
                {8, 5, 2},
        });
        posiciones.put(9, new int[][]{
                {9, 6, 3},
                {9, 8, 7},
                {9, 5, 1},
        });
    }

    public int[][] getPosicionCondicion(Integer key) {
        int[][] posiciones = this.posiciones.get(key);
        if (posiciones == null) {
            return new int[0][0];
        }
        return posiciones;
    }
}

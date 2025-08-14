package rayanconsola.classes;

public class Jugador {
    private String etiqueta;
    private int intentos;
    public Jugador(String etiqueta){
        this.etiqueta = etiqueta;
    }
    public String getEtiqueta() { return  this.etiqueta; }
    public int getIntentos() {return  this.intentos; }
    public void aumentarIntento(int intento) {
        this.intentos += intento;
    }
}

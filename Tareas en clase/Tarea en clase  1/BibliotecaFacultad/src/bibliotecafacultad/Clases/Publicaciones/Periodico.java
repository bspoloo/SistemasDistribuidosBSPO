package bibliotecafacultad.Clases.Publicaciones;

import java.util.List;

public class Periodico extends Publicacion{
    private String fecha;
    private List<String> suplementos;

    public Periodico(String nombre) {
        super(nombre);
    }
    public String getFecha() { return  this.fecha;}
    public void setFecha(String fecha) {this.fecha = fecha; }
}

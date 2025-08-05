package bibliotecafacultad.Clases.Publicaciones;

public class Libro extends Publicacion{
    private String autor;
    private String editorial;
    private int año;

    public Libro(String nombre, String autor, String editorial, int año) {
        super(nombre);
    }
//    public String getNombre() {return nombre;}
    public String getAutor() {return autor;}
    public String getEditorial() {return editorial;}
    public int getAño() {return año;}

//    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setAutor(String autor) {this.autor = autor; }
    public void setEditorial(String editorial) {this.editorial = editorial; }
    public void setAño(int año) {this.año = año; }
}

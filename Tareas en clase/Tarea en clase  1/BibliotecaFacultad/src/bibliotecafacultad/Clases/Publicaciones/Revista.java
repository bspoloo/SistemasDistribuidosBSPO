package bibliotecafacultad.Clases.Publicaciones;

public class Revista extends Publicacion{
    private String mes;
    private int año;
    private PeriodicoEnum tipo;
    public Revista(String nombre) {
        super(nombre);
    }

    public String getMes() { return  mes;}
    public int getAño() {return año; }
    public PeriodicoEnum getTipo() {return tipo; }

    public void setMes(String mes) { this.mes = mes;}
    public void setAño(int año) { this.año = año;}
    public void setTipo(PeriodicoEnum tipo) {this.tipo = tipo; }
}

package bibliotecafacultad.Clases.Armarios;

import bibliotecafacultad.Clases.Publicaciones.Publicacion;

import java.util.List;

public class Armario {
    private String codigo;
    private ArmarioEnum tipo;
    private int bibliotecaId;
    private List<Publicacion> publicaciones;
    public Armario(){}
    public Armario(String codigo, ArmarioEnum tipo, int bibliotecaId){
        this.codigo = codigo;
        this.tipo = tipo;
        this.bibliotecaId = bibliotecaId;
    }

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public String getCodigo(){ return this.codigo; }
    public ArmarioEnum getTipo() { return  this.tipo; }
    public void setTipo(ArmarioEnum tipo) {this.tipo = tipo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public void añadirPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }
}

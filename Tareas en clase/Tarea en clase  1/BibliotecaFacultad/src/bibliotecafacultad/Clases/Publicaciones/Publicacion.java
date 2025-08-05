package bibliotecafacultad.Clases.Publicaciones;

public class Publicacion {
    private int id;
    protected String nombre;
    private String armarioCodigo;

    public Publicacion() {}
    public Publicacion(int id,String nombre, String armarioCodigo){
        this.id = id;
        this.armarioCodigo = armarioCodigo;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() { return this.nombre; }
    public void setNombre(String nombre) {this.nombre = nombre; }
    public String getArmarioCodigo() {return armarioCodigo; }

    public void setArmarioCodigo(String armarioCodigo) {
        this.armarioCodigo = armarioCodigo;
    }
}

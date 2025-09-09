package practica3.rmi.sockets.classes;


import java.io.Serializable;

public class Diploma implements Serializable {
    private String nombreCompleto;
    private String carrera;
    private String fecha;
    private String mensaje;

    public Diploma(String nombreCompleto, String carrera, String fecha, String mensaje) {
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getCarrera() {
        return carrera;
    }
    public String getFecha() {
        return fecha;
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

package practica3.rmi.sockets.classes;


import java.io.Serializable;

public class RespuestaSEGIP implements Serializable {
    private boolean estado;
    private String mensaje;

    public RespuestaSEGIP(boolean estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public boolean isEstado() {
        return estado;
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

package rayasockettcp.classes;

public class Mensaje {
    private String mensaje;
    private String protocolo;

    public Mensaje(String protocolo, String mensaje) {
        this.protocolo = protocolo;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getProtocolo() {
        return protocolo;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.java.classes;

/**
 *
 * @author Animetx
 */
public class Session {

    private String mensaje;
    private String token;
    private String type;
    private Integer expires;
    private User user;
    private String data;

    public Session() {}
    public Session(String data) {
        this.data = data;
        this.mensaje = this.data.split("\"mensaje\":\"")[1].split("\"")[0];
        this.token = this.data.split("\"token\":\"")[1].split("\"")[0];
        this.type = this.data.split("\"type\":\"")[1].split("\"")[0];
        this.expires = Integer.parseInt(this.data.split("\"expires\":\"")[1].split("\"")[0]);
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getExpires() {
        return expires;
    }

    public void setExpires(Integer expires) {
        this.expires = expires;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

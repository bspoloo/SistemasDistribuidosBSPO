/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.java.classes;

/**
 *
 * @author Animetx
 */
public class User {

    private int id;
    private String name;
    private String email;
    private String data;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public User(String data) {
        this.data = data;
        String usuarioBlock = data.split("\"usuario\":\\{")[1].split("}")[0];
        this.id = Integer.parseInt(usuarioBlock.split("\"id\":")[1].split(",")[0]);
        this.name = usuarioBlock.split("\"name\":\"")[1].split("\"")[0];
        this.email = usuarioBlock.split("\"email\":\"")[1].split("\"")[0];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

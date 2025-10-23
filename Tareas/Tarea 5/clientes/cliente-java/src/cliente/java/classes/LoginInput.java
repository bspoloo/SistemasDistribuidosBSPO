/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.java.classes;

public class LoginInput {

    private String email;
    private String password;

    public LoginInput(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Retorna un JSON con los valores de email y password
    public String getBodyText() {
        return "{ \"email\": \"" + this.email + "\", \"password\": \"" + this.password + "\" }";
    }

    // Getters y setters opcionales
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.java.classes.services;

import static cliente.java.Main.session;
import cliente.java.classes.JSON;
import cliente.java.classes.LoginInput;
import cliente.java.classes.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Animetx
 */
public class LoginService {

    private String baseUrl;

    public LoginService(String baseUrl) throws MalformedURLException, IOException {
        this.baseUrl = baseUrl;
    }

    public String Authenticate(String email, String password) {
        try {
            URL url = new URL(this.baseUrl+"/login");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println("Inice session por favor");
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            LoginInput loginInput = new LoginInput(email, password);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = loginInput.getBodyText().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("HTTP Status: " + code);

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;

                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                br.close();

                User user = new User(response.toString());
                JSON json = new JSON(response.toString());

                session.setMensaje(json.<String>getDataType("mensaje"));
                session.setToken(json.<String>getDataType("token"));
                session.setType(json.<String>getDataType("type"));
                session.setExpires(Integer.parseInt(json.<String>getDataType("expires")));
                session.setUser(user);
            }
            return session.getMensaje();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}

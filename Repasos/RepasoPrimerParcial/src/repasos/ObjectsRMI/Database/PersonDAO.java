/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasos.ObjectsRMI.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import repasos.ObjectsRMI.classes.Person;
import repasos.ObjectsRMI.enums.Sexo;

/**
 *
 * @author Animetx
 */
public class PersonDAO {

    private Connection connection;

    public PersonDAO(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean insert(Person person) {
        String sql = "INSERT INTO persons(nombres, apellidos, numero_document, sexo) VALUES(?,?,?,?)";
        //boolean aux = false;
        try {
            PreparedStatement instruction = this.connection.prepareStatement(sql);
            instruction.setString(1, person.getNombres());
            instruction.setString(2, person.getApellidos());
            instruction.setInt(3, person.getNumero_documento());
            instruction.setString(4, String.valueOf(person.getSexo()));
            //aux = true;
            return instruction.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        //return aux;
    }

    public boolean update(Person person) {
        String sql = "UPDATE persons SET nombres=?, apellidos=?, numero_documento=?, sexo=? WHERE id=?";
        try {
            PreparedStatement instruction = this.connection.prepareStatement(sql);
            instruction.setString(1, person.getNombres());
            instruction.setString(2, person.getApellidos());
            instruction.setInt(3, person.getNumero_documento());
            instruction.setString(4, String.valueOf(person.getSexo()));
            instruction.setInt(5, person.getId());
            instruction.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteById(int id) {
        String sql = "DELETE FROM persons WHERE id=?";
        try {
            PreparedStatement instruction = this.connection.prepareStatement(sql);
            instruction.setInt(1, id);
            instruction.executeUpdate();
            //instruction.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Person getById(int id) {
        String sql = "SELECT * from persons WHERE id=?";
        try {
            PreparedStatement instruction = this.connection.prepareStatement(sql);
            instruction.setInt(1, id);
            ResultSet result = instruction.executeQuery();
            Person person = new Person(
                    result.getInt("id"),
                    result.getString("nombres"),
                    result.getString("apellidos"),
                    result.getInt("numero_documento"),
                    Sexo.valueOf(result.getString("sexo"))
            );
            return person;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Person> getAll() {
        String sql = "SELECT * from persons";
        List<Person> aux = new ArrayList<Person>();
        try {
            PreparedStatement instruction = this.connection.prepareStatement(sql);
            ResultSet result = instruction.executeQuery();
            while (result.next()) {
                Person person = new Person(
                        result.getInt("id"),
                        result.getString("nombres"),
                        result.getString("apellidos"),
                        result.getInt("numero_documento"),
                        Sexo.valueOf(result.getString("sexo"))
                );
                aux.add(person);
            }
            return aux;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return aux;
        }
    }
}

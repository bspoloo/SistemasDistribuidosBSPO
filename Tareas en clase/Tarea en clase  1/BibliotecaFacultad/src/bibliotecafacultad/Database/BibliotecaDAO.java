package bibliotecafacultad.Database;
import bibliotecafacultad.Clases.Armarios.Armario;
import bibliotecafacultad.Clases.Armarios.ArmarioEnum;
import bibliotecafacultad.Clases.Biblioteca.Biblioteca;
import bibliotecafacultad.Clases.Publicaciones.Publicacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaDAO {
    private Connection conexion;

    public BibliotecaDAO(String url, String usuario, String password) {
        try{
            this.conexion = DriverManager.getConnection(url, usuario, password);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void insertarBiblioteca(Biblioteca biblioteca) {
        String sql = "INSERT INTO BIBLIOTECA(NOMBRE, TAMAÑO) VALUES (?,?)";
        try{
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, biblioteca.getNombre());
            instruccion.setString(2, String.valueOf(biblioteca.getTamaño()));
            instruccion.execute();
        }catch (SQLException e){
            System.out.print(e.getMessage());
        }
    }

    public void insertarPublicacion(Publicacion publicacion){
        String sql = "INSERT INTO PUBLICACION(NOMBRE, ARMARIO_CODIGO) VALUES (?,?)";
        try{
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, publicacion.getNombre());
            instruccion.setString(2, publicacion.getArmarioCodigo());
            instruccion.execute();
        }catch (SQLException e){
            System.out.print(e.getMessage());
        }
    }

    public void insertarArmario(Armario armario){
        String sql = "INSERT INTO ARMARIO(CODIGO, TIPO, BIBLIOTECA_ID) VALUES (?,?,?)";
        try{
            PreparedStatement instruccion = conexion.prepareStatement(sql);
            instruccion.setString(1, armario.getCodigo());
            instruccion.setString(2, String.valueOf((armario.getTipo())).toUpperCase());
            instruccion.setInt(3, armario.getBibliotecaId());
            instruccion.execute();
        }catch (SQLException e){
            System.out.print(e.getMessage());
        }
    }

    public List<Biblioteca> listarBilbliotecas() {
        List<Biblioteca> bibliotecas = new ArrayList<Biblioteca>();
        String sql = "SELECT * FROM biblioteca";
        try{
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                Biblioteca biblioteca = new Biblioteca(
                        resultado.getInt("ID"),
                        resultado.getString("NOMBRE"),
                        resultado.getFloat("TAMAÑO")
                        );
                bibliotecas.add(biblioteca);
            }
        }catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return bibliotecas;
    }

    public List<Publicacion> listarPublicaciones() {
        List<Publicacion> publicaciones = new ArrayList<Publicacion>();
        String sql = "SELECT * FROM publicacion";
        try{
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                Publicacion publicacion = new Publicacion(
                        resultado.getInt("ID"),
                        resultado.getString("NOMBRE"),
                        resultado.getString("ARMARIO_CODIGO")
                );
                publicaciones.add(publicacion);
            }
        }catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return publicaciones;
    }

    public List<Armario> listarArmarios() {
        List<Armario> armarios = new ArrayList<Armario>();
        String sql = "SELECT * FROM biblioteca";
        try{
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                Armario armario = new Armario(
                        resultado.getString("CODIGO"),
                        ArmarioEnum.valueOf(resultado.getString("TIPO")),
                        resultado.getInt("BIBLIOTECA_ID")
                );
                armarios.add(armario);
            }
        }catch (SQLException e){
            System.out.print(e.getMessage());
        }
        return armarios;
    }
}

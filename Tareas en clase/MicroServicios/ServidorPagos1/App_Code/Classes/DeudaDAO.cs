using MySql.Data.MySqlClient;
using Mysqlx.Cursor;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;


/// <summary>
/// Summary description for DeudaDAO
/// </summary>
public class DeudaDAO
{
    private MySqlConnection connection;

    public DeudaDAO(String ConnectionString)
    {
        this.connection = new MySqlConnection(ConnectionString);
    }

    public List<Deuda> GetAllDeudas(String Ci, String PrimerApellido, String SegundoApellido, String Nombres)
    {
        try
        {
            Deuda deuda = null;
            connection.Open();
            String query = "SELECT * FROM deudas WHERE ci = @Ci AND primer_apellido=@PrimerApellido AND segundo_apellido=@SegundoApellido AND nombres=@Nombres";
            MySqlCommand cmd = new MySqlCommand(query, connection);
            cmd.Parameters.AddWithValue("@ci", Ci);
            cmd.Parameters.AddWithValue("@PrimerApellido", PrimerApellido);
            cmd.Parameters.AddWithValue("@SegundoApellido", SegundoApellido);
            cmd.Parameters.AddWithValue("@Nombres", Nombres);

            List<Deuda> deudas = new List<Deuda>();

            using (MySqlDataReader reader = cmd.ExecuteReader())
            {
                while (reader.Read())
                {
                    deudas.Add(new Deuda
                    {
                        Id=reader.GetInt16("id"),
                        Ci=reader.GetString("ci"),
                        PrimerApellido=reader.GetString("primer_apellido"),
                        SegundoApellido=reader.GetString("segundo_apellido"),
                        Nombres=reader.GetString("nombres"),
                        Monto=reader.GetFloat("monto")
                    });
                }
            }
           
            return deudas;
        }
        catch (Exception ex)
        {
            throw new Exception("Error al obtener deudas: " + ex.Message);
        }
    }
    public Factura PagarDeuda(Deuda deuda)
    {
        return null;
    }
}
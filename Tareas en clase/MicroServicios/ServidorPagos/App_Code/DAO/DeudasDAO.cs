using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de DeudasDAO
/// </summary>
public class DeudasDAO
{
    private MySqlConnection connection;
    public DeudasDAO(String ConnectionString)
    {
        this.connection = new MySqlConnection(ConnectionString);
    }

    public List<Deuda> VerDeuda(String CI, String Nombres, String PrimerApellido, String SegundoApellido)
    {
        try
        {
            connection.Open();
            String query = "select * from deuda where ci=@CI and primer_apellido=@PrimerApellido and segundo_apellido=@SegundoApellido and nombres=@Nombres";
            MySqlCommand cmd = new MySqlCommand(query, connection);

            cmd.Parameters.AddWithValue("@CI", CI);
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
                        Id = reader.GetInt16("id"),
                        CI = reader.GetString("ci"),
                        Nombres = reader.GetString("nombres"),
                        PrimerApellido = reader.GetString("primer_apellido"),
                        SegundoApellido = reader.GetString("segundo_apellido"),
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
}
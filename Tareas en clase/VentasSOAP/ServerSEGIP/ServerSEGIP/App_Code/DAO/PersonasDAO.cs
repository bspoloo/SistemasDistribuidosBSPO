using MySql.Data.MySqlClient;
using System;
using System.Activities.Expressions;
using System.Activities.Statements;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;


/// <summary>
/// Summary description for PersonasDAO
/// </summary>
public class PersonasDAO
{
    private MySqlConnection connection;

    public PersonasDAO(String ConnectionString)
    {
        this.connection = new MySqlConnection(ConnectionString);
    }

    public Persona GetPersonaByCI(String CI)
    {
        try
        {
            Persona persona = null;
            connection.Open();
            String query = "SELECT * FROM personas WHERE ci = @CI";
            MySqlCommand cmd = new MySqlCommand(query, connection);
            cmd.Parameters.AddWithValue("@CI", CI);

            using (MySqlDataReader reader = cmd.ExecuteReader())
            {
                if (reader.Read())
                {
                    persona = new Persona
                    {
                        id = reader.GetInt16("id"),
                        ci = reader.GetString("ci"),
                        nombres = reader.GetString("nombres"),
                        primerApellido = reader.GetString("primer_apellido"),
                        segundoApellido = reader.GetString("segundo_apellido"),
                    };
                }
            }
            if (persona == null)
            {
                throw new Exception("Persona no existente con ci: " + CI);
            }
            return persona;
        }
        catch (Exception ex)
        {
            throw new Exception("Error al obtener persona: " + ex.Message);
        }
    }

    public List<Persona> getAllPersonas(String PrimerApellido, String SegundoApellido, String Nombres)
    {
        try
        {
            List<Persona> personas = new List<Persona>();
            connection.Open();

            List<string> conditions = new List<string>();
            MySqlCommand cmd = new MySqlCommand();
            cmd.Connection = connection;

            if (!string.IsNullOrEmpty(Nombres))
            {
                conditions.Add("nombres LIKE @Nombres");
                cmd.Parameters.AddWithValue("@Nombres", "%" + Nombres + "%");
            }

            if (!string.IsNullOrEmpty(PrimerApellido))
            {
                conditions.Add("primer_apellido LIKE @PrimerApellido");
                cmd.Parameters.AddWithValue("@PrimerApellido", "%" + PrimerApellido + "%");
            }

            if (!string.IsNullOrEmpty(SegundoApellido))
            {
                conditions.Add("segundo_apellido LIKE @SegundoApellido");
                cmd.Parameters.AddWithValue("@SegundoApellido", "%" + SegundoApellido + "%");
            }

            string whereClause = conditions.Count > 0 ? "WHERE " + string.Join(" OR ", conditions) : "";
            cmd.CommandText = "SELECT * FROM personas " + whereClause;

            using (MySqlDataReader reader = cmd.ExecuteReader())
            {
                while (reader.Read())
                {
                    personas.Add(new Persona
                    {
                        id = reader.GetInt16("id"),
                        ci = reader.GetString("ci"),
                        nombres = reader.GetString("nombres"),
                        primerApellido = reader.GetString("primer_apellido"),
                        segundoApellido = reader.GetString("segundo_apellido"),
                    });
                }
            }
            return personas;
        }
        catch (Exception ex)
        {
            throw new Exception("Error al obtener personas: " + ex.Message);
        }
    }
}
using MySql.Data.MySqlClient;
using Mysqlx.Cursor;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for CotizacionDAO
/// </summary>
public class CotizacionDAO
{
    private MySqlConnection connection;
    public CotizacionDAO(String ConnectionString)
    {
        this.connection = new MySqlConnection(ConnectionString);
    }
    public Cotizacion GetCotizacionByFecha(String fecha)
    {
        try
        {
            Cotizacion cotizacion = null;
            connection.Open();
            String query = "SELECT * FROM cotizaciones WHERE fecha = @fecha";
            MySqlCommand cmd = new MySqlCommand(query, connection);
            cmd.Parameters.AddWithValue("@fecha", fecha);

            using (MySqlDataReader reader = cmd.ExecuteReader())
            {
                if (reader.Read())
                {
                    cotizacion = new Cotizacion
                    {
                        Fecha = reader.GetDateTime("fecha"),
                        CotizacionActual = reader.GetFloat("cotizacion"),
                        CotizacionOficial = reader.GetFloat("cotizacion_oficial")
                    };
                }
            }
            if(cotizacion == null)
            {
                throw new Exception("Cotizacion no existente con fecha: "+fecha);
            }
            return cotizacion;
        }
        catch (Exception ex)
        {
            throw new Exception("Error al obtener cotización: " + ex.Message);
        }
    }

    public List<Cotizacion> getAllCotizaciones()
    {
        try
        {
            List<Cotizacion> cotizaciones = new List<Cotizacion>();
            connection.Open();
            string query = "SELECT * FROM cotizaciones";
            MySqlCommand cmd = new MySqlCommand(query, connection);
            using (MySqlDataReader reader = cmd.ExecuteReader())
            {
                while (reader.Read())
                {
                    cotizaciones.Add(new Cotizacion
                    {
                        Fecha = reader.GetDateTime("fecha"),
                        CotizacionActual = reader.GetFloat("cotizacion"),
                        CotizacionOficial = reader.GetFloat("cotizacion_oficial")
                    });
                }
            }
            return cotizaciones;
        }
        catch(Exception ex)
        {
            throw new Exception("Error al obtener cotización: " + ex.Message);
        }
    }
    public bool createCotizacion(Cotizacion cotizacion)
    {
        try
        {
            connection.Open();
            String query = "INSERT INTO cotizaciones (fecha, cotizacion, cotizacion_oficial) VALUES (@fecha, @cotizacion, @cotizacion_oficial)";
            MySqlCommand cmd = new MySqlCommand(query, connection);
            cmd.Parameters.AddWithValue("@fecha", cotizacion.Fecha);
            cmd.Parameters.AddWithValue("@cotizacion", cotizacion.CotizacionActual);
            cmd.Parameters.AddWithValue("@cotizacion_oficial", cotizacion.CotizacionOficial);

            return cmd.ExecuteNonQuery() > 0 ? true : false;
        }
        catch (Exception ex)
        {
            // En caso de error, puedes registrar el error o lanzar una excepción
            throw new Exception("Error al obtener cotización: " + ex.Message);
            //return false;
        }
    }
}
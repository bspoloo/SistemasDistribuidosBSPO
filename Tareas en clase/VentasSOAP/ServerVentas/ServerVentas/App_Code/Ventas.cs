using MySql.Data.MySqlClient;
using Mysqlx.Cursor;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Summary description for Ventas
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class Ventas : System.Web.Services.WebService
{   
    private MySqlConnection connection;
    private String ConnectionString = ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString;
    public Ventas()
    {
        this.connection = new MySqlConnection(this.ConnectionString);
    }

    [WebMethod]
    public Cotizacion ObtenerCotizacion(String fecha)
    {
        Cotizacion cotizacion = null;
        try
        {
            connection.Open();
            String query = "SELECT * FROM cotizaciones WHERE fecha = @fecha";
            MySqlCommand cmd = new MySqlCommand(query, connection);
            cmd.Parameters.AddWithValue("@fecha", fecha);
            using(MySqlDataReader reader = cmd.ExecuteReader() )
            {
                if(reader.Read())
                {
                    cotizacion = new Cotizacion
                    {
                        Fecha = reader.GetDateTime("fecha"),
                        CotizacionActual = reader.GetFloat("cotizacion"),
                        CotizacionOficial = reader.GetFloat("cotizacion_oficial")
                    };
                }
            }
        }
        catch(Exception ex)
        {
            // En caso de error, puedes registrar el error o lanzar una excepción
            throw new Exception("Error al obtener cotización: " + ex.Message);
        }
        return cotizacion;
    }

    [WebMethod]
    public List<Cotizacion> ObtenerCotizaciones()
    {
        List<Cotizacion> cotizaciones = new List<Cotizacion>();
        using (MySqlConnection connection = new MySqlConnection(this.ConnectionString))
        {
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
        }
        return cotizaciones;
    }
    [WebMethod]
    public List<Cotizacion> RegistrarCotizaciones(DateTime Fecha, float Cotizacion, float CotizacionOficial)
    {
        List<Cotizacion> cotizaciones = new List<Cotizacion>();

        try
        {
            connection.Open();
            
            String query = "INSERT INTO cotizaciones (fecha, cotizacion, cotizacion_oficial) VALUES (@fecha, @cotizacion, @cotizacion_oficial)";
            MySqlCommand cmd = new MySqlCommand(query, connection);
            cmd.Parameters.AddWithValue("@fecha", Fecha);
            cmd.Parameters.AddWithValue("@cotizacion", Cotizacion);
            cmd.Parameters.AddWithValue("@cotizacion_oficial", CotizacionOficial);
            cmd.ExecuteNonQuery();
            cotizaciones = this.ObtenerCotizaciones();
        }
        catch (Exception ex)
        {
            // En caso de error, puedes registrar el error o lanzar una excepción
            throw new Exception("Error al obtener cotización: " + ex.Message);
        }
        return cotizaciones;
    }
}

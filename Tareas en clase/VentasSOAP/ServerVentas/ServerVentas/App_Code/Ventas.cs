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
    private CotizacionDAO cotizacionDAO;
    public Ventas()
    {
        this.cotizacionDAO = new CotizacionDAO(ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString);
    }

    [WebMethod]
    public CotizacionOutDTO<Cotizacion> ObtenerCotizacionByFecha(String fecha)
    {
        try
        {
            Cotizacion cotizacion = this.cotizacionDAO.GetCotizacionByFecha(fecha);
            return new CotizacionOutDTO<Cotizacion>(
                "Cotizacion traida correctamente",
                200,
                cotizacion
            );
        }catch(Exception ex)
        {
            return new CotizacionOutDTO<Cotizacion>(
                "Error en traer cotizacion: "+ex.Message,
                404,
                null
             );
        }
    }

    [WebMethod]
    public CotizacionOutDTO<List<Cotizacion>> ObtenerCotizaciones()
    {
        try
        {
            List<Cotizacion> cotizaciones = this.cotizacionDAO.getAllCotizaciones();
            return new CotizacionOutDTO<List<Cotizacion>>(
                "Cotizaciones traidos correctamente",
                200,
                cotizaciones
            );
        }
        catch (Exception ex)
        {
            return new CotizacionOutDTO<List<Cotizacion>>(
                "Error en traer cotizaciones " + ex.Message,
                404,
                null
             );
        }
    }

    [WebMethod]
    public CotizacionOutDTO<bool> RegistrarCotizaciones(DateTime fecha, float cotizacion, float cotizacionOficial)
    {
        try
        {
            Cotizacion cotizacionCreate = new Cotizacion
            {
                Fecha = fecha,
                CotizacionActual = cotizacion,
                CotizacionOficial = cotizacionOficial,
            };
            bool result = this.cotizacionDAO.createCotizacion(cotizacionCreate);
            return new CotizacionOutDTO<bool>(
                "Cotizacion creada correctamente",
                200,
                result
            );
        }
        catch (Exception ex)
        {
            return new CotizacionOutDTO<bool>(
                "Error en crear cotizacion: " + ex.Message,
                404,
                false
             );
        }
    }
}

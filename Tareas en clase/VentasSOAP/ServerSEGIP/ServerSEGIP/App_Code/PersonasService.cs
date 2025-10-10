using Mysqlx.Cursor;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Summary description for PersonasService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class PersonasService : System.Web.Services.WebService
{
    private PersonasDAO personasDAO;
    public PersonasService()
    {
        this.personasDAO = new PersonasDAO((ConfigurationManager.ConnectionStrings["MysqlConnection"].ConnectionString));
    }

    [WebMethod]
    public ResponseDTO<Persona> BuscarPersonaCI(String numeroDocumento)
    {
        try
        {
            Persona persona = this.personasDAO.GetPersonaByCI(numeroDocumento);
            return new ResponseDTO<Persona>(
                "Persona traida correctamente",
                200,
                persona
            );
        }
        catch (Exception ex)
        {
            return new ResponseDTO<Persona>(
                "Error en traer persona: " + ex.Message,
                404,
                null
             );
        }
    }
    [WebMethod]
    public ResponseDTO<List<Persona>> BuscarPersonas(String PrimerApellido, String SegundoApellido, String Nombres)
    {
        try
        {
            List<Persona> personas = this.personasDAO.getAllPersonas(PrimerApellido, SegundoApellido, Nombres);
            return new ResponseDTO<List<Persona>>(
                "Persona traida correctamente",
                200,
                personas
            );
        }
        catch (Exception ex)
        {
            return new ResponseDTO<List<Persona>>(
                "Error en traer personas: " + ex.Message,
                404,
                null
             );
        }
    }
}

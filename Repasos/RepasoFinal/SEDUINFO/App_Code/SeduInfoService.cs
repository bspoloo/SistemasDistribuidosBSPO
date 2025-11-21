using System;
using System.Activities.Expressions;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de SeduInfoService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class SeduInfoService : System.Web.Services.WebService
{
    private EstudiantesDao estudiantesDao;
    public SeduInfoService()
    {
        this.estudiantesDao = new EstudiantesDao();
    }

    [WebMethod]
    public Response<Estudiante> ObtenerDatosAcademicos(String CI)
    {
        Estudiante estudiante = this.estudiantesDao.ObtenerDatosAcademicos(CI);
        if (estudiante != null)
        {
            return new Response<Estudiante>()
            {
                Message = "Estudiante traido correctamente con CI: "+CI,
                Status = 200,
                Data = estudiante,
            };
        }
        else
        {
            return new Response<Estudiante>()
            {
                Message = "No existe ese estudiante con CI: "+CI,
                Status = 404,
                Data = null,
            };
        }
    }
    [WebMethod]
    public Response<Tutor> ObtenerDatosTutor(String CI)
    {
        Tutor tutor = this.estudiantesDao.ObtenerDatosTutor(CI);
        if (tutor != null)
        {
            return new Response<Tutor>()
            {
                Message = "Estudiante traido correctamente con CI: "+CI,
                Status = 200,
                Data = tutor,
            };
        }
        else
        {
            return new Response<Tutor>()
            {
                Message = "No existe ese estudiante con CI: " + CI,
                Status = 404,
                Data = null,
            };
        }
    }
}

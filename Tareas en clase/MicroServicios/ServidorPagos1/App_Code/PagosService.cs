using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Web;
using System.Web.Services;

/// <summary>
/// Summary description for PagosService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class PagosService : System.Web.Services.WebService
{
    private DeudaDAO deudaDAO;
    public PagosService()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
        this.deudaDAO = new DeudaDAO("Server = localhost; Database = pagos_db; Uid = root; Pwd = root; ");
    }

    [WebMethod]
    public Response<List<Deuda>> VerDeuda(String Ci, String PrimerApellido, String SegundoApellido, String Nombres)
    {
        try
        {
            List<Deuda> deudas = this.deudaDAO.GetAllDeudas(Ci, PrimerApellido, SegundoApellido, Nombres);
            return new Response<List<Deuda>>("Deudas traidas correctamente ",200, deudas);
        }
        catch(Exception e)
        {
            return new Response<List<Deuda>>( "Error en traer deudas "+e.Message, 404, new List<Deuda>());
        }
    }

}

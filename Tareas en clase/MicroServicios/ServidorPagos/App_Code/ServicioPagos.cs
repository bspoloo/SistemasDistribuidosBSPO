using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel.Channels;
using System.Threading.Tasks;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de ServicioPagos
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class ServicioPagos : System.Web.Services.WebService
{
    private DeudasDAO deudaDao;
    private SegipService segipService;
    private CESSAService cessaService;
    private ELAPASSERVICE elapasService;
    public ServicioPagos()
    {
        this.deudaDao = new DeudasDAO("Server = localhost; Database = deudas_db; Uid = root; Pwd = root; ");
        this.segipService = new SegipService();
        this.cessaService = new CESSAService();
        this.elapasService = new ELAPASSERVICE();
    }

    [WebMethod]
    public Response<List<Deuda>> VerDeuda(String CI, String Nombres, String PrimerApellido, String SegundoApellido)
    {
        try
        {
            Persona persona = Task.Run(() => this.segipService.GetPersonaAsync(CI)).GetAwaiter().GetResult();

            if(persona != null)
            {
                List<Deuda> deudas = this.deudaDao.VerDeuda(CI, Nombres, PrimerApellido, SegundoApellido);
                return new Response<List<Deuda>>
                {
                    Message = "Deudas traidas correctamente",
                    Status = 200,
                    Data = deudas
                };
            }else
            {
                return new Response<List<Deuda>>
                {
                    Message = "Persona no encontrada en SEGIP con CI " + CI,
                    Status = 404,
                    Data = new List<Deuda>()
                };
            }
        }
        catch (Exception e)
        {
            return new Response<List<Deuda>>
            {
                Message = "Error en traer las deudas "+e.Message,
                Status = 404,
                Data = new List<Deuda>()
            };
        }
    }

    [WebMethod]
    public Response<List<Factura>> PagarDeuda(String CI, String Nombres, String PrimerApellido, String SegundoApellido, float Monto)
    {
        try
        {
            FacturaDTO NewFactura = new FacturaDTO
            {
                ci = CI,
                nombres = Nombres,
                primer_apellido = PrimerApellido,
                segundo_apellido = SegundoApellido,
                monto=Monto
            };

            List<Factura> facturas = new List<Factura>();
            Factura facturaCessa = Task.Run(() => this.cessaService.CreateFactura(NewFactura)).GetAwaiter().GetResult();
            Factura facturaElapas = Task.Run(() => this.elapasService.CreateFactura(NewFactura)).GetAwaiter().GetResult();

            facturas.Add(facturaCessa);
            facturas.Add(facturaElapas);

            return new Response<List<Factura>>
            {
                Message = "Factura pagada correctamente para "+Nombres,
                Status = 200,
                Data = facturas
            };
        }
        catch (Exception e)
        {
            return new Response<List<Factura>>
            {
                Message = "Error Al pagar deudas " + e.Message,
                Status = 404,
                Data = new List<Factura>()
            };
        }
    }
}

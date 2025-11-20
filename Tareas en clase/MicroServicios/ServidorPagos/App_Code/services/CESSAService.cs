using MySqlX.XDevAPI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Web;

/// <summary>
/// Descripción breve de CESSAService
/// </summary>
public class CESSAService
{
    private HttpClient client = new HttpClient();
    private String baseUrl;
    public CESSAService()
    {
        this.baseUrl = "http://127.0.0.1:8001/api/facturas";
    }
    
    public async Task<Factura> CreateFactura(FacturaDTO factura)
    {
        try
        {
            //client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
            string body = JsonSerializer.Serialize(factura);
            var content = new StringContent(body, Encoding.UTF8, "application/json");

            HttpResponseMessage response = await client.PostAsync(baseUrl, content);
            string responseBody = await response.Content.ReadAsStringAsync();

            Factura responsePersona = JsonSerializer.Deserialize<Factura>(responseBody);
            return responsePersona;
        }
        catch(HttpException e)
        {
            return null;
        }
    }
}
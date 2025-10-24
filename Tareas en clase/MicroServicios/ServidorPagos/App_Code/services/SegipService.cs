using System;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Web;

/// <summary>
/// Descripción breve de SegipService
/// </summary>
public class SegipService
{
    private HttpClient client = new HttpClient();
    private String baseUrl;
    public SegipService()
    {
        this.baseUrl = "http://127.0.0.1:8000/graphql";
    }

    public async Task<Persona> GetPersonaAsync(string CI)
    {
        var query = new
        {
            query = $@"query {{
                persona(ci: ""{CI}"") {{
                    id
                    ci
                    nombres
                    primer_apellido
                    segundo_apellido
                }}
            }}"
        };

        var jsonQuery = JsonSerializer.Serialize(query);
        var content = new StringContent(jsonQuery, Encoding.UTF8, "application/json");

        var response = await client.PostAsync(baseUrl, content);
        response.EnsureSuccessStatusCode();

        String responseString = await response.Content.ReadAsStringAsync();
        GraphQLResponse graphResponse = JsonSerializer.Deserialize<GraphQLResponse>(responseString);

        return graphResponse.Data.Persona;
    }
}
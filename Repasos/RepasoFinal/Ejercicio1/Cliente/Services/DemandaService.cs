using Cliente.Classes;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Web;
using System.Windows.Forms;


namespace Cliente.Services
{
    public class DemandaService
    {
        private HttpClient client;
        private String baseUrl;
        public DemandaService()
        {
            this.baseUrl = "http://127.0.0.1:8000";
            this.client = new HttpClient();
        }
        public async Task<List<Pronostico>> getAllPronosticos()
        {
            try
            {
                //client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
                //string body = JsonSerializer.Serialize(factura);
                //var content = new StringContent(body, Encoding.UTF8, "application/json");
                String url = $"{this.baseUrl}/api/pronosticos";
                HttpResponseMessage response = await client.GetAsync(url);
                string responseBody = await response.Content.ReadAsStringAsync();

                List<Pronostico> pronosticos = JsonSerializer.Deserialize<List<Pronostico>>(responseBody);

                return pronosticos;
            }
            catch (HttpException e)
            {
                MessageBox.Show(
                    $"Mensaje de error {e.Message}", 
                    "Error", 
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }
        public async Task<Pronostico> InsertPronosticosByREST(Pronostico pronostico)
        {
            try
            {
                //client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
                string body = JsonSerializer.Serialize(pronostico);
                var content = new StringContent(body, Encoding.UTF8, "application/json");
                String url = $"{this.baseUrl}/api/pronosticos";
                HttpResponseMessage response = await client.PostAsync(url, content);
                string responseBody = await response.Content.ReadAsStringAsync();

                Pronostico responsePronostico = JsonSerializer.Deserialize<Pronostico>(responseBody);

                return responsePronostico;
            }
            catch (HttpException e)
            {
                MessageBox.Show(
                    $"Mensaje de error {e.Message}",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }
        public async Task<Pronostico> InsertPronosticosByGRAPHQL(Pronostico pronostico)
        {
            try
            {
                var graphQLRequest = new
                {
                    query = $@"mutation {{
                        createPronostico(fecha: ""{pronostico.Fecha.ToString("yyyy-MM-dd")}"", cantidad_estimada: {pronostico.CantidadEstimada}) {{
                            id
                            fecha
                            cantidad_estimada
                        }}
                    }}"
                };

                var jsonQuery = JsonSerializer.Serialize(graphQLRequest);
                var content = new StringContent(jsonQuery, Encoding.UTF8, "application/json");

                var response = await client.PostAsync($"{this.baseUrl}/graphql", content);
                response.EnsureSuccessStatusCode();

                String responseString = await response.Content.ReadAsStringAsync();
                Console.WriteLine(responseString);
                GraphQLResponse<CreatePronosticoData> graphResponse = JsonSerializer.Deserialize<GraphQLResponse<CreatePronosticoData>>(responseString);

                return graphResponse.Data.Pronostico;
            }
            catch (HttpException e)
            {
                MessageBox.Show(
                    $"Mensaje de error {e.Message}",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }
        public async Task<Pronostico> UpdatePronosticosByGRAPHQL(Pronostico pronostico)
        {
            try
            {
                var graphQLRequest = new
                {
                    query = $@"mutation {{
                        updatePronostico(id: {pronostico.Id}, fecha: ""{pronostico.Fecha.ToString("yyyy-MM-dd")}"", cantidad_estimada: {pronostico.CantidadEstimada}) {{
                            id
                            fecha
                            cantidad_estimada
                        }}
                    }}"
                };

                var jsonQuery = JsonSerializer.Serialize(graphQLRequest);
                var content = new StringContent(jsonQuery, Encoding.UTF8, "application/json");

                var response = await client.PostAsync($"{this.baseUrl}/graphql", content);
                response.EnsureSuccessStatusCode();

                String responseString = await response.Content.ReadAsStringAsync();
                Console.WriteLine(responseString);
                GraphQLResponse<UpdatePronosticoData> graphResponse = JsonSerializer.Deserialize<GraphQLResponse<UpdatePronosticoData>>(responseString);

                return graphResponse.Data.Pronostico;
            }
            catch (HttpException e)
            {
                MessageBox.Show(
                    $"Mensaje de error {e.Message}",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }
        public async Task<Pronostico> UpdatePronosticosByREST(Pronostico pronostico)
        {
            try
            {
                //client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
                string body = JsonSerializer.Serialize(pronostico);
                var content = new StringContent(body, Encoding.UTF8, "application/json");
                String url = $"{this.baseUrl}/api/pronosticos/{pronostico.Id}";
                HttpResponseMessage response = await client.PutAsync(url, content);
                string responseBody = await response.Content.ReadAsStringAsync();

                Pronostico responsePronostico = JsonSerializer.Deserialize<Pronostico>(responseBody);

                return responsePronostico;
            }
            catch (HttpException e)
            {
                MessageBox.Show(
                    $"Mensaje de error {e.Message}",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }
    }
}

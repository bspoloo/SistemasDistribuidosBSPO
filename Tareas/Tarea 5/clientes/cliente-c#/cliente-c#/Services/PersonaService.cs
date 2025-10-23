using cliente_c_.classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.ListView;

namespace cliente_c_.Services
{
    public class PersonaService
    {
        private HttpClient client = new HttpClient();
        private String baseUrl;

        public PersonaService(String baseURL)
        {
            this.baseUrl = baseURL;
        }

        public async Task<List<Persona>> getAllPersonas()
        {
            try
            {
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
                HttpResponseMessage response = await client.GetAsync(this.baseUrl);
                response.EnsureSuccessStatusCode();

                string responseBody = await response.Content.ReadAsStringAsync();

                List<Persona> personas = JsonSerializer.Deserialize<List<Persona>>(responseBody);
                return personas;
            }
            catch (HttpRequestException e)
            {
                MessageBox.Show(
                    "Ocurrió un error en traer las personas "+e.Message,
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return new List<Persona>();
            }
        }
        public async Task<Persona> getPersonaById(String Id)
        {
            try
            {
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
                HttpResponseMessage response = await client.GetAsync(this.baseUrl+"/"+Id);
                response.EnsureSuccessStatusCode();

                string responseBody = await response.Content.ReadAsStringAsync();

                Persona persona = JsonSerializer.Deserialize<Persona>(responseBody);
                return persona;
            }
            catch (HttpRequestException e)
            {
                MessageBox.Show(
                    e.Message,
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }

        public async Task<Persona> createPersona(Persona persona)
        {
            try
            {
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
                string url = this.baseUrl;
                string body = JsonSerializer.Serialize(persona);
                var content = new StringContent(body, Encoding.UTF8, "application/json");

                HttpResponseMessage response = await client.PostAsync(url, content);
                string responseBody = await response.Content.ReadAsStringAsync();

                Persona responsePersona = JsonSerializer.Deserialize<Persona>(responseBody);

                Console.WriteLine("Respuesta del servidor:");
                Console.WriteLine(responseBody);
                return responsePersona;
            }
            catch (HttpRequestException e)
            {
                MessageBox.Show(
                    "Error al insertar la persona",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }
        public async Task<Persona> updatePersonaById(String id, Persona persona)
        {
            try
            {
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
                string url = this.baseUrl+"/"+id;
                string body = JsonSerializer.Serialize(persona);
                var content = new StringContent(body, Encoding.UTF8, "application/json");

                HttpResponseMessage response = await client.PutAsync(url, content);
                string responseBody = await response.Content.ReadAsStringAsync();

                Persona responsePersona = JsonSerializer.Deserialize<Persona>(responseBody);

                Console.WriteLine("Respuesta del servidor:");
                Console.WriteLine(responseBody);
                return responsePersona;
            }
            catch (HttpRequestException e)
            {
                MessageBox.Show(
                    "Error al actualizar la persona",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }
        public async Task<Persona> deleteById(String id)
        {
            try
            {
                client.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("Bearer", Session.GetInstance().Token);
                string url = this.baseUrl + "/" + id;

                HttpResponseMessage response = await client.DeleteAsync(url);
                string responseBody = await response.Content.ReadAsStringAsync();
                Persona responsePersona = JsonSerializer.Deserialize<Persona>(responseBody);

                Console.WriteLine("Respuesta del servidor:");
                Console.WriteLine(responseBody);
                return responsePersona;
            }
            catch (HttpRequestException e)
            {
                MessageBox.Show(
                    "Error al eliminar la persona "+e.Message,
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return null;
            }
        }
    }
}

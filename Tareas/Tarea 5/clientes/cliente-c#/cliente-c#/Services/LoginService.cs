using cliente_c_.classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cliente_c_.Services
{
    public class LoginService
    {
        private HttpClient client = new HttpClient();
        private String baseUrl;
        public LoginService(String baseURL)
        {
            this.baseUrl = baseURL;
        }
        public async Task<LoginResponse> Authenticate(String email, String password)
        {
            try
            {
                string url = this.baseUrl;

                InputLogin credentialas = new InputLogin
                {
                    email = email,
                    password = password
                };


                string body = JsonSerializer.Serialize(credentialas);
                var content = new StringContent(body, Encoding.UTF8, "application/json");

                HttpResponseMessage response = await client.PostAsync(url, content);
                string responseBody = await response.Content.ReadAsStringAsync();

                LoginResponse loginResponse = JsonSerializer.Deserialize<LoginResponse>(responseBody);

                Session.GetInstance().Mensaje = loginResponse.Mensaje;
                Session.GetInstance().Token = loginResponse.Token;
                Session.GetInstance().Type = loginResponse.Type;
                Session.GetInstance().Expires = loginResponse.Expires;
                Session.GetInstance().Usuario = loginResponse.Usuario;

                Console.WriteLine("Respuesta del servidor:");
                Console.WriteLine(responseBody);
                return loginResponse;
            }
            catch (HttpRequestException e)
            {
                MessageBox.Show(
                    "Ocurrió un error logearte",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
                return new LoginResponse { Mensaje=e.Message};
            }
        }
    }
}

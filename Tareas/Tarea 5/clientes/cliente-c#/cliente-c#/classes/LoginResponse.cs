using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace cliente_c_.classes
{
    public class LoginResponse
    {
        [JsonPropertyName("mensaje")]
        public string Mensaje { get; set; }

        [JsonPropertyName("token")]
        public string Token { get; set; }

        [JsonPropertyName("type")]
        public string Type { get; set; }

        [JsonPropertyName("expires")]
        public int Expires { get; set; }

        [JsonPropertyName("usuario")]
        public Usuario Usuario { get; set; }
    }
}

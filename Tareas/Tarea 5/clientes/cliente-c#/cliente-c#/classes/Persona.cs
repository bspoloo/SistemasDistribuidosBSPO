using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace cliente_c_.classes
{
    public class Persona
    {
        [JsonPropertyName("id")]
        public int Id { get; set; }

        [JsonPropertyName("nombres")]
        public string Nombres { get; set; }

        [JsonPropertyName("apellidos")]
        public string Apellidos { get; set; }

        [JsonPropertyName("ci")]
        public string CI { get; set; }

        [JsonPropertyName("direccion")]
        public string Direccion { get; set; }

        [JsonPropertyName("telefono")]
        public string Telefono { get; set; }

        [JsonPropertyName("email")]
        public string Email { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Cliente.Classes
{
    public class CreatePronosticoData
    {
        [JsonPropertyName("createPronostico")]
        public Pronostico Pronostico { get; set; }
    }
}

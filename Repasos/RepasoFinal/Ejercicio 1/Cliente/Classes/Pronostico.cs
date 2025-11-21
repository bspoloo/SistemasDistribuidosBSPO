using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json.Serialization;
using System.Threading.Tasks;

namespace Cliente.Classes
{
    public class Pronostico
    {
        [JsonPropertyName("id")]
        public int Id { get; set; }

        [JsonPropertyName("fecha")]
        public DateTime Fecha { get; set; }

        [JsonPropertyName("cantidad_estimada")]
        public int CantidadEstimada { get; set; }
        public override string ToString()
        {
            return $"ID: {Id}, Fecha: {Fecha}, Cantidad estimada {CantidadEstimada}";
        }

    }
}

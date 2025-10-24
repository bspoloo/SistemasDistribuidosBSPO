using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Web;

/// <summary>
/// Descripción breve de Factura
/// </summary>
public class Factura
{
    [JsonPropertyName("ci")]
    public String CI { get; set; }

    [JsonPropertyName("nombres")]
    public String Nombres { get; set; }

    [JsonPropertyName("primer_apellido")]
    public String PrimerApellido { get; set; }

    [JsonPropertyName("segundo_apellido")]
    public String SegundoApellido { get; set; }

    [JsonPropertyName("monto")]
    public float Monto { get; set; }


    public Factura()
    {
        //
        // TODO: Agregar aquí la lógica del constructor
        //
    }
}
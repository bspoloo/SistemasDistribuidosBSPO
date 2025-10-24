using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Web;

/// <summary>
/// Descripción breve de Persona
/// </summary>
public class Persona
{
    [JsonPropertyName("id")]
    public int Id { get; set; }

    [JsonPropertyName("ci")]
    public string CI { get; set; }

    [JsonPropertyName("nombres")]
    public string Nombres { get; set; }

    [JsonPropertyName("primer_apellido")]
    public string PrimerApellido { get; set; }

    [JsonPropertyName("segundo_apellido")]
    public string SegundoApellido { get; set; }

    public override string ToString()
    {
        return $"CI: {CI}, Nombres: {Nombres} {PrimerApellido} {SegundoApellido}";
    }
    public Persona()
    {
        //
        // TODO: Agregar aquí la lógica del constructor
        //
    }
}
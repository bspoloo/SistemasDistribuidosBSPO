using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Web;

/// <summary>
/// Descripción breve de PersonaData
/// </summary>
public class PersonaData
{
    [JsonPropertyName("persona")]
    public Persona Persona { get; set; }
    public PersonaData()
    {
        //
        // TODO: Agregar aquí la lógica del constructor
        //
    }
}
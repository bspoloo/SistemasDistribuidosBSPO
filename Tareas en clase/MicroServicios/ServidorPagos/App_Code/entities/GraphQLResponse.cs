using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Json.Serialization;
using System.Web;

/// <summary>
/// Descripción breve de GraphQLResponse
/// </summary>
public class GraphQLResponse
{
    [JsonPropertyName("data")]
    public PersonaData Data { get; set; }
    public GraphQLResponse()
    {
        //
        // TODO: Agregar aquí la lógica del constructor
        //
    }
}
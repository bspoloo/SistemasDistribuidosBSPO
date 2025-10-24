using System;
using System.Text.Json.Serialization;

public class FacturaDTO
{
    [JsonPropertyName("ci")]
    public string ci { get; set; }

    [JsonPropertyName("nombres")]
    public string nombres { get; set; }

    [JsonPropertyName("primer_apellido")]
    public string primer_apellido { get; set; }

    [JsonPropertyName("segundo_apellido")]
    public string segundo_apellido { get; set; }

    [JsonPropertyName("monto")]
    public float monto { get; set; }

    public FacturaDTO() { }
}

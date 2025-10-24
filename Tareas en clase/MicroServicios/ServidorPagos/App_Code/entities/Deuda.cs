using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de Deuda
/// </summary>
public class Deuda
{
    public int Id { get; set; }
    public String CI { get; set; }
    public String Nombres { get; set; }
    public String SegundoApellido { get; set; }
    public String PrimerApellido { get; set; }
    public float Monto { get; set; }
    public Deuda()
    {
    }
}
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Factura
/// </summary>
public class Factura
{
    public String ClienteCI { set; get; }
    public String Monto { set; get; }
    public DateTime FechaEmision { set; get; }
    public DateTime FechaVencimiento { set; get; }
    public bool Estado { set; get; }
}
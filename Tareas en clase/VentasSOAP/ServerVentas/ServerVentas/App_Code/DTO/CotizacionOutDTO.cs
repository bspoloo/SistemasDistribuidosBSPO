using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for ResponseCotizacionDTO
/// </summary>
public class CotizacionOutDTO<E>
{
    public String message { get; set; }
    public int statusCode { get; set; }
    public E data { get; set; }
    public CotizacionOutDTO() { }
    public CotizacionOutDTO(String message, int statusCode, E data)
    {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }
}
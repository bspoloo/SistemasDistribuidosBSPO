using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de Response
/// </summary>
public class Response<T>
{
 
    public String Message { set; get; }
    public int Status { set; get; }
    public T Data { set; get; }
    public Response()
    {
        //
        // TODO: Agregar aquí la lógica del constructor
        //
    }
}
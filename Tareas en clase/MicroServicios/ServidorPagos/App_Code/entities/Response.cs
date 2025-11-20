using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Descripción breve de Response
/// </summary>
public class Response<T>
{
    public String Message { get; set; }
    public int Status { get; set; }
    public T Data { get; set; }
    public Response()
    {
    }
}
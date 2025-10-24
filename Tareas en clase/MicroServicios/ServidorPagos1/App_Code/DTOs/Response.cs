using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

/// <summary>
/// Summary description for Response
/// </summary>
public class Response<E>
{
    public String message { get; set; }
    public int statusCode { get; set; }
    public E data { get; set; }
    public Response() { }
    public Response(String message, int statusCode, E data)
    {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }
}
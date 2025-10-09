using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Summary description for Operations
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class Operations : System.Web.Services.WebService
{

    public Operations()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }

    [WebMethod]
    public int add(int a, int b)
    {
        return a + b;
    }

    [WebMethod]
    public int rest(int a, int b)
    {
        return a - b;
    }

    [WebMethod]
    public int multiply(int a, int b)
    {
        return a * b;
    }

    [WebMethod]
    public int divide(int a, int b)
    {
        return a / b;
    }

}

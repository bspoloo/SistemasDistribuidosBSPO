using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientVentas
{
    public class Cotizacion
    {
        public DateTime Fecha { get; set; }
        public float CotizacionActual { get; set; }
        public float CotizacionOficial { get; set; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace cliente_c_.classes
{
    public class Session
    {
        private static Session instance;
        public string Mensaje { get; set; }
        public string Type { get; set; }
        public int Expires { get; set; }
        public string Token { get; set; }
        public Usuario Usuario { get; set; }

        private Session() { }

        public static Session GetInstance()
        {
            if (instance == null)
                instance = new Session();

            return instance;
        }
    }
}

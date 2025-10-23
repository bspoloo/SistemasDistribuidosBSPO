using cliente_c_.classes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cliente_c_
{
    internal static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            if (Session.GetInstance().Token != null)
            {
                Application.Run(new FormCRUD());
            }
            else
            {
                Application.Run(new FormLogin());
            }
        }
    }
}

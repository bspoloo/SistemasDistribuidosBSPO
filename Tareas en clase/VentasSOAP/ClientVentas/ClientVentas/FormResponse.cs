using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClientVentas
{
    public partial class FormResponse : Form
    {
        public FormResponse(DateTime fecha, float cotizacion, float CotizacionOficial)
        {
            InitializeComponent();
            textBoxFecha.Text = fecha.ToString();
            textBoxCotizacion.Text = cotizacion.ToString();
            textBoxOficial.Text = cotizacion.ToString();
        }

        private void labelFecha_Click(object sender, EventArgs e)
        {

        }

        private void labelCotizacion_Click(object sender, EventArgs e)
        {

        }

        private void labelCotizacionActual_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}

using ClientVentas.CotizacionesService;
using ClientVentas.Dtos;
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
    public partial class FormCotizacion : Form
    {
        private CotizacionesService.VentasSoapClient service;
        public FormCotizacion()
        {
            InitializeComponent();
            this.service = new CotizacionesService.VentasSoapClient();
        }

        private void buttonInsert_Click(object sender, EventArgs e)
        {
            DateTime fecha = DateTime.Parse(this.textBoxFecha.Text);
            float cotizacion = float.Parse(this.textBoxCotizacion.Text);
            float cotizacionOficial = float.Parse(this.textBoxCotizacionOficial.Text);

            CotizacionOutDTOOfBoolean response = service.RegistrarCotizaciones(fecha, cotizacion, cotizacionOficial);

            if (response.data)
            {
                MessageBox.Show(
                    response.message ?? "Cotización registrada correctamente.",
                    "Éxito",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Information
                );
            }
            else
            {
                MessageBox.Show(
                    response.message ?? "No se pudo registrar la cotización.",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Warning
                );
            }
        }

        private void buttonBuscar_Click(object sender, EventArgs e)
        {
            String fecha = textBoxBuscar.Text;
            CotizacionOutDTOOfCotizacion response = service.ObtenerCotizacionByFecha(fecha);

            if(response.data != null)
            {
               FormResponse formResponse = new FormResponse(response.data.Fecha, response.data.CotizacionActual, response.data.CotizacionOficial);
                formResponse.Show();
            }
            else
            {
                MessageBox.Show(
                   response.message ?? "No se pudo registrar la cotización.",
                   "Error",
                   MessageBoxButtons.OK,
                   MessageBoxIcon.Warning
               );
            }
        }

        private void buttonAll_Click(object sender, EventArgs e)
        {

            dataGridViewCotizaciones.DataSource = null;
            dataGridViewCotizaciones.Rows.Clear();
            CotizacionOutDTOOfListOfCotizacion response = this.service.ObtenerCotizaciones();

            foreach(CotizacionesService.Cotizacion cotizacion in response.data)
            {
                dataGridViewCotizaciones.Rows.Add(cotizacion.Fecha.ToString(), cotizacion.CotizacionActual.ToString(), cotizacion.CotizacionOficial.ToString());
            }
        }
    }
}

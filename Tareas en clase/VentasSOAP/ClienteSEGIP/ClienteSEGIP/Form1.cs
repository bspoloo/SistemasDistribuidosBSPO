using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteSEGIP
{
    public partial class Form1 : Form
    {
        private PersonasService.PersonasServiceSoapClient service;
        public Form1()
        {
            InitializeComponent();
            this.service = new PersonasService.PersonasServiceSoapClient();
        }

        private void buttonBuscarCi_Click(object sender, EventArgs e)
        {
            String ci = textBoxCI.Text;
            PersonasService.ResponseDTOOfPersona response = this.service.BuscarPersonaCI(ci);
            if(response.data != null)
            {
                dataGridView1.Rows.Clear();
                dataGridView1.Rows.Add(
                    response.data.ci, 
                    response.data.nombres, 
                    response.data.primerApellido, 
                    response.data.segundoApellido
                    );
            }
            else
            {
                MessageBox.Show(
                    response.message ?? "No se pudo Encontrar a la persona.",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Warning
                );
            }
        }

        private void buttonBuscarTodo_Click(object sender, EventArgs e)
        {
            String nombres = textBoxNombres.Text;
            String primerApellido = textBoxPApellido.Text;
            String segundoApellido = textBoxSApellido.Text;
            PersonasService.ResponseDTOOfListOfPersona response = this.service.BuscarPersonas(primerApellido, segundoApellido, nombres);
            if (response.data != null)
            {
                dataGridView1.Rows.Clear();
                foreach(PersonasService.Persona persona in response.data)
                {
                dataGridView1.Rows.Add(
                    persona.ci,
                    persona.nombres,
                    persona.primerApellido,
                    persona.segundoApellido
                    );
                }
            }
            else
            {
                MessageBox.Show(
                    response.message ?? "No se pudo Encontrar a la persona.",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Warning
                );
            }
        }
    }
}

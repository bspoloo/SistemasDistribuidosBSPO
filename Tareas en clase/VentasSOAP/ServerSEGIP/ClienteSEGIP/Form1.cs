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
        PersonasService.PersonasServiceSoapClient service;

        public Form1()
        {
            InitializeComponent();
            PersonasService.PersonasServiceSoapClient service = new PersonasService.PersonasServiceSoapClient();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void buttonCI_Click(object sender, EventArgs e)
        {
            String buscarCI = textBoxCI.Text;
            PersonasService.ResponseDTOOfPersona response = service.BuscarPersonaCI(buscarCI);
            if (response.data != null)
            {
                dataGridView1.Rows.Clear();
                dataGridView1.Rows.Add(response.data.ci);
                dataGridView1.Rows.Add(response.data.nombres);
                dataGridView1.Rows.Add(response.data.primerApellido);
                dataGridView1.Rows.Add(response.data.segundoApellido);
            }
            else
            {
                MessageBox.Show(
                    response.message ?? "traer la persona.",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Warning
                );
            }
        }

        private void BuscarTodo_Click(object sender, EventArgs e)
        {
            String nombres = textBoxNombres.Text;
            String primerApellido = textBoxPApellido.Text;
            String segundoApellido = textBoxSApellido.Text;
            PersonasService.ResponseDTOOfListOfPersona response = service.BuscarPersonas(nombres, primerApellido, segundoApellido);
            if (response.data != null)
            {
                foreach(PersonasService.Persona persona in response.data)
                {
                    dataGridView1.Rows.Clear();
                    dataGridView1.Rows.Add(persona.ci);
                    dataGridView1.Rows.Add(persona.nombres);
                    dataGridView1.Rows.Add(persona.primerApellido);
                    dataGridView1.Rows.Add(persona.segundoApellido);
                }
            }
            else
            {
                MessageBox.Show(
                    response.message ?? "Error en traer las personas.",
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Warning
                );
            }
        }
    }
}

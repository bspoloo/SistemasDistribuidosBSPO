using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClienteSeduinfo
{
    public partial class Form1 : Form
    {
        SeduinfoService.SeduInfoServiceSoapClient service;
        public Form1()
        {
            InitializeComponent();
            this.service = new SeduinfoService.SeduInfoServiceSoapClient();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void textBoxCI_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            String CI = textBoxCI.Text.ToString();
            SeduinfoService.ResponseOfEstudiante response = this.service.ObtenerDatosAcademicos(CI);
            if(response.Data != null)
            {

                String message = 
                    $"CI: {response.Data.CI} \n" +
                    $"Nombres: {response.Data.Nombres} \n" +
                    $"Apellidos: {response.Data.Apellidos} \n" +
                    $"Carrera: {response.Data.Carrera} \n" +
                    $"Semestre: {response.Data.Promedio} \n";

                MessageBox.Show(message, "Success",
                MessageBoxButtons.OK, MessageBoxIcon.Information);
            }else
            {
                MessageBox.Show(response.Message, "Error",
                MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            String CI = textBoxCI.Text.ToString();
            SeduinfoService.ResponseOfTutor response = this.service.ObtenerDatosTutor(CI);
            if (response.Data != null)
            {
                String message =
                    $"Nombres del estudiante: {response.Data.NombreEstudiante} \n" +
                    $"Tutor Asignado: {response.Data.TutorAsignado} \n" +
                    $"Correo del Tutor: {response.Data.CorreoTutor} \n" +
                    $"Telefono Tutor: {response.Data.TelefonoTutor} \n";

                MessageBox.Show(message, "Success",
                MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show(response.Message, "Error",
                MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void labelCI_Click(object sender, EventArgs e)
        {

        }
    }
}

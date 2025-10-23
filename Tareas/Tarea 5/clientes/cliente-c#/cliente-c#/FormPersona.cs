using cliente_c_.classes;
using cliente_c_.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cliente_c_
{
    public partial class FormPersona : Form
    {
        private String id;
        private Persona persona;
        private PersonaService personaService;
        private FormCRUD formCRUD;
        public FormPersona(FormCRUD formCRUD)
        {
            InitializeComponent();
            //loadDataPersona();
            this.formCRUD = formCRUD;
            this.personaService = new PersonaService("http://127.0.0.1:8000/api/personas");
        }
        public void SetId(String Id)
        {
            this.id = Id;
        }

        public async void LoadDataPersona()
        {
            if (string.IsNullOrEmpty(this.id)) return;

            this.persona = await this.personaService.getPersonaById(this.id);

            if (this.persona != null)
            {
                this.textBoxNombres.Text = persona.Nombres;
                this.textBoxApellidos.Text = persona.Apellidos;
                this.textBoxCI.Text = persona.CI;
                this.textBoxDireccion.Text = persona.Direccion;
                this.textBoxTelefono.Text = persona.Telefono;
                this.textBoxEmail.Text = persona.Email;
                buttonExecute.Text = "Actualizar";
            }
            else
            {
                buttonExecute.Text = "Insertar";
            }
        }

        private async void buttonExecute_Click(object sender, EventArgs e)
        {
            Persona dataPersona = new Persona { 
                Nombres = textBoxNombres.Text,
                Apellidos = textBoxApellidos.Text,
                CI = textBoxCI.Text,
                Telefono = textBoxTelefono.Text,
                Direccion = textBoxDireccion.Text,
                Email = textBoxEmail.Text,
            };
            Persona response = null;
            if(this.id == null)
            {
                response = await this.personaService.createPersona(dataPersona);
                
            }else
            {
                response = await this.personaService.updatePersonaById(this.id, dataPersona);
            }

            if (response == null)
            {
                MessageBox.Show(
                   "Error al ejecutar accion",
                   "Error",
                   MessageBoxButtons.OK,
                   MessageBoxIcon.Error
                );
            }
            else
            {
                DialogResult result = MessageBox.Show(
                   response.Nombres,
                   "Success",
                   MessageBoxButtons.OK,
                   MessageBoxIcon.Information
                );
                if (result == DialogResult.OK)
                {
                    this.Close();
                    this.formCRUD.showPersonas();
                }
            }
        }
    }
}

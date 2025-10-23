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
    public partial class FormCRUD : Form
    {
        PersonaService personaService;
        public FormCRUD()
        {
            InitializeComponent();
            this.personaService = new PersonaService("http://127.0.0.1:8000/api/personas");
            labelUserName.Text = Session.GetInstance().Usuario.Name ?? "Sin usuario";
            InitializeDataGridView();
            showPersonas();
        }

        private void InitializeDataGridView()
        {
            dataGridView1.Columns.Clear();

            dataGridView1.Columns.Add("Id", "ID");
            dataGridView1.Columns.Add("Nombres", "Nombres");
            dataGridView1.Columns.Add("Apellidos", "Apellidos");
            dataGridView1.Columns.Add("CI", "CI");
            dataGridView1.Columns.Add("Direccion", "Dirección");
            dataGridView1.Columns.Add("Telefono", "Teléfono");
            dataGridView1.Columns.Add("Email", "Email");

            DataGridViewButtonColumn btnEditar = new DataGridViewButtonColumn();
            btnEditar.HeaderText = "Editar";
            btnEditar.Text = "Editar";
            btnEditar.Name = "btnEditar";
            btnEditar.UseColumnTextForButtonValue = true;
            dataGridView1.Columns.Add(btnEditar);

            DataGridViewButtonColumn btnEliminar = new DataGridViewButtonColumn();
            btnEliminar.HeaderText = "Eliminar";
            btnEliminar.Text = "Eliminar";
            btnEliminar.Name = "btnEliminar";
            btnEliminar.UseColumnTextForButtonValue = true;
            dataGridView1.Columns.Add(btnEliminar);

            dataGridView1.CellClick += DataGridView1_CellClick;
        }

        public async void showPersonas()
        {
            List<Persona> personas = await this.personaService.getAllPersonas();
            dataGridView1.Rows.Clear();


            foreach (Persona persona in personas)
            {
                dataGridView1.Rows.Add(persona.Id, persona.Nombres, persona.Apellidos, persona.CI, persona.Direccion, persona.Telefono, persona.Email);
            }
        }

        private void buttonCreate_Click(object sender, EventArgs e)
        {
            FormPersona formPersona = new FormPersona(this);
            formPersona.LoadDataPersona();
            formPersona.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            showPersonas();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
        private async void DataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;
            if (dataGridView1.Columns[e.ColumnIndex].Name == "btnEditar")
            {
                string id = dataGridView1.Rows[e.RowIndex].Cells["id"].Value.ToString();

                FormPersona formPersona = new FormPersona(this);
                formPersona.SetId(id);
                formPersona.LoadDataPersona();
                formPersona.ShowDialog();
            }
            if (dataGridView1.Columns[e.ColumnIndex].Name == "btnEliminar")
            {
                string id = dataGridView1.Rows[e.RowIndex].Cells["id"].Value.ToString();
                string nombre = dataGridView1.Rows[e.RowIndex].Cells["Nombres"].Value.ToString();

                DialogResult result = MessageBox.Show(
                    "¿Deseas continuar, Eliminar a " + nombre +"?",      
                    "Eliminar",            
                    MessageBoxButtons.OKCancel,
                    MessageBoxIcon.Warning
                );

                if (result == DialogResult.OK)
                {
                    Persona persona = await this.personaService.deleteById(id);
                    if(persona != null)
                    {
                        MessageBox.Show("Persona Eliminada correctanente");
                        showPersonas();
                    }else
                    {
                        MessageBox.Show(
                           "Error al eliminar la persona ",
                           "Error",
                           MessageBoxButtons.OK,
                           MessageBoxIcon.Error
                        );
                    }
                }
            }
        }
    }
}

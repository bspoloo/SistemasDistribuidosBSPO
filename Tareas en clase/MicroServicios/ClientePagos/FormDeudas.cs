using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClientePagos
{
    public partial class FormDeudas : Form
    {
        private ServicioPagos.ServicioPagosSoapClient servicioPagos;
        public FormDeudas()
        {
            this.servicioPagos = new ServicioPagos.ServicioPagosSoapClient();
            InitializeComponent();
            InitializeDataGridView();
        }

        private void InitializeDataGridView()
        {
            dataGridViewDeudas.Columns.Clear();

            dataGridViewDeudas.Columns.Add("ci", "CI");
            dataGridViewDeudas.Columns.Add("nombres", "Nomrbes");
            dataGridViewDeudas.Columns.Add("primer_apellido", "Primer Apellido");
            dataGridViewDeudas.Columns.Add("segundo_apellido", "Segundo Apellido");
            dataGridViewDeudas.Columns.Add("monto", "Monto");

            DataGridViewButtonColumn btnPagar = new DataGridViewButtonColumn();
            btnPagar.HeaderText = "Pagar";
            btnPagar.Text = "Pagar";
            btnPagar.Name = "btnPagar";
            btnPagar.UseColumnTextForButtonValue = true;
            dataGridViewDeudas.Columns.Add(btnPagar);

            //DataGridViewButtonColumn btnEliminar = new DataGridViewButtonColumn();
            //btnEliminar.HeaderText = "Eliminar";
            //btnEliminar.Text = "Eliminar";
            //btnEliminar.Name = "btnEliminar";
            //btnEliminar.UseColumnTextForButtonValue = true;
            //dataGridViewDeudas.Columns.Add(btnEliminar);

            dataGridViewDeudas.CellClick += DataGridView1_CellClick;
        }

        private void DataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;
            if (dataGridViewDeudas.Columns[e.ColumnIndex].Name == "btnPagar")
            {
                string ci = dataGridViewDeudas.Rows[e.RowIndex].Cells["ci"].Value.ToString();
                string nombres = dataGridViewDeudas.Rows[e.RowIndex].Cells["nombres"].Value.ToString();
                string primer_apellido = dataGridViewDeudas.Rows[e.RowIndex].Cells["primer_apellido"].Value.ToString();
                string segundo_apellido = dataGridViewDeudas.Rows[e.RowIndex].Cells["segundo_apellido"].Value.ToString();
                float monto = float.Parse(dataGridViewDeudas.Rows[e.RowIndex].Cells["monto"].Value.ToString());

                ServicioPagos.ResponseOfListOfFactura response = this.servicioPagos.PagarDeuda(ci, nombres, primer_apellido, segundo_apellido, monto);

                String message = "";
                foreach(ServicioPagos.Factura factura in response.Data)
                {
                    message += factura.Monto + "\n";
                }
                MessageBox.Show(message);
                this.InitializeDataGridView();
                //showPersonas();
            }
        }
        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void buttonVerDeudas_Click(object sender, EventArgs e)
        {
            String CI = textBoxCI.Text.ToString();
            String Nombres = textBoxNombres.Text.ToString();
            String PrimerApellido = textBoxPApellido.Text.ToString();
            String SegundoApellido = textBoxSApellido.Text.ToString();

            Console.WriteLine("Verificando deudas");

            ServicioPagos.ResponseOfListOfDeuda response = this.servicioPagos.VerDeuda(CI, Nombres, PrimerApellido, SegundoApellido);
            Console.WriteLine(response);

            if (response.Status == 200)
            {
                ServicioPagos.Deuda[] deudas = response.Data;
                dataGridViewDeudas.Rows.Clear();

                foreach (ServicioPagos.Deuda deuda in deudas)
                {
                    dataGridViewDeudas.Rows.Add(deuda.CI, deuda.Nombres, deuda.PrimerApellido, deuda.SegundoApellido, deuda.Monto);
                }
            }
            else
            {
                MessageBox.Show(
                    "Error en traer deudas " + response.Message,
                    "Error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error
                );
            }
        }
    }
}

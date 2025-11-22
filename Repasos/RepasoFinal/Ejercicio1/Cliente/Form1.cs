using Cliente.Classes;
using Cliente.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Cliente
{
    public partial class Form1 : Form
    {
        private DemandaService demandaService;
        public Form1()
        {
            InitializeComponent();
            InitializeDataGridView();
            this.demandaService = new DemandaService();
            showPronosticos();
        }

        private void InitializeDataGridView()
        {
            dataGridViewPron.Columns.Clear();

            dataGridViewPron.Columns.Add("id", "ID");
            dataGridViewPron.Columns.Add("fecha", "Fecha");
            dataGridViewPron.Columns.Add("cantidad_estimada", "Cantida Estimada");

            //DataGridViewButtonColumn btnPagar = new DataGridViewButtonColumn();
            //btnPagar.HeaderText = "Pagar";
            //btnPagar.Text = "Pagar";
            //btnPagar.Name = "btnPagar";
            //btnPagar.UseColumnTextForButtonValue = true;
            //dataGridViewPron.Columns.Add(btnPagar);

            //DataGridViewButtonColumn btnEliminar = new DataGridViewButtonColumn();
            //btnEliminar.HeaderText = "Eliminar";
            //btnEliminar.Text = "Eliminar";
            //btnEliminar.Name = "btnEliminar";
            //btnEliminar.UseColumnTextForButtonValue = true;
            //dataGridViewPron.Columns.Add(btnEliminar);

            //dataGridViewPron.CellClick += DataGridView1_CellClick;
        }
        public async void showPronosticos()
        {
            dataGridViewPron.Rows.Clear();
            List<Pronostico> pronosticos = await this.demandaService.getAllPronosticos();
            Console.WriteLine(pronosticos);
            foreach (Pronostico pronostico  in pronosticos)
            {
                dataGridViewPron.Rows.Add(pronostico.Id, pronostico.Fecha.ToString(), pronostico.CantidadEstimada.ToString());
            }
        }

        private async void buttonInsertREST_Click(object sender, EventArgs e)
        {
            Pronostico newPronostico = new Pronostico()
            {
                Id = int.Parse(textBoxID.Text.ToString()),
                Fecha = DateTime.Parse(textBoxFecha.Text.ToString()),
                CantidadEstimada = int.Parse(textBoxCEsp.Text.ToString())
            };
            Pronostico pronostico = await this.demandaService.InsertPronosticosByREST(newPronostico);
            dataGridViewPron.Rows.Add(pronostico.Id, pronostico.Fecha.ToString(), pronostico.CantidadEstimada.ToString());
            //this.showPronosticos();
        }

        private async void buttonUpdateREST_Click(object sender, EventArgs e)
        {
            Pronostico newPronostico = new Pronostico()
            {
                Id = int.Parse(textBoxID.Text.ToString()),
                Fecha = DateTime.Parse(textBoxFecha.Text.ToString()),
                CantidadEstimada = int.Parse(textBoxCEsp.Text.ToString())
            };
            Pronostico pronostico = await this.demandaService.UpdatePronosticosByREST(newPronostico);
            this.showPronosticos();
            //dataGridViewPron.Rows.Add(pronostico.Id, pronostico.Fecha.ToString(), pronostico.CantidadEstimada.ToString());
        }

        private async void buttonInsertGraphQL_Click(object sender, EventArgs e)
        {
            Pronostico newPronostico = new Pronostico()
            {
                Id = int.Parse(textBoxID.Text.ToString()),
                Fecha = DateTime.Parse(textBoxFecha.Text.ToString()),
                CantidadEstimada = int.Parse(textBoxCEsp.Text.ToString())
            };
            Pronostico pronostico = await this.demandaService.InsertPronosticosByGRAPHQL(newPronostico);
            dataGridViewPron.Rows.Add(pronostico.Id, pronostico.Fecha.ToString(), pronostico.CantidadEstimada.ToString());
        }

        private async void buttonUpdateGraphQL_Click(object sender, EventArgs e)
        {
            Pronostico newPronostico = new Pronostico()
            {
                Id = int.Parse(textBoxID.Text.ToString()),
                Fecha = DateTime.Parse(textBoxFecha.Text.ToString()),
                CantidadEstimada = int.Parse(textBoxCEsp.Text.ToString())
            };
            Pronostico pronostico = await this.demandaService.UpdatePronosticosByGRAPHQL(newPronostico);
            this.showPronosticos();
        }
    }
}

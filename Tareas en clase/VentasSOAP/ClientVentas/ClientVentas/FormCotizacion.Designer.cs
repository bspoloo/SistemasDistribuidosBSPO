namespace ClientVentas
{
    partial class FormCotizacion
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.textBoxFecha = new System.Windows.Forms.TextBox();
            this.textBoxCotizacion = new System.Windows.Forms.TextBox();
            this.textBoxCotizacionOficial = new System.Windows.Forms.TextBox();
            this.labelFecha = new System.Windows.Forms.Label();
            this.labelCotizacion = new System.Windows.Forms.Label();
            this.labelCotizacionOficial = new System.Windows.Forms.Label();
            this.buttonInsert = new System.Windows.Forms.Button();
            this.textBoxBuscar = new System.Windows.Forms.TextBox();
            this.labelBuscar = new System.Windows.Forms.Label();
            this.buttonBuscar = new System.Windows.Forms.Button();
            this.buttonAll = new System.Windows.Forms.Button();
            this.dataGridViewCotizaciones = new System.Windows.Forms.DataGridView();
            this.Fecha = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Cotizacion = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CotizacionOficial = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewCotizaciones)).BeginInit();
            this.SuspendLayout();
            // 
            // textBoxFecha
            // 
            this.textBoxFecha.Location = new System.Drawing.Point(155, 27);
            this.textBoxFecha.Name = "textBoxFecha";
            this.textBoxFecha.Size = new System.Drawing.Size(100, 20);
            this.textBoxFecha.TabIndex = 0;
            // 
            // textBoxCotizacion
            // 
            this.textBoxCotizacion.Location = new System.Drawing.Point(155, 66);
            this.textBoxCotizacion.Name = "textBoxCotizacion";
            this.textBoxCotizacion.Size = new System.Drawing.Size(100, 20);
            this.textBoxCotizacion.TabIndex = 1;
            // 
            // textBoxCotizacionOficial
            // 
            this.textBoxCotizacionOficial.Location = new System.Drawing.Point(155, 108);
            this.textBoxCotizacionOficial.Name = "textBoxCotizacionOficial";
            this.textBoxCotizacionOficial.Size = new System.Drawing.Size(100, 20);
            this.textBoxCotizacionOficial.TabIndex = 2;
            // 
            // labelFecha
            // 
            this.labelFecha.AutoSize = true;
            this.labelFecha.Location = new System.Drawing.Point(103, 27);
            this.labelFecha.Name = "labelFecha";
            this.labelFecha.Size = new System.Drawing.Size(37, 13);
            this.labelFecha.TabIndex = 3;
            this.labelFecha.Text = "Fecha";
            // 
            // labelCotizacion
            // 
            this.labelCotizacion.AutoSize = true;
            this.labelCotizacion.Location = new System.Drawing.Point(93, 66);
            this.labelCotizacion.Name = "labelCotizacion";
            this.labelCotizacion.Size = new System.Drawing.Size(56, 13);
            this.labelCotizacion.TabIndex = 4;
            this.labelCotizacion.Text = "Cotizacion";
            // 
            // labelCotizacionOficial
            // 
            this.labelCotizacionOficial.AutoSize = true;
            this.labelCotizacionOficial.Location = new System.Drawing.Point(61, 108);
            this.labelCotizacionOficial.Name = "labelCotizacionOficial";
            this.labelCotizacionOficial.Size = new System.Drawing.Size(88, 13);
            this.labelCotizacionOficial.TabIndex = 5;
            this.labelCotizacionOficial.Text = "Cotizacion Oficial";
            // 
            // buttonInsert
            // 
            this.buttonInsert.Location = new System.Drawing.Point(167, 155);
            this.buttonInsert.Name = "buttonInsert";
            this.buttonInsert.Size = new System.Drawing.Size(75, 23);
            this.buttonInsert.TabIndex = 6;
            this.buttonInsert.Text = "Insertar";
            this.buttonInsert.UseVisualStyleBackColor = true;
            this.buttonInsert.Click += new System.EventHandler(this.buttonInsert_Click);
            // 
            // textBoxBuscar
            // 
            this.textBoxBuscar.Location = new System.Drawing.Point(155, 215);
            this.textBoxBuscar.Name = "textBoxBuscar";
            this.textBoxBuscar.Size = new System.Drawing.Size(100, 20);
            this.textBoxBuscar.TabIndex = 7;
            // 
            // labelBuscar
            // 
            this.labelBuscar.AutoSize = true;
            this.labelBuscar.Location = new System.Drawing.Point(104, 215);
            this.labelBuscar.Name = "labelBuscar";
            this.labelBuscar.Size = new System.Drawing.Size(40, 13);
            this.labelBuscar.TabIndex = 8;
            this.labelBuscar.Text = "Buscar";
            // 
            // buttonBuscar
            // 
            this.buttonBuscar.Location = new System.Drawing.Point(167, 268);
            this.buttonBuscar.Name = "buttonBuscar";
            this.buttonBuscar.Size = new System.Drawing.Size(75, 23);
            this.buttonBuscar.TabIndex = 9;
            this.buttonBuscar.Text = "Buscar";
            this.buttonBuscar.UseVisualStyleBackColor = true;
            this.buttonBuscar.Click += new System.EventHandler(this.buttonBuscar_Click);
            // 
            // buttonAll
            // 
            this.buttonAll.Location = new System.Drawing.Point(572, 317);
            this.buttonAll.Name = "buttonAll";
            this.buttonAll.Size = new System.Drawing.Size(124, 23);
            this.buttonAll.TabIndex = 11;
            this.buttonAll.Text = "Traer Cotizaciones";
            this.buttonAll.UseVisualStyleBackColor = true;
            this.buttonAll.Click += new System.EventHandler(this.buttonAll_Click);
            // 
            // dataGridViewCotizaciones
            // 
            this.dataGridViewCotizaciones.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewCotizaciones.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Fecha,
            this.Cotizacion,
            this.CotizacionOficial});
            this.dataGridViewCotizaciones.Location = new System.Drawing.Point(445, 66);
            this.dataGridViewCotizaciones.Name = "dataGridViewCotizaciones";
            this.dataGridViewCotizaciones.Size = new System.Drawing.Size(343, 244);
            this.dataGridViewCotizaciones.TabIndex = 12;
            // 
            // Fecha
            // 
            this.Fecha.HeaderText = "Fecha";
            this.Fecha.Name = "Fecha";
            // 
            // Cotizacion
            // 
            this.Cotizacion.HeaderText = "Cotizacion";
            this.Cotizacion.Name = "Cotizacion";
            // 
            // CotizacionOficial
            // 
            this.CotizacionOficial.HeaderText = "Cotizacion Oficial";
            this.CotizacionOficial.Name = "CotizacionOficial";
            // 
            // FormCotizacion
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 352);
            this.Controls.Add(this.dataGridViewCotizaciones);
            this.Controls.Add(this.buttonAll);
            this.Controls.Add(this.buttonBuscar);
            this.Controls.Add(this.labelBuscar);
            this.Controls.Add(this.textBoxBuscar);
            this.Controls.Add(this.buttonInsert);
            this.Controls.Add(this.labelCotizacionOficial);
            this.Controls.Add(this.labelCotizacion);
            this.Controls.Add(this.labelFecha);
            this.Controls.Add(this.textBoxCotizacionOficial);
            this.Controls.Add(this.textBoxCotizacion);
            this.Controls.Add(this.textBoxFecha);
            this.Name = "FormCotizacion";
            this.Text = "Formulario Cotizacion";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewCotizaciones)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxFecha;
        private System.Windows.Forms.TextBox textBoxCotizacion;
        private System.Windows.Forms.TextBox textBoxCotizacionOficial;
        private System.Windows.Forms.Label labelFecha;
        private System.Windows.Forms.Label labelCotizacion;
        private System.Windows.Forms.Label labelCotizacionOficial;
        private System.Windows.Forms.Button buttonInsert;
        private System.Windows.Forms.TextBox textBoxBuscar;
        private System.Windows.Forms.Label labelBuscar;
        private System.Windows.Forms.Button buttonBuscar;
        private System.Windows.Forms.Button buttonAll;
        private System.Windows.Forms.DataGridView dataGridViewCotizaciones;
        private System.Windows.Forms.DataGridViewTextBoxColumn Fecha;
        private System.Windows.Forms.DataGridViewTextBoxColumn Cotizacion;
        private System.Windows.Forms.DataGridViewTextBoxColumn CotizacionOficial;
    }
}


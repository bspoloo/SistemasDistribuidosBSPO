namespace ClientePagos
{
    partial class FormDeudas
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.labelCI = new System.Windows.Forms.Label();
            this.labelNombres = new System.Windows.Forms.Label();
            this.labelPApellido = new System.Windows.Forms.Label();
            this.labelSApellido = new System.Windows.Forms.Label();
            this.textBoxCI = new System.Windows.Forms.TextBox();
            this.textBoxNombres = new System.Windows.Forms.TextBox();
            this.textBoxPApellido = new System.Windows.Forms.TextBox();
            this.textBoxSApellido = new System.Windows.Forms.TextBox();
            this.dataGridViewDeudas = new System.Windows.Forms.DataGridView();
            this.buttonVerDeudas = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewDeudas)).BeginInit();
            this.SuspendLayout();
            // 
            // labelCI
            // 
            this.labelCI.AutoSize = true;
            this.labelCI.Location = new System.Drawing.Point(49, 32);
            this.labelCI.Name = "labelCI";
            this.labelCI.Size = new System.Drawing.Size(17, 13);
            this.labelCI.TabIndex = 0;
            this.labelCI.Text = "CI";
            this.labelCI.Click += new System.EventHandler(this.label1_Click);
            // 
            // labelNombres
            // 
            this.labelNombres.AutoSize = true;
            this.labelNombres.Location = new System.Drawing.Point(49, 61);
            this.labelNombres.Name = "labelNombres";
            this.labelNombres.Size = new System.Drawing.Size(49, 13);
            this.labelNombres.TabIndex = 1;
            this.labelNombres.Text = "Nombres";
            // 
            // labelPApellido
            // 
            this.labelPApellido.AutoSize = true;
            this.labelPApellido.Location = new System.Drawing.Point(49, 92);
            this.labelPApellido.Name = "labelPApellido";
            this.labelPApellido.Size = new System.Drawing.Size(76, 13);
            this.labelPApellido.TabIndex = 2;
            this.labelPApellido.Text = "Primer Apellido";
            // 
            // labelSApellido
            // 
            this.labelSApellido.AutoSize = true;
            this.labelSApellido.Location = new System.Drawing.Point(49, 128);
            this.labelSApellido.Name = "labelSApellido";
            this.labelSApellido.Size = new System.Drawing.Size(90, 13);
            this.labelSApellido.TabIndex = 3;
            this.labelSApellido.Text = "Segundo Apellido";
            // 
            // textBoxCI
            // 
            this.textBoxCI.Location = new System.Drawing.Point(145, 32);
            this.textBoxCI.Name = "textBoxCI";
            this.textBoxCI.Size = new System.Drawing.Size(100, 20);
            this.textBoxCI.TabIndex = 4;
            this.textBoxCI.Text = "1234567";
            this.textBoxCI.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // textBoxNombres
            // 
            this.textBoxNombres.Location = new System.Drawing.Point(145, 61);
            this.textBoxNombres.Name = "textBoxNombres";
            this.textBoxNombres.Size = new System.Drawing.Size(100, 20);
            this.textBoxNombres.TabIndex = 5;
            this.textBoxNombres.Text = "Juan";
            // 
            // textBoxPApellido
            // 
            this.textBoxPApellido.Location = new System.Drawing.Point(145, 92);
            this.textBoxPApellido.Name = "textBoxPApellido";
            this.textBoxPApellido.Size = new System.Drawing.Size(100, 20);
            this.textBoxPApellido.TabIndex = 6;
            this.textBoxPApellido.Text = "Pérez";
            // 
            // textBoxSApellido
            // 
            this.textBoxSApellido.Location = new System.Drawing.Point(145, 128);
            this.textBoxSApellido.Name = "textBoxSApellido";
            this.textBoxSApellido.Size = new System.Drawing.Size(100, 20);
            this.textBoxSApellido.TabIndex = 7;
            this.textBoxSApellido.Text = "García";
            // 
            // dataGridViewDeudas
            // 
            this.dataGridViewDeudas.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewDeudas.Location = new System.Drawing.Point(264, 12);
            this.dataGridViewDeudas.Name = "dataGridViewDeudas";
            this.dataGridViewDeudas.Size = new System.Drawing.Size(524, 426);
            this.dataGridViewDeudas.TabIndex = 8;
            // 
            // buttonVerDeudas
            // 
            this.buttonVerDeudas.Location = new System.Drawing.Point(76, 201);
            this.buttonVerDeudas.Name = "buttonVerDeudas";
            this.buttonVerDeudas.Size = new System.Drawing.Size(114, 23);
            this.buttonVerDeudas.TabIndex = 9;
            this.buttonVerDeudas.Text = "Verificar Deudas";
            this.buttonVerDeudas.UseVisualStyleBackColor = true;
            this.buttonVerDeudas.Click += new System.EventHandler(this.buttonVerDeudas_Click);
            // 
            // FormDeudas
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.buttonVerDeudas);
            this.Controls.Add(this.dataGridViewDeudas);
            this.Controls.Add(this.textBoxSApellido);
            this.Controls.Add(this.textBoxPApellido);
            this.Controls.Add(this.textBoxNombres);
            this.Controls.Add(this.textBoxCI);
            this.Controls.Add(this.labelSApellido);
            this.Controls.Add(this.labelPApellido);
            this.Controls.Add(this.labelNombres);
            this.Controls.Add(this.labelCI);
            this.Name = "FormDeudas";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewDeudas)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelCI;
        private System.Windows.Forms.Label labelNombres;
        private System.Windows.Forms.Label labelPApellido;
        private System.Windows.Forms.Label labelSApellido;
        private System.Windows.Forms.TextBox textBoxCI;
        private System.Windows.Forms.TextBox textBoxNombres;
        private System.Windows.Forms.TextBox textBoxPApellido;
        private System.Windows.Forms.TextBox textBoxSApellido;
        private System.Windows.Forms.DataGridView dataGridViewDeudas;
        private System.Windows.Forms.Button buttonVerDeudas;
    }
}


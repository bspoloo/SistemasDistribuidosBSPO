namespace ClienteSEGIP
{
    partial class Form1
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
            this.textBoxCI = new System.Windows.Forms.TextBox();
            this.textBoxNombres = new System.Windows.Forms.TextBox();
            this.textBoxPApellido = new System.Windows.Forms.TextBox();
            this.textBoxSApellido = new System.Windows.Forms.TextBox();
            this.labelNombres = new System.Windows.Forms.Label();
            this.labelPApellido = new System.Windows.Forms.Label();
            this.labelSApellido = new System.Windows.Forms.Label();
            this.labelCI = new System.Windows.Forms.Label();
            this.buttonBuscarCi = new System.Windows.Forms.Button();
            this.buttonBuscarTodo = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.ci = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nombres = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.primer_apellido = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.segundo_apellido = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // textBoxCI
            // 
            this.textBoxCI.Location = new System.Drawing.Point(115, 31);
            this.textBoxCI.Name = "textBoxCI";
            this.textBoxCI.Size = new System.Drawing.Size(185, 20);
            this.textBoxCI.TabIndex = 0;
            // 
            // textBoxNombres
            // 
            this.textBoxNombres.Location = new System.Drawing.Point(115, 149);
            this.textBoxNombres.Name = "textBoxNombres";
            this.textBoxNombres.Size = new System.Drawing.Size(185, 20);
            this.textBoxNombres.TabIndex = 1;
            // 
            // textBoxPApellido
            // 
            this.textBoxPApellido.Location = new System.Drawing.Point(115, 175);
            this.textBoxPApellido.Name = "textBoxPApellido";
            this.textBoxPApellido.Size = new System.Drawing.Size(185, 20);
            this.textBoxPApellido.TabIndex = 2;
            // 
            // textBoxSApellido
            // 
            this.textBoxSApellido.Location = new System.Drawing.Point(115, 201);
            this.textBoxSApellido.Name = "textBoxSApellido";
            this.textBoxSApellido.Size = new System.Drawing.Size(185, 20);
            this.textBoxSApellido.TabIndex = 3;
            // 
            // labelNombres
            // 
            this.labelNombres.AutoSize = true;
            this.labelNombres.Location = new System.Drawing.Point(60, 149);
            this.labelNombres.Name = "labelNombres";
            this.labelNombres.Size = new System.Drawing.Size(49, 13);
            this.labelNombres.TabIndex = 4;
            this.labelNombres.Text = "Nombres";
            // 
            // labelPApellido
            // 
            this.labelPApellido.AutoSize = true;
            this.labelPApellido.Location = new System.Drawing.Point(36, 175);
            this.labelPApellido.Name = "labelPApellido";
            this.labelPApellido.Size = new System.Drawing.Size(73, 13);
            this.labelPApellido.TabIndex = 5;
            this.labelPApellido.Text = "PrimerApellido";
            // 
            // labelSApellido
            // 
            this.labelSApellido.AutoSize = true;
            this.labelSApellido.Location = new System.Drawing.Point(19, 201);
            this.labelSApellido.Name = "labelSApellido";
            this.labelSApellido.Size = new System.Drawing.Size(90, 13);
            this.labelSApellido.TabIndex = 6;
            this.labelSApellido.Text = "Segundo Apellido";
            // 
            // labelCI
            // 
            this.labelCI.AutoSize = true;
            this.labelCI.Location = new System.Drawing.Point(56, 34);
            this.labelCI.Name = "labelCI";
            this.labelCI.Size = new System.Drawing.Size(53, 13);
            this.labelCI.TabIndex = 7;
            this.labelCI.Text = "N° Carnet";
            // 
            // buttonBuscarCi
            // 
            this.buttonBuscarCi.Location = new System.Drawing.Point(164, 67);
            this.buttonBuscarCi.Name = "buttonBuscarCi";
            this.buttonBuscarCi.Size = new System.Drawing.Size(75, 23);
            this.buttonBuscarCi.TabIndex = 8;
            this.buttonBuscarCi.Text = "Buscar";
            this.buttonBuscarCi.UseVisualStyleBackColor = true;
            this.buttonBuscarCi.Click += new System.EventHandler(this.buttonBuscarCi_Click);
            // 
            // buttonBuscarTodo
            // 
            this.buttonBuscarTodo.Location = new System.Drawing.Point(164, 240);
            this.buttonBuscarTodo.Name = "buttonBuscarTodo";
            this.buttonBuscarTodo.Size = new System.Drawing.Size(75, 23);
            this.buttonBuscarTodo.TabIndex = 9;
            this.buttonBuscarTodo.Text = "Buscar";
            this.buttonBuscarTodo.UseVisualStyleBackColor = true;
            this.buttonBuscarTodo.Click += new System.EventHandler(this.buttonBuscarTodo_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ci,
            this.nombres,
            this.primer_apellido,
            this.segundo_apellido});
            this.dataGridView1.Location = new System.Drawing.Point(306, 12);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(482, 426);
            this.dataGridView1.TabIndex = 10;
            // 
            // ci
            // 
            this.ci.HeaderText = "Nro de carnet";
            this.ci.Name = "ci";
            // 
            // nombres
            // 
            this.nombres.HeaderText = "Nombres";
            this.nombres.Name = "nombres";
            // 
            // primer_apellido
            // 
            this.primer_apellido.HeaderText = "Primer Apellido";
            this.primer_apellido.Name = "primer_apellido";
            // 
            // segundo_apellido
            // 
            this.segundo_apellido.HeaderText = "Segundo Apellido";
            this.segundo_apellido.Name = "segundo_apellido";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.buttonBuscarTodo);
            this.Controls.Add(this.buttonBuscarCi);
            this.Controls.Add(this.labelCI);
            this.Controls.Add(this.labelSApellido);
            this.Controls.Add(this.labelPApellido);
            this.Controls.Add(this.labelNombres);
            this.Controls.Add(this.textBoxSApellido);
            this.Controls.Add(this.textBoxPApellido);
            this.Controls.Add(this.textBoxNombres);
            this.Controls.Add(this.textBoxCI);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxCI;
        private System.Windows.Forms.TextBox textBoxNombres;
        private System.Windows.Forms.TextBox textBoxPApellido;
        private System.Windows.Forms.TextBox textBoxSApellido;
        private System.Windows.Forms.Label labelNombres;
        private System.Windows.Forms.Label labelPApellido;
        private System.Windows.Forms.Label labelSApellido;
        private System.Windows.Forms.Label labelCI;
        private System.Windows.Forms.Button buttonBuscarCi;
        private System.Windows.Forms.Button buttonBuscarTodo;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn ci;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombres;
        private System.Windows.Forms.DataGridViewTextBoxColumn primer_apellido;
        private System.Windows.Forms.DataGridViewTextBoxColumn segundo_apellido;
    }
}


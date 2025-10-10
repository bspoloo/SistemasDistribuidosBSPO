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
            this.labelCi = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.buttonCI = new System.Windows.Forms.Button();
            this.BuscarTodo = new System.Windows.Forms.Button();
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
            this.textBoxCI.Location = new System.Drawing.Point(132, 26);
            this.textBoxCI.Name = "textBoxCI";
            this.textBoxCI.Size = new System.Drawing.Size(163, 20);
            this.textBoxCI.TabIndex = 0;
            // 
            // textBoxNombres
            // 
            this.textBoxNombres.Location = new System.Drawing.Point(132, 140);
            this.textBoxNombres.Name = "textBoxNombres";
            this.textBoxNombres.Size = new System.Drawing.Size(163, 20);
            this.textBoxNombres.TabIndex = 1;
            // 
            // textBoxPApellido
            // 
            this.textBoxPApellido.Location = new System.Drawing.Point(132, 166);
            this.textBoxPApellido.Name = "textBoxPApellido";
            this.textBoxPApellido.Size = new System.Drawing.Size(163, 20);
            this.textBoxPApellido.TabIndex = 2;
            // 
            // textBoxSApellido
            // 
            this.textBoxSApellido.Location = new System.Drawing.Point(132, 192);
            this.textBoxSApellido.Name = "textBoxSApellido";
            this.textBoxSApellido.Size = new System.Drawing.Size(163, 20);
            this.textBoxSApellido.TabIndex = 3;
            // 
            // labelCi
            // 
            this.labelCi.AutoSize = true;
            this.labelCi.Location = new System.Drawing.Point(94, 26);
            this.labelCi.Name = "labelCi";
            this.labelCi.Size = new System.Drawing.Size(17, 13);
            this.labelCi.TabIndex = 4;
            this.labelCi.Text = "CI";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(62, 140);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(49, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "Nombres";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(35, 166);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(76, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Primer Apellido";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(27, 195);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(84, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Segund Apellido";
            // 
            // buttonCI
            // 
            this.buttonCI.Location = new System.Drawing.Point(173, 63);
            this.buttonCI.Name = "buttonCI";
            this.buttonCI.Size = new System.Drawing.Size(75, 23);
            this.buttonCI.TabIndex = 8;
            this.buttonCI.Text = "Buscar";
            this.buttonCI.UseVisualStyleBackColor = true;
            this.buttonCI.Click += new System.EventHandler(this.buttonCI_Click);
            // 
            // BuscarTodo
            // 
            this.BuscarTodo.Location = new System.Drawing.Point(173, 232);
            this.BuscarTodo.Name = "BuscarTodo";
            this.BuscarTodo.Size = new System.Drawing.Size(75, 23);
            this.BuscarTodo.TabIndex = 9;
            this.BuscarTodo.Text = "Buscar";
            this.BuscarTodo.UseVisualStyleBackColor = true;
            this.BuscarTodo.Click += new System.EventHandler(this.BuscarTodo_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ci,
            this.nombres,
            this.primer_apellido,
            this.segundo_apellido});
            this.dataGridView1.Location = new System.Drawing.Point(329, 36);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(452, 377);
            this.dataGridView1.TabIndex = 10;
            // 
            // ci
            // 
            this.ci.HeaderText = "Numero de Documento";
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
            this.Controls.Add(this.BuscarTodo);
            this.Controls.Add(this.buttonCI);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.labelCi);
            this.Controls.Add(this.textBoxSApellido);
            this.Controls.Add(this.textBoxPApellido);
            this.Controls.Add(this.textBoxNombres);
            this.Controls.Add(this.textBoxCI);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxCI;
        private System.Windows.Forms.TextBox textBoxNombres;
        private System.Windows.Forms.TextBox textBoxPApellido;
        private System.Windows.Forms.TextBox textBoxSApellido;
        private System.Windows.Forms.Label labelCi;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button buttonCI;
        private System.Windows.Forms.Button BuscarTodo;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn ci;
        private System.Windows.Forms.DataGridViewTextBoxColumn nombres;
        private System.Windows.Forms.DataGridViewTextBoxColumn primer_apellido;
        private System.Windows.Forms.DataGridViewTextBoxColumn segundo_apellido;
    }
}


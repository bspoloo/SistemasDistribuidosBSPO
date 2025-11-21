namespace ClienteSeduinfo
{
    partial class Form1
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
            this.textBoxCI = new System.Windows.Forms.TextBox();
            this.buttonAcademicos = new System.Windows.Forms.Button();
            this.buttonTutor = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelCI
            // 
            this.labelCI.AutoSize = true;
            this.labelCI.Location = new System.Drawing.Point(197, 94);
            this.labelCI.Name = "labelCI";
            this.labelCI.Size = new System.Drawing.Size(86, 13);
            this.labelCI.TabIndex = 0;
            this.labelCI.Text = "CI del estudiante";
            this.labelCI.Click += new System.EventHandler(this.labelCI_Click);
            // 
            // textBoxCI
            // 
            this.textBoxCI.Location = new System.Drawing.Point(290, 94);
            this.textBoxCI.Name = "textBoxCI";
            this.textBoxCI.Size = new System.Drawing.Size(158, 20);
            this.textBoxCI.TabIndex = 1;
            this.textBoxCI.Text = "12345678";
            this.textBoxCI.TextChanged += new System.EventHandler(this.textBoxCI_TextChanged);
            // 
            // buttonAcademicos
            // 
            this.buttonAcademicos.Location = new System.Drawing.Point(200, 120);
            this.buttonAcademicos.Name = "buttonAcademicos";
            this.buttonAcademicos.Size = new System.Drawing.Size(248, 23);
            this.buttonAcademicos.TabIndex = 2;
            this.buttonAcademicos.Text = "Obtener Datos Academicos";
            this.buttonAcademicos.UseVisualStyleBackColor = true;
            this.buttonAcademicos.Click += new System.EventHandler(this.button1_Click);
            // 
            // buttonTutor
            // 
            this.buttonTutor.Location = new System.Drawing.Point(200, 149);
            this.buttonTutor.Name = "buttonTutor";
            this.buttonTutor.Size = new System.Drawing.Size(248, 23);
            this.buttonTutor.TabIndex = 3;
            this.buttonTutor.Text = "Obtener Datos del Tutor";
            this.buttonTutor.UseVisualStyleBackColor = true;
            this.buttonTutor.Click += new System.EventHandler(this.button2_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(656, 276);
            this.Controls.Add(this.buttonTutor);
            this.Controls.Add(this.buttonAcademicos);
            this.Controls.Add(this.textBoxCI);
            this.Controls.Add(this.labelCI);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelCI;
        private System.Windows.Forms.TextBox textBoxCI;
        private System.Windows.Forms.Button buttonAcademicos;
        private System.Windows.Forms.Button buttonTutor;
    }
}


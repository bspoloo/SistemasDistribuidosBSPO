namespace ClientVentas
{
    partial class FormResponse
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
            this.labelFecha = new System.Windows.Forms.Label();
            this.labelCotizacion = new System.Windows.Forms.Label();
            this.labelOficial = new System.Windows.Forms.Label();
            this.textBoxFecha = new System.Windows.Forms.TextBox();
            this.textBoxCotizacion = new System.Windows.Forms.TextBox();
            this.textBoxOficial = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // labelFecha
            // 
            this.labelFecha.AutoSize = true;
            this.labelFecha.Location = new System.Drawing.Point(47, 38);
            this.labelFecha.Name = "labelFecha";
            this.labelFecha.Size = new System.Drawing.Size(37, 13);
            this.labelFecha.TabIndex = 0;
            this.labelFecha.Text = "Fecha";
            this.labelFecha.Click += new System.EventHandler(this.labelFecha_Click);
            // 
            // labelCotizacion
            // 
            this.labelCotizacion.AutoSize = true;
            this.labelCotizacion.Location = new System.Drawing.Point(47, 74);
            this.labelCotizacion.Name = "labelCotizacion";
            this.labelCotizacion.Size = new System.Drawing.Size(56, 13);
            this.labelCotizacion.TabIndex = 1;
            this.labelCotizacion.Text = "Cotizacion";
            this.labelCotizacion.Click += new System.EventHandler(this.labelCotizacion_Click);
            // 
            // labelOficial
            // 
            this.labelOficial.AutoSize = true;
            this.labelOficial.Location = new System.Drawing.Point(47, 108);
            this.labelOficial.Name = "labelOficial";
            this.labelOficial.Size = new System.Drawing.Size(89, 13);
            this.labelOficial.TabIndex = 2;
            this.labelOficial.Text = "Cotizacion Actual";
            this.labelOficial.Click += new System.EventHandler(this.labelCotizacionActual_Click);
            // 
            // textBoxFecha
            // 
            this.textBoxFecha.Location = new System.Drawing.Point(151, 38);
            this.textBoxFecha.Name = "textBoxFecha";
            this.textBoxFecha.Size = new System.Drawing.Size(100, 20);
            this.textBoxFecha.TabIndex = 3;
            this.textBoxFecha.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // textBoxCotizacion
            // 
            this.textBoxCotizacion.Location = new System.Drawing.Point(151, 74);
            this.textBoxCotizacion.Name = "textBoxCotizacion";
            this.textBoxCotizacion.Size = new System.Drawing.Size(100, 20);
            this.textBoxCotizacion.TabIndex = 4;
            // 
            // textBoxOficial
            // 
            this.textBoxOficial.Location = new System.Drawing.Point(151, 108);
            this.textBoxOficial.Name = "textBoxOficial";
            this.textBoxOficial.Size = new System.Drawing.Size(100, 20);
            this.textBoxOficial.TabIndex = 5;
            // 
            // FormResponse
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(358, 151);
            this.Controls.Add(this.textBoxOficial);
            this.Controls.Add(this.textBoxCotizacion);
            this.Controls.Add(this.textBoxFecha);
            this.Controls.Add(this.labelOficial);
            this.Controls.Add(this.labelCotizacion);
            this.Controls.Add(this.labelFecha);
            this.Name = "FormResponse";
            this.Text = "FormResponse";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelFecha;
        private System.Windows.Forms.Label labelCotizacion;
        private System.Windows.Forms.Label labelOficial;
        private System.Windows.Forms.TextBox textBoxFecha;
        private System.Windows.Forms.TextBox textBoxCotizacion;
        private System.Windows.Forms.TextBox textBoxOficial;
    }
}
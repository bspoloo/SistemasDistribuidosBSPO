namespace Cliente
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
            this.textBoxFecha = new System.Windows.Forms.TextBox();
            this.textBoxCEsp = new System.Windows.Forms.TextBox();
            this.buttonInsertREST = new System.Windows.Forms.Button();
            this.buttonInsertGraphQL = new System.Windows.Forms.Button();
            this.buttonUpdateGraphQL = new System.Windows.Forms.Button();
            this.buttonUpdateREST = new System.Windows.Forms.Button();
            this.textBoxID = new System.Windows.Forms.TextBox();
            this.dataGridViewPron = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewPron)).BeginInit();
            this.SuspendLayout();
            // 
            // textBoxFecha
            // 
            this.textBoxFecha.Location = new System.Drawing.Point(94, 35);
            this.textBoxFecha.Name = "textBoxFecha";
            this.textBoxFecha.Size = new System.Drawing.Size(207, 20);
            this.textBoxFecha.TabIndex = 0;
            this.textBoxFecha.Text = "2024-12-23";
            // 
            // textBoxCEsp
            // 
            this.textBoxCEsp.Location = new System.Drawing.Point(94, 61);
            this.textBoxCEsp.Name = "textBoxCEsp";
            this.textBoxCEsp.Size = new System.Drawing.Size(207, 20);
            this.textBoxCEsp.TabIndex = 1;
            this.textBoxCEsp.Text = "333";
            // 
            // buttonInsertREST
            // 
            this.buttonInsertREST.Location = new System.Drawing.Point(94, 96);
            this.buttonInsertREST.Name = "buttonInsertREST";
            this.buttonInsertREST.Size = new System.Drawing.Size(88, 23);
            this.buttonInsertREST.TabIndex = 2;
            this.buttonInsertREST.Text = "Insertar REST";
            this.buttonInsertREST.UseVisualStyleBackColor = true;
            this.buttonInsertREST.Click += new System.EventHandler(this.buttonInsertREST_Click);
            // 
            // buttonInsertGraphQL
            // 
            this.buttonInsertGraphQL.Location = new System.Drawing.Point(199, 96);
            this.buttonInsertGraphQL.Name = "buttonInsertGraphQL";
            this.buttonInsertGraphQL.Size = new System.Drawing.Size(102, 23);
            this.buttonInsertGraphQL.TabIndex = 3;
            this.buttonInsertGraphQL.Text = "Insertar GraphQL";
            this.buttonInsertGraphQL.UseVisualStyleBackColor = true;
            this.buttonInsertGraphQL.Click += new System.EventHandler(this.buttonInsertGraphQL_Click);
            // 
            // buttonUpdateGraphQL
            // 
            this.buttonUpdateGraphQL.Location = new System.Drawing.Point(188, 125);
            this.buttonUpdateGraphQL.Name = "buttonUpdateGraphQL";
            this.buttonUpdateGraphQL.Size = new System.Drawing.Size(113, 23);
            this.buttonUpdateGraphQL.TabIndex = 5;
            this.buttonUpdateGraphQL.Text = "Actualizar GraphQL";
            this.buttonUpdateGraphQL.UseVisualStyleBackColor = true;
            this.buttonUpdateGraphQL.Click += new System.EventHandler(this.buttonUpdateGraphQL_Click);
            // 
            // buttonUpdateREST
            // 
            this.buttonUpdateREST.Location = new System.Drawing.Point(94, 125);
            this.buttonUpdateREST.Name = "buttonUpdateREST";
            this.buttonUpdateREST.Size = new System.Drawing.Size(99, 23);
            this.buttonUpdateREST.TabIndex = 4;
            this.buttonUpdateREST.Text = "Actualizar REST";
            this.buttonUpdateREST.UseVisualStyleBackColor = true;
            this.buttonUpdateREST.Click += new System.EventHandler(this.buttonUpdateREST_Click);
            // 
            // textBoxID
            // 
            this.textBoxID.Location = new System.Drawing.Point(94, 12);
            this.textBoxID.Name = "textBoxID";
            this.textBoxID.Size = new System.Drawing.Size(207, 20);
            this.textBoxID.TabIndex = 6;
            this.textBoxID.Text = "1";
            // 
            // dataGridViewPron
            // 
            this.dataGridViewPron.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewPron.Location = new System.Drawing.Point(336, 25);
            this.dataGridViewPron.Name = "dataGridViewPron";
            this.dataGridViewPron.Size = new System.Drawing.Size(452, 413);
            this.dataGridViewPron.TabIndex = 7;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.dataGridViewPron);
            this.Controls.Add(this.textBoxID);
            this.Controls.Add(this.buttonUpdateGraphQL);
            this.Controls.Add(this.buttonUpdateREST);
            this.Controls.Add(this.buttonInsertGraphQL);
            this.Controls.Add(this.buttonInsertREST);
            this.Controls.Add(this.textBoxCEsp);
            this.Controls.Add(this.textBoxFecha);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewPron)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBoxFecha;
        private System.Windows.Forms.TextBox textBoxCEsp;
        private System.Windows.Forms.Button buttonInsertREST;
        private System.Windows.Forms.Button buttonInsertGraphQL;
        private System.Windows.Forms.Button buttonUpdateGraphQL;
        private System.Windows.Forms.Button buttonUpdateREST;
        private System.Windows.Forms.TextBox textBoxID;
        private System.Windows.Forms.DataGridView dataGridViewPron;
    }
}


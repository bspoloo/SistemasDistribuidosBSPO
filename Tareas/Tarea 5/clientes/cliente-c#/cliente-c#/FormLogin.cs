using cliente_c_.classes;
using cliente_c_.Services;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace cliente_c_
{
    public partial class FormLogin : Form
    {
        private LoginService loginService;
        public FormLogin()
        {
            this.loginService = new LoginService("http://127.0.0.1:8000/api/login");
            InitializeComponent();
        }

        private void FormLogin_Load(object sender, EventArgs e)
        {

        }

        private async void buttonLogin_Click(object sender, EventArgs e)
        {
            LoginResponse response = await this.loginService.Authenticate(textEmail.Text.ToString(), textBoxPassword.Text.ToString());

            DialogResult result = MessageBox.Show(
                response.Mensaje,
                "Respuesta de login",
                MessageBoxButtons.OKCancel,
                MessageBoxIcon.Question
            );

            if (result == DialogResult.OK)
            {
                FormCRUD formCrud = new FormCRUD();
                formCrud.Show();
                this.Hide();
            }
        }
    }
}

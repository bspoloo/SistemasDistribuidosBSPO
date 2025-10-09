package primerparcial;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.rmi.Naming;
import primerparcial.clases.Cuenta;
import primerparcial.clases.Respuesta;
import primerparcial.interfaces.IJusticia;

public class Juez extends JFrame {

    // --- Componentes de la Interfaz ---
    private final JTextField txtCi;
    private final JTextField txtNombres;
    private final JTextField txtApellidos;
    private final JButton btnConsultar;

    // En lugar de JTextArea -> JTable
    private final JTable tablaResultados;
    private final DefaultTableModel modeloTabla;

    public Juez() {
        setTitle("Sistema de Consulta Judicial (Simple)");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- Panel de entrada ---
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelEntrada.add(new JLabel("CI:"));
        txtCi = new JTextField("11021654");
        panelEntrada.add(txtCi);

        panelEntrada.add(new JLabel("Nombres:"));
        txtNombres = new JTextField("Juan Perez");
        panelEntrada.add(txtNombres);

        panelEntrada.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField("Segovia");
        panelEntrada.add(txtApellidos);

        // --- Botón ---
        btnConsultar = new JButton("Consultar");
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnConsultar);

        // --- Tabla ---
        String[] columnas = {"Banco", "Nro Cuenta", "Saldo"};
        modeloTabla = new DefaultTableModel(columnas, 0); // 0 filas iniciales
        tablaResultados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaResultados);

        // --- Añadir componentes a la ventana ---
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        // --- Acción del botón ---
        btnConsultar.addActionListener((ActionEvent e) -> {
            consultar();
        });
    }

    private void consultar() {
        // Limpiamos la tabla antes de cada consulta
        modeloTabla.setRowCount(0);

        try {
            String ci = txtCi.getText();
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();

            IJusticia justicia = (IJusticia) Naming.lookup("rmi://localhost/justicia");
            Respuesta respuesta = justicia.consultarCuentas(ci, nombres, apellidos);

            if (!respuesta.isError() && respuesta.getCuentas() != null && !respuesta.getCuentas().isEmpty()) {
                for (Cuenta cuenta : respuesta.getCuentas()) {
                    Object[] fila = {
                        cuenta.getBanco(),
                        cuenta.getNro_cuenta(),
                        cuenta.getSaldo()
                    };
                    modeloTabla.addRow(fila);
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Respuesta del servidor:\n" + respuesta.getMensajeError(),
                        "Sin resultados",
                        JOptionPane.WARNING_MESSAGE);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "ERROR DE CONEXIÓN:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Juez().setVisible(true));
    }
}

package primerparcial;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.rmi.Naming;
import primerparcial.clases.Cuenta;
import primerparcial.clases.Respuesta;
import primerparcial.interfaces.IJusticia;

/**
 * Versión simplificada del cliente para la Justicia.
 * @author moka
 */
public class Juez extends JFrame {

    // --- Componentes de la Interfaz ---
    private final JTextField txtCi;
    private final JTextField txtNombres;
    private final JTextField txtApellidos;
    private final JButton btnConsultar;
    private final JTextArea areaResultados;

    public Juez() {
        // --- 1. Configuración de la Ventana ---
        setTitle("Sistema de Consulta Judicial (Simple)");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new BorderLayout(10, 10)); // Usamos un layout principal

        // --- 2. Panel para los campos de entrada (arriba) ---
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen

        // Añadimos etiquetas y campos de texto
        panelEntrada.add(new JLabel("CI:"));
        txtCi = new JTextField("11021654");
        panelEntrada.add(txtCi);

        panelEntrada.add(new JLabel("Nombres:"));
        txtNombres = new JTextField("Juan Perez");
        panelEntrada.add(txtNombres);

        panelEntrada.add(new JLabel("Apellidos:"));
        txtApellidos = new JTextField("Segovia");
        panelEntrada.add(txtApellidos);
        
        // --- 3. Botón de consulta (abajo) ---
        btnConsultar = new JButton("Consultar");
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnConsultar);

        // --- 4. Área para mostrar resultados (centro) ---
        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultados); // Para añadir barra de scroll

        // --- 5. Añadimos los paneles a la ventana ---
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelBoton, BorderLayout.SOUTH);

        // --- 6. Lógica del Botón (la acción a realizar) ---
        btnConsultar.addActionListener((ActionEvent e) -> {
            consultar();
        });
    }
    
    private void consultar() {
        areaResultados.setText("Consultando, por favor espere...");
        
        try {
            // Obtenemos los datos de la interfaz
            String ci = txtCi.getText();
            String nombres = txtNombres.getText();
            String apellidos = txtApellidos.getText();

            // Buscamos el servicio RMI en el servidor
            IJusticia justicia = (IJusticia) Naming.lookup("rmi://localhost/justicia");
            
            // Llamamos al método remoto
            Respuesta respuesta = justicia.consultarCuentas(ci, nombres, apellidos);

            // Procesamos y mostramos la respuesta en el JTextArea
            if (!respuesta.isError() && respuesta.getCuentas() != null && !respuesta.getCuentas().isEmpty()) {
                StringBuilder resultadoTexto = new StringBuilder("--- Cuentas Encontradas ---\n\n");
                for (Cuenta cuenta : respuesta.getCuentas()) {
                    resultadoTexto.append("Banco: ").append(cuenta.getBanco())
                                  .append(" | Cuenta: ").append(cuenta.getNro_cuenta())
                                  .append(" | Saldo: ").append(cuenta.getSaldo()).append("\n");
                }
                areaResultados.setText(resultadoTexto.toString());
            } else {
                areaResultados.setText("Respuesta del servidor:\n" + respuesta.getMensajeError());
            }

        } catch (Exception ex) {
            // Si algo falla (red, servidor no encontrado, etc.), mostramos el error
            areaResultados.setText("ERROR DE CONEXIÓN:\n" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Crea y muestra la ventana de forma segura
        SwingUtilities.invokeLater(() -> new Juez().setVisible(true));
    }
}
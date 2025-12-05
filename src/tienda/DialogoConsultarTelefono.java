package tienda;

import javax.swing.*;
import java.awt.*;

/**
 * DialogoConsultarTelefono - Ventana modal para ver detalles de un teléfono
 *
 * Muestra un diálogo donde el usuario puede seleccionar
 * un modelo y ver sus atributos (marca, color, procesador, precio, etc.).
 * Los campos son de solo lectura para evitar modificaciones accidentales.
 */
public class DialogoConsultarTelefono extends JDialog {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboModelos;
    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtColor;
    private JTextField txtCamara;
    private JTextField txtCamaraFrontal;
    private JTextField txtProcesador;
    private JTextField txtPantalla;
    private JTextField txtPeso;
    private JTextField txtSO;
    private JTextField txtAlmacenamiento;
    private JTextField txtMemoria;
    private JTextField txtPrecio;
    private JTextField txtMedidas;
    private JTextField txtPlan;
    private JButton btnCerrar;
    
    public DialogoConsultarTelefono(JFrame padre) {
        super(padre, "Consultar Teléfono Móvil", true);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setSize(650, 650);
            setLocationRelativeTo(padre);
            setResizable(false);

            // Permitir cerrar con Escape
            getRootPane().registerKeyboardAction(e -> dispose(),
                KeyStroke.getKeyStroke("ESCAPE"),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        crearComponentes();
        cargarModelos();
        if (DatosGlobales.getCantidadTelefonos() > 0) {
            mostrarDatos(0);
        }
    }
    
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 12, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Estética: fuentes y fondo
        Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 12);
        panelPrincipal.setBackground(new Color(250, 250, 250));
        
        // Etiqueta y combo de modelos
        JLabel lblModelo = new JLabel("Seleccionar Modelo:");
        lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(lblModelo, gbc);
        
        comboModelos = new JComboBox<>();
        comboModelos.setPreferredSize(new Dimension(240, 24));
        comboModelos.addActionListener(e -> actualizarDatos());
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panelPrincipal.add(comboModelos, gbc);
        gbc.weightx = 0;
        
        // Campos de texto
        java.util.List<String> etiquetas = new java.util.LinkedList<>();
        etiquetas.add("Marca:");
        etiquetas.add("Modelo:");
        etiquetas.add("Color:");
        etiquetas.add("Procesador:");
        etiquetas.add("Pantalla:");
        etiquetas.add("Peso:");
        etiquetas.add("Cámara Principal:");
        etiquetas.add("Cámara Frontal:");
        etiquetas.add("Sistema Operativo:");
        etiquetas.add("Almacenamiento:");
        etiquetas.add("Memoria:");
        etiquetas.add("Precio (S/):");
        etiquetas.add("Medidas (cm):");
        etiquetas.add("Plan:");
        java.util.List<JTextField> campos = new java.util.LinkedList<>();
        
        for (int i = 0; i < etiquetas.size(); i++) {
            JLabel lbl = new JLabel(etiquetas.get(i));
            lbl.setHorizontalAlignment(SwingConstants.RIGHT);
            lbl.setFont(labelFont);
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.anchor = GridBagConstraints.EAST;
            panelPrincipal.add(lbl, gbc);

            JTextField campo = new JTextField(1);
            campo.setEditable(false);
            campo.setPreferredSize(new Dimension(240, 24));
            campo.setFont(fieldFont);
            campos.add(campo);
            gbc.gridx = 1;
            gbc.weightx = 1.0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            panelPrincipal.add(campo, gbc);
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        }
        
        txtMarca = campos.get(0);
        txtModelo = campos.get(1);
        txtColor = campos.get(2);
        txtProcesador = campos.get(3);
        txtPantalla = campos.get(4);
        txtPeso = campos.get(5);
        txtCamara = campos.get(6);
        txtCamaraFrontal = campos.get(7);
        txtSO = campos.get(8);
        txtAlmacenamiento = campos.get(9);
        txtMemoria = campos.get(10);
        txtPrecio = campos.get(11);
        txtMedidas = campos.get(12);
        txtPlan = campos.get(13);
        
        // Botón Cerrar
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        btnCerrar.setFont(labelFont);
        btnCerrar.setPreferredSize(new Dimension(100, 28));
        btnCerrar.setBackground(new Color(230, 230, 230));
        gbc.gridx = 0;
        gbc.gridy = etiquetas.size() + 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(btnCerrar, gbc);
        
        add(panelPrincipal);
    }
    
    private void cargarModelos() {
        comboModelos.removeAllItems();
        for (int i = 0; i < DatosGlobales.getCantidadTelefonos(); i++) {
            Telefono t = DatosGlobales.getTelefono(i);
            if (t != null) comboModelos.addItem(t.getModelo());
        }
    }
    
    private void actualizarDatos() {
        int indice = comboModelos.getSelectedIndex();
        if (indice >= 0) {
            mostrarDatos(indice);
        }
    }
    
    private void mostrarDatos(int indice) {
        if (indice >= 0 && indice < DatosGlobales.getCantidadTelefonos()) {
            Telefono tel = DatosGlobales.getTelefono(indice);
            txtMarca.setText(tel.getMarca());
            txtModelo.setText(tel.getModelo());
            txtColor.setText(tel.getColor());
            txtProcesador.setText(tel.getProcesador());
            txtPantalla.setText(tel.getPantalla());
            txtPeso.setText(tel.getPeso());
            txtCamara.setText(tel.getCamaraPrincipal());
            txtCamaraFrontal.setText(tel.getCamaraFrontal());
            txtSO.setText(tel.getSistemaOperativo());
            txtAlmacenamiento.setText(tel.getCapacidadAlmacenamiento());
            txtMemoria.setText(tel.getMemoria());
            txtPrecio.setText(DatosGlobales.formatoMoneda(tel.getPrecio()));
            txtMedidas.setText(tel.getMedidas());
            txtPlan.setText(tel.getTipoPlan());
        }
    }
}

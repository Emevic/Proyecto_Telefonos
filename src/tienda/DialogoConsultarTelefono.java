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
    
    // Componentes para edición gráfica
    private JPanel panelPrincipal;
    private JLabel lblModelo;
    private JComboBox<String> comboModelos;
    private JLabel lblMarca;
    private JTextField txtMarca;
    private JLabel lblModelo2;
    private JTextField txtModelo;
    private JLabel lblColor;
    private JTextField txtColor;
    private JLabel lblProcesador;
    private JTextField txtProcesador;
    private JLabel lblPantalla;
    private JTextField txtPantalla;
    private JLabel lblPeso;
    private JTextField txtPeso;
    private JLabel lblCamara;
    private JTextField txtCamara;
    private JLabel lblCamaraFrontal;
    private JTextField txtCamaraFrontal;
    private JLabel lblSO;
    private JTextField txtSO;
    private JLabel lblAlmacenamiento;
    private JTextField txtAlmacenamiento;
    private JLabel lblMemoria;
    private JTextField txtMemoria;
    private JLabel lblPrecio;
    private JTextField txtPrecio;
    private JLabel lblMedidas;
    private JTextField txtMedidas;
    private JLabel lblPlan;
    private JTextField txtPlan;
    private JButton btnCerrar;
    
    /**
     * Constructor del diálogo Consultar Teléfono
     * @param padre Ventana padre para centrar el diálogo
     */
    public DialogoConsultarTelefono(JFrame padre) {
        super(padre, "Consultar Tel\u00E9fono M\u00F3vil", true);
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
    
    /**
     * Crea y configura todos los componentes visuales del diálogo
     */
    private void crearComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null); // Absolute layout for visual editor compatibility
        panelPrincipal.setBackground(new Color(250, 250, 250));
        
        // Estética: fuentes
        Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 12);
        
        // Etiqueta y combo de modelos
        lblModelo = new JLabel("Seleccionar Modelo:");
        lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
        lblModelo.setFont(labelFont);
        lblModelo.setBounds(50, 20, 150, 20);
        panelPrincipal.add(lblModelo);
        
        comboModelos = new JComboBox<>();
        comboModelos.setBounds(220, 20, 240, 24);
        comboModelos.addActionListener(e -> actualizarDatos());
        panelPrincipal.add(comboModelos);
        
        // Campos de texto con etiquetas
        lblMarca = new JLabel("Marca:");
        lblMarca.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMarca.setFont(labelFont);
        lblMarca.setBounds(50, 60, 150, 20);
        panelPrincipal.add(lblMarca);
        
        txtMarca = new JTextField();
        txtMarca.setEditable(false);
        txtMarca.setFont(fieldFont);
        txtMarca.setBounds(220, 60, 240, 24);
        panelPrincipal.add(txtMarca);
        
        lblModelo2 = new JLabel("Modelo:");
        lblModelo2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblModelo2.setFont(labelFont);
        lblModelo2.setBounds(50, 95, 150, 20);
        panelPrincipal.add(lblModelo2);
        
        txtModelo = new JTextField();
        txtModelo.setEditable(false);
        txtModelo.setFont(fieldFont);
        txtModelo.setBounds(220, 95, 240, 24);
        panelPrincipal.add(txtModelo);
        
        lblColor = new JLabel("Color:");
        lblColor.setHorizontalAlignment(SwingConstants.RIGHT);
        lblColor.setFont(labelFont);
        lblColor.setBounds(50, 130, 150, 20);
        panelPrincipal.add(lblColor);
        
        txtColor = new JTextField();
        txtColor.setEditable(false);
        txtColor.setFont(fieldFont);
        txtColor.setBounds(220, 130, 240, 24);
        panelPrincipal.add(txtColor);
        
        lblProcesador = new JLabel("Procesador:");
        lblProcesador.setHorizontalAlignment(SwingConstants.RIGHT);
        lblProcesador.setFont(labelFont);
        lblProcesador.setBounds(50, 165, 150, 20);
        panelPrincipal.add(lblProcesador);
        
        txtProcesador = new JTextField();
        txtProcesador.setEditable(false);
        txtProcesador.setFont(fieldFont);
        txtProcesador.setBounds(220, 165, 240, 24);
        panelPrincipal.add(txtProcesador);
        
        lblPantalla = new JLabel("Pantalla:");
        lblPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPantalla.setFont(labelFont);
        lblPantalla.setBounds(50, 200, 150, 20);
        panelPrincipal.add(lblPantalla);
        
        txtPantalla = new JTextField();
        txtPantalla.setEditable(false);
        txtPantalla.setFont(fieldFont);
        txtPantalla.setBounds(220, 200, 240, 24);
        panelPrincipal.add(txtPantalla);
        
        lblPeso = new JLabel("Peso:");
        lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPeso.setFont(labelFont);
        lblPeso.setBounds(50, 235, 150, 20);
        panelPrincipal.add(lblPeso);
        
        txtPeso = new JTextField();
        txtPeso.setEditable(false);
        txtPeso.setFont(fieldFont);
        txtPeso.setBounds(220, 235, 240, 24);
        panelPrincipal.add(txtPeso);
        
        lblCamara = new JLabel("C\u00e1mara Principal:");
        lblCamara.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCamara.setFont(labelFont);
        lblCamara.setBounds(50, 270, 150, 20);
        panelPrincipal.add(lblCamara);
        
        txtCamara = new JTextField();
        txtCamara.setEditable(false);
        txtCamara.setFont(fieldFont);
        txtCamara.setBounds(220, 270, 240, 24);
        panelPrincipal.add(txtCamara);
        
        lblCamaraFrontal = new JLabel("C\u00e1mara Frontal:");
        lblCamaraFrontal.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCamaraFrontal.setFont(labelFont);
        lblCamaraFrontal.setBounds(50, 305, 150, 20);
        panelPrincipal.add(lblCamaraFrontal);
        
        txtCamaraFrontal = new JTextField();
        txtCamaraFrontal.setEditable(false);
        txtCamaraFrontal.setFont(fieldFont);
        txtCamaraFrontal.setBounds(220, 305, 240, 24);
        panelPrincipal.add(txtCamaraFrontal);
        
        lblSO = new JLabel("Sistema Operativo:");
        lblSO.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSO.setFont(labelFont);
        lblSO.setBounds(50, 340, 150, 20);
        panelPrincipal.add(lblSO);
        
        txtSO = new JTextField();
        txtSO.setEditable(false);
        txtSO.setFont(fieldFont);
        txtSO.setBounds(220, 340, 240, 24);
        panelPrincipal.add(txtSO);
        
        lblAlmacenamiento = new JLabel("Almacenamiento:");
        lblAlmacenamiento.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAlmacenamiento.setFont(labelFont);
        lblAlmacenamiento.setBounds(50, 375, 150, 20);
        panelPrincipal.add(lblAlmacenamiento);
        
        txtAlmacenamiento = new JTextField();
        txtAlmacenamiento.setEditable(false);
        txtAlmacenamiento.setFont(fieldFont);
        txtAlmacenamiento.setBounds(220, 375, 240, 24);
        panelPrincipal.add(txtAlmacenamiento);
        
        lblMemoria = new JLabel("Memoria:");
        lblMemoria.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMemoria.setFont(labelFont);
        lblMemoria.setBounds(50, 410, 150, 20);
        panelPrincipal.add(lblMemoria);
        
        txtMemoria = new JTextField();
        txtMemoria.setEditable(false);
        txtMemoria.setFont(fieldFont);
        txtMemoria.setBounds(220, 410, 240, 24);
        panelPrincipal.add(txtMemoria);
        
        lblPrecio = new JLabel("Precio (S/):");
        lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrecio.setFont(labelFont);
        lblPrecio.setBounds(50, 445, 150, 20);
        panelPrincipal.add(lblPrecio);
        
        txtPrecio = new JTextField();
        txtPrecio.setEditable(false);
        txtPrecio.setFont(fieldFont);
        txtPrecio.setBounds(220, 445, 240, 24);
        panelPrincipal.add(txtPrecio);
        
        lblMedidas = new JLabel("Medidas (cm):");
        lblMedidas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblMedidas.setFont(labelFont);
        lblMedidas.setBounds(50, 480, 150, 20);
        panelPrincipal.add(lblMedidas);
        
        txtMedidas = new JTextField();
        txtMedidas.setEditable(false);
        txtMedidas.setFont(fieldFont);
        txtMedidas.setBounds(220, 480, 240, 24);
        panelPrincipal.add(txtMedidas);
        
        lblPlan = new JLabel("Plan:");
        lblPlan.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPlan.setFont(labelFont);
        lblPlan.setBounds(50, 515, 150, 20);
        panelPrincipal.add(lblPlan);
        
        txtPlan = new JTextField();
        txtPlan.setEditable(false);
        txtPlan.setFont(fieldFont);
        txtPlan.setBounds(220, 515, 240, 24);
        panelPrincipal.add(txtPlan);
        
        // Botón Cerrar
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        btnCerrar.setFont(labelFont);
        btnCerrar.setBackground(new Color(230, 230, 230));
        btnCerrar.setBounds(275, 555, 100, 28);
        panelPrincipal.add(btnCerrar);
        
        add(panelPrincipal);
    }
    
    /**
     * Carga los modelos disponibles en el combo box desde DatosGlobales
     */
    private void cargarModelos() {
        comboModelos.removeAllItems();
        for (int i = 0; i < DatosGlobales.getCantidadTelefonos(); i++) {
            Telefono t = DatosGlobales.getTelefono(i);
            if (t != null) comboModelos.addItem(t.getModelo());
        }
    }
    
    /**
     * Actualiza los datos mostrados cuando cambia la selección del combo
     */
    private void actualizarDatos() {
        int indice = comboModelos.getSelectedIndex();
        if (indice >= 0) {
            mostrarDatos(indice);
        }
    }
    
    /**
     * Muestra los datos del teléfono en el índice especificado
     * @param indice Índice del teléfono en DatosGlobales
     */
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

package tienda;

import javax.swing.*;
import java.awt.*;

/**
 * DialogoVender - Interfaz para registrar una venta
 *
 * Permite seleccionar un modelo, especificar la cantidad y generar
 * una boleta de venta con cálculo automático de descuentos y obsequios.
 */
public class DialogoVender extends JDialog {
    private static final long serialVersionUID = 1L;
    private JComboBox<String> comboModelos;
    private JTextField txtPrecioUnitario;
    private JSpinner spinnerCantidad;
    private JTextArea areaBoletaVenta;
    private JButton btnVender;
    private JButton btnCerrar;
    
    /**
     * Constructor que crea el diálogo para realizar una venta de teléfonos.
     * Configura la interfaz con selección de modelo, cantidad y área para mostrar la boleta de venta.
     * @param padre La ventana principal (JFrame) que es el padre de este diálogo modal.
     */
    public DialogoVender(JFrame padre) {
        super(padre, "Vender Tel\u00e9fono M\u00f3vil", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(padre);

        // Permitir cerrar con Escape
        getRootPane().registerKeyboardAction(e -> dispose(),
            KeyStroke.getKeyStroke("ESCAPE"),
            JComponent.WHEN_IN_FOCUSED_WINDOW);

        crearComponentes();
        cargarModelos();
    }
    
    /**
     * Crea y configura todos los componentes visuales del diálogo de venta.
     * Incluye selectores de modelo, cantidad, campos de precio y área de boleta.
     */
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null); // Absolute layout
        panelPrincipal.setBackground(new Color(250, 250, 250));
        
        // Estética: fuentes
        Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 12);
        
        // Seleccionar modelo
        JLabel lblModelo = new JLabel("Seleccionar Modelo:");
        lblModelo.setFont(labelFont);
        lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
        lblModelo.setBounds(50, 20, 150, 20);
        panelPrincipal.add(lblModelo);
        
        comboModelos = new JComboBox<>();
        comboModelos.setFont(fieldFont);
        comboModelos.addActionListener(e -> actualizarPrecio());
        comboModelos.setBounds(220, 20, 260, 24);
        panelPrincipal.add(comboModelos);
        
        // Precio unitario
        JLabel lblPrecio = new JLabel("Precio Unitario:");
        lblPrecio.setFont(labelFont);
        lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPrecio.setBounds(50, 60, 150, 20);
        panelPrincipal.add(lblPrecio);
        
        txtPrecioUnitario = new JTextField();
        txtPrecioUnitario.setEditable(false);
        txtPrecioUnitario.setFont(fieldFont);
        txtPrecioUnitario.setBounds(220, 60, 160, 24);
        panelPrincipal.add(txtPrecioUnitario);
        
        // Cantidad
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(labelFont);
        lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCantidad.setBounds(50, 100, 150, 20);
        panelPrincipal.add(lblCantidad);
        
        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        ((JSpinner.DefaultEditor)spinnerCantidad.getEditor()).getTextField().setFont(fieldFont);
        spinnerCantidad.setBounds(220, 100, 80, 24);
        panelPrincipal.add(spinnerCantidad);
        
        // Área de boleta
        JLabel lblBoleta = new JLabel("Boleta de Venta:");
        lblBoleta.setFont(labelFont);
        lblBoleta.setBounds(50, 140, 200, 20);
        panelPrincipal.add(lblBoleta);
        
        areaBoletaVenta = new JTextArea();
        areaBoletaVenta.setEditable(false);
        areaBoletaVenta.setFont(new Font("Courier New", Font.PLAIN, 13));
        areaBoletaVenta.setMargin(new Insets(10,10,10,10));
        areaBoletaVenta.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(areaBoletaVenta);
        scrollPane.setBounds(50, 170, 600, 320);
        panelPrincipal.add(scrollPane);
        
        // Botones
        btnVender = new JButton("Vender");
        btnVender.addActionListener(e -> realizarVenta());
        btnVender.setFont(labelFont);
        btnVender.setBackground(new Color(200, 230, 200));
        btnVender.setBounds(250, 510, 100, 28);
        panelPrincipal.add(btnVender);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        btnCerrar.setFont(labelFont);
        btnCerrar.setBackground(new Color(230, 230, 230));
        btnCerrar.setBounds(370, 510, 100, 28);
        panelPrincipal.add(btnCerrar);
        
        add(panelPrincipal);
    }
    
    /**
     * Carga los modelos de teléfonos disponibles en el combo box desde DatosGlobales.
     */
    private void cargarModelos() {
        comboModelos.removeAllItems();
        for (int i = 0; i < DatosGlobales.getCantidadTelefonos(); i++) {
            Telefono t = DatosGlobales.getTelefono(i);
            if (t != null) comboModelos.addItem(t.getModelo());
        }
        if (DatosGlobales.getCantidadTelefonos() > 0) {
            actualizarPrecio();
        }
    }
    
    /**
     * Actualiza el campo de precio unitario cuando cambia la selección de modelo.
     */
    private void actualizarPrecio() {
        int indice = comboModelos.getSelectedIndex();
        if (indice >= 0 && indice < DatosGlobales.getCantidadTelefonos()) {
            Telefono t = DatosGlobales.getTelefono(indice);
            if (t != null) txtPrecioUnitario.setText(DatosGlobales.formatoMoneda(t.getPrecio()));
        }
    }
    
    /**
     * Procesa la venta seleccionada, calcula descuentos y genera la boleta.
     * Actualiza los contadores de ventas en DatosGlobales.
     */
    private void realizarVenta() {
        try {
            int indice = comboModelos.getSelectedIndex();
            if (indice < 0) {
                JOptionPane.showMessageDialog(this, "Seleccione un modelo.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int cantidad = (Integer) spinnerCantidad.getValue();

            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String boleta = DatosGlobales.procesarVenta(indice, cantidad);
            areaBoletaVenta.setText(boleta);

            JOptionPane.showMessageDialog(this, "¡Venta realizada exitosamente!",
                    "Venta Completada", JOptionPane.INFORMATION_MESSAGE);

            // Después de una venta exitosa: volver al primer modelo y restaurar cantidad a 1
            if (DatosGlobales.getCantidadTelefonos() > 0) {
                comboModelos.setSelectedIndex(0);
                spinnerCantidad.setValue(1);
                actualizarPrecio();
            }

            // Mostrar diálogo de ventas cada 5 ventas
            if (DatosGlobales.numeroVenta % 5 == 0) {
                mostrarDialogoVentasAcumuladas();
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al realizar la venta: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Muestra un diálogo con el resumen de ventas acumuladas del día.
     * Incluye número de ventas, total acumulado y cuota diaria.
     */
    private void mostrarDialogoVentasAcumuladas() {
        double porcentajeCuota = (DatosGlobales.importeTotalAcumulado / DatosGlobales.cuotaDiaria) * 100;
        
        String mensaje = String.format(
            "N\u00famero de Venta: %d\n" +
            "Importe Total Acumulado: %s\n" +
            "Porcentaje de Cuota Diaria: %.2f%%",
            DatosGlobales.numeroVenta,
            DatosGlobales.formatoMoneda(DatosGlobales.importeTotalAcumulado),
            porcentajeCuota
        );
        
        JOptionPane.showMessageDialog(this, mensaje,
                "Reporte de Ventas Acumuladas", JOptionPane.INFORMATION_MESSAGE);
    }
}

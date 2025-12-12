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
    
    public DialogoVender(JFrame padre) {
        super(padre, "Vender Teléfono Móvil", true);
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
    
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 12, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Estética: fuentes y fondo
        Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 12);
        panelPrincipal.setBackground(new Color(250, 250, 250));
        
        // Seleccionar modelo
        JLabel lblModelo = new JLabel("Seleccionar Modelo:");
        lblModelo.setFont(labelFont);
        lblModelo.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lblModelo, gbc);
        
        comboModelos = new JComboBox<>();
        comboModelos.setPreferredSize(new Dimension(260, 24));
        comboModelos.setFont(fieldFont);
        comboModelos.addActionListener(e -> actualizarPrecio());
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(comboModelos, gbc);
        gbc.weightx = 0;
        
        // Precio unitario
        JLabel lblPrecio = new JLabel("Precio Unitario:");
        lblPrecio.setFont(labelFont);
        lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lblPrecio, gbc);
        
        txtPrecioUnitario = new JTextField(15);
        txtPrecioUnitario.setEditable(false);
        txtPrecioUnitario.setPreferredSize(new Dimension(160, 24));
        txtPrecioUnitario.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(txtPrecioUnitario, gbc);
        gbc.weightx = 0;
        
        // Cantidad
        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(labelFont);
        lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lblCantidad, gbc);
        
        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 1000, 1));
        Dimension spinnerDim = new Dimension(80, 24);
        spinnerCantidad.setPreferredSize(spinnerDim);
        ((JSpinner.DefaultEditor)spinnerCantidad.getEditor()).getTextField().setFont(fieldFont);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(spinnerCantidad, gbc);
        gbc.weightx = 0;
        
        // Área de boleta
        JLabel lblBoleta = new JLabel("Boleta de Venta:");
        lblBoleta.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelPrincipal.add(lblBoleta, gbc);
        
        areaBoletaVenta = new JTextArea();
        areaBoletaVenta.setEditable(false);
        areaBoletaVenta.setFont(new Font("Courier New", Font.PLAIN, 13));
        areaBoletaVenta.setMargin(new Insets(10,10,10,10));
        areaBoletaVenta.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(areaBoletaVenta);
        scrollPane.setPreferredSize(new Dimension(600, 320));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panelPrincipal.add(scrollPane, gbc);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnVender = new JButton("Vender");
        btnVender.addActionListener(e -> realizarVenta());
        btnVender.setFont(labelFont);
        btnVender.setPreferredSize(new Dimension(100, 28));
        btnVender.setBackground(new Color(200, 230, 200));

        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        btnCerrar.setFont(labelFont);
        btnCerrar.setPreferredSize(new Dimension(100, 28));
        btnCerrar.setBackground(new Color(230, 230, 230));

        panelBotones.add(btnVender);
        panelBotones.add(btnCerrar);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(panelBotones, gbc);
        
        add(panelPrincipal);
    }
    
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
    
    private void actualizarPrecio() {
        int indice = comboModelos.getSelectedIndex();
        if (indice >= 0 && indice < DatosGlobales.getCantidadTelefonos()) {
            Telefono t = DatosGlobales.getTelefono(indice);
            if (t != null) txtPrecioUnitario.setText(DatosGlobales.formatoMoneda(t.getPrecio()));
        }
    }
    
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
    
    private void mostrarDialogoVentasAcumuladas() {
        double porcentajeCuota = (DatosGlobales.importeTotalAcumulado / DatosGlobales.cuotaDiaria) * 100;
        
        String mensaje = String.format(
            "Número de Venta: %d\n" +
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

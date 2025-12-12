package tienda;

import javax.swing.*;
import java.awt.*;

/**
 * DialogoConfigurarDescuentos - Permite ajustar porcentajes de descuento
 *
 * Presenta campos para editar los 4 porcentajes de descuento usados
 * por `DatosGlobales`. Guarda valores después de validarlos como números.
 */
public class DialogoConfigurarDescuentos extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextField txtPorcentaje1;
    private JTextField txtPorcentaje2;
    private JTextField txtPorcentaje3;
    private JTextField txtPorcentaje4;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    public DialogoConfigurarDescuentos(JFrame padre) {
        super(padre, "Configurar Descuentos", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(padre);
        setResizable(false);

        // Permitir cerrar con Escape
        getRootPane().registerKeyboardAction(e -> dispose(),
            KeyStroke.getKeyStroke("ESCAPE"),
            JComponent.WHEN_IN_FOCUSED_WINDOW);

        crearComponentes();
        cargarDatos();
    }
    
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 12, 8, 12);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Estética
        Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 12);
        panelPrincipal.setBackground(new Color(250, 250, 250));
        
        // Etiqueta de información
        JLabel lblInfo = new JLabel("Ingrese los porcentajes de descuento:");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(lblInfo, gbc);
        
        // Porcentaje 1
        JLabel lbl1 = new JLabel("Descuento 1 a 5 unidades (%):");
        lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl1.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lbl1, gbc);

        txtPorcentaje1 = new JTextField(1);
        txtPorcentaje1.setPreferredSize(new Dimension(120, 24));
        txtPorcentaje1.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtPorcentaje1, gbc);
        gbc.weightx = 0;
        
        // Porcentaje 2
        JLabel lbl2 = new JLabel("Descuento 6 a 10 unidades (%):");
        lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl2.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lbl2, gbc);

        txtPorcentaje2 = new JTextField(1);
        txtPorcentaje2.setPreferredSize(new Dimension(120, 24));
        txtPorcentaje2.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtPorcentaje2, gbc);
        gbc.weightx = 0;
        
        // Porcentaje 3
        JLabel lbl3 = new JLabel("Descuento 11 a 15 unidades (%):");
        lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl3.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lbl3, gbc);

        txtPorcentaje3 = new JTextField(1);
        txtPorcentaje3.setPreferredSize(new Dimension(120, 24));
        txtPorcentaje3.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtPorcentaje3, gbc);
        gbc.weightx = 0;
        
        // Porcentaje 4
        JLabel lbl4 = new JLabel("Descuento más de 15 unidades (%):");
        lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl4.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lbl4, gbc);

        txtPorcentaje4 = new JTextField(1);
        txtPorcentaje4.setPreferredSize(new Dimension(120, 24));
        txtPorcentaje4.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtPorcentaje4, gbc);
        gbc.weightx = 0;
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> guardarDescuentos());
        btnAceptar.setFont(labelFont);
        btnAceptar.setPreferredSize(new Dimension(100, 28));
        btnAceptar.setBackground(new Color(200, 230, 200));
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        btnCancelar.setFont(labelFont);
        btnCancelar.setPreferredSize(new Dimension(100, 28));
        btnCancelar.setBackground(new Color(230, 230, 230));
        
        btnAceptar.setPreferredSize(new Dimension(100, 28));
        btnCancelar.setPreferredSize(new Dimension(100, 28));
        panelBotones.add(btnAceptar);
        panelBotones.add(btnCancelar);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(panelBotones, gbc);
        
        add(panelPrincipal);
    }
    
    private void cargarDatos() {
        txtPorcentaje1.setText(String.valueOf(DatosGlobales.porcentaje1));
        txtPorcentaje2.setText(String.valueOf(DatosGlobales.porcentaje2));
        txtPorcentaje3.setText(String.valueOf(DatosGlobales.porcentaje3));
        txtPorcentaje4.setText(String.valueOf(DatosGlobales.porcentaje4));
    }
    
    private void guardarDescuentos() {
        try {
            DatosGlobales.porcentaje1 = Double.parseDouble(txtPorcentaje1.getText());
            DatosGlobales.porcentaje2 = Double.parseDouble(txtPorcentaje2.getText());
            DatosGlobales.porcentaje3 = Double.parseDouble(txtPorcentaje3.getText());
            DatosGlobales.porcentaje4 = Double.parseDouble(txtPorcentaje4.getText());
            
            JOptionPane.showMessageDialog(this, "Descuentos guardados correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Ingrese valores numéricos válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

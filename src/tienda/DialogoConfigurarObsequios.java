package tienda;

import javax.swing.*;
import java.awt.*;

/**
 * DialogoConfigurarObsequios - Permite definir obsequios según cantidad
 *
 * Muestra tres campos para configurar los nombres de los obsequios que
 * se asignan automáticamente según la cantidad comprada en `DatosGlobales`.
 */
public class DialogoConfigurarObsequios extends JDialog {
    private JTextField txtObsequio1;
    private JTextField txtObsequio2;
    private JTextField txtObsequio3;
    private static final long serialVersionUID = 1L;
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    public DialogoConfigurarObsequios(JFrame padre) {
        super(padre, "Configurar Obsequios", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(400, 250);
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
        JLabel lblInfo = new JLabel("Ingrese los obsequios:");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(lblInfo, gbc);
        
        // Obsequio 1
        JLabel lbl1 = new JLabel("Obsequio 1 - 1 unidad:");
        lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl1.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lbl1, gbc);

        txtObsequio1 = new JTextField(1);
        txtObsequio1.setPreferredSize(new Dimension(240, 24));
        txtObsequio1.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtObsequio1, gbc);
        gbc.weightx = 0;
        
        // Obsequio 2
        JLabel lbl2 = new JLabel("Obsequio 2 - De 2 a 5 unidades:");
        lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl2.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lbl2, gbc);

        txtObsequio2 = new JTextField(1);
        txtObsequio2.setPreferredSize(new Dimension(240, 24));
        txtObsequio2.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtObsequio2, gbc);
        gbc.weightx = 0;
        
        // Obsequio 3
        JLabel lbl3 = new JLabel("Obsequio 3 - De 6 a más unidades:");
        lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl3.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        panelPrincipal.add(lbl3, gbc);

        txtObsequio3 = new JTextField(1);
        txtObsequio3.setPreferredSize(new Dimension(240, 24));
        txtObsequio3.setFont(fieldFont);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 1.0;
        panelPrincipal.add(txtObsequio3, gbc);
        gbc.weightx = 0;
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(e -> guardarObsequios());
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
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelPrincipal.add(panelBotones, gbc);
        
        add(panelPrincipal);
    }
    
    private void cargarDatos() {
        txtObsequio1.setText(DatosGlobales.obsequio1);
        txtObsequio2.setText(DatosGlobales.obsequio2);
        txtObsequio3.setText(DatosGlobales.obsequio3);
    }
    
    private void guardarObsequios() {
        try {
            String o1 = txtObsequio1.getText().trim();
            String o2 = txtObsequio2.getText().trim();
            String o3 = txtObsequio3.getText().trim();
            
            if (o1.isEmpty() || o2.isEmpty() || o3.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No puede dejar campos vacíos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            DatosGlobales.obsequio1 = o1;
            DatosGlobales.obsequio2 = o2;
            DatosGlobales.obsequio3 = o3;
            
            JOptionPane.showMessageDialog(this, "Obsequios guardados correctamente.",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

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
    private JButton btnGuardar;
    private JButton btnCancelar;
    
    /**
     * Constructor del diálogo Configurar Obsequios
     * @param padre Ventana padre para centrar el diálogo
     */
    public DialogoConfigurarObsequios(JFrame padre) {
        super(padre, "Configurar Obsequios", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(padre);
        setResizable(false);

        // Permitir cerrar con Escape
        getRootPane().registerKeyboardAction(e -> dispose(),
            KeyStroke.getKeyStroke("ESCAPE"),
            JComponent.WHEN_IN_FOCUSED_WINDOW);

        crearComponentes();
        cargarDatos();
    }
    
    /**
     * Crea y configura todos los componentes visuales del diálogo
     */
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null); // Absolute layout
        panelPrincipal.setBackground(new Color(250, 250, 250));
        
        // Estética
        Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 12);
        
        // Etiqueta de información
        JLabel lblInfo = new JLabel("Ingrese los obsequios:");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setFont(labelFont);
        lblInfo.setBounds(50, 10, 370, 20);
        panelPrincipal.add(lblInfo);
        
        // Obsequio 1
        JLabel lbl1 = new JLabel("Obsequio 1 - 1 unidad:");
        lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl1.setFont(labelFont);
        lbl1.setBounds(0, 40, 240, 20);
        panelPrincipal.add(lbl1);
        
        txtObsequio1 = new JTextField();
        txtObsequio1.setFont(fieldFont);
        txtObsequio1.setBounds(250, 40, 200, 24);
        panelPrincipal.add(txtObsequio1);
        
        // Obsequio 2
        JLabel lbl2 = new JLabel("Obsequio 2 - De 2 a 5 unidades:");
        lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl2.setFont(labelFont);
        lbl2.setBounds(0, 80, 240, 20);
        panelPrincipal.add(lbl2);
        
        txtObsequio2 = new JTextField();
        txtObsequio2.setFont(fieldFont);
        txtObsequio2.setBounds(250, 80, 200, 24);
        panelPrincipal.add(txtObsequio2);
        
        // Obsequio 3
        JLabel lbl3 = new JLabel("Obsequio 3 - De 6 a más unidades:");
        lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl3.setFont(labelFont);
        lbl3.setBounds(0, 120, 240, 20);
        panelPrincipal.add(lbl3);
        
        txtObsequio3 = new JTextField();
        txtObsequio3.setFont(fieldFont);
        txtObsequio3.setBounds(250, 120, 200, 24);
        panelPrincipal.add(txtObsequio3);
        
        // Botones
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarObsequios());
        btnGuardar.setFont(labelFont);
        btnGuardar.setBackground(new Color(200, 230, 200));
        btnGuardar.setBounds(130, 170, 100, 28);
        panelPrincipal.add(btnGuardar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        btnCancelar.setFont(labelFont);
        btnCancelar.setBackground(new Color(230, 230, 230));
        btnCancelar.setBounds(240, 170, 100, 28);
        panelPrincipal.add(btnCancelar);
        
        add(panelPrincipal);
    }
    
    /**
     * Carga los valores actuales de los obsequios desde DatosGlobales
     */
    private void cargarDatos() {
        txtObsequio1.setText(DatosGlobales.obsequio1);
        txtObsequio2.setText(DatosGlobales.obsequio2);
        txtObsequio3.setText(DatosGlobales.obsequio3);
    }
    
    /**
     * Guarda los obsequios configurados en DatosGlobales después de validación.
     * Muestra mensaje de éxito, refresca los campos y mantiene la ventana abierta.
     */
    private void guardarObsequios() {
        try {
            String o1 = txtObsequio1.getText().trim();
            String o2 = txtObsequio2.getText().trim();
            String o3 = txtObsequio3.getText().trim();
            
            if (o1.isEmpty() || o2.isEmpty() || o3.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No puede dejar campos vac\u00edos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            DatosGlobales.obsequio1 = o1;
            DatosGlobales.obsequio2 = o2;
            DatosGlobales.obsequio3 = o3;
            
            JOptionPane.showMessageDialog(this, "Obsequios guardados correctamente.",
                    "Cambios guardados", JOptionPane.INFORMATION_MESSAGE);
            
            // Refrescar los campos para mostrar los cambios guardados
            cargarDatos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

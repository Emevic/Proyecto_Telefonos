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
    private JButton btnGuardar;
    private JButton btnCancelar;
    
    /**
     * Constructor que crea el diálogo para configurar los porcentajes de descuento.
     * Inicializa la ventana con campos de texto para editar los descuentos y botones para aceptar o cancelar.
     * @param padre La ventana principal (JFrame) que es el padre de este diálogo modal.
     */
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
    
    /**
     * Crea y configura todos los componentes visuales del diálogo.
     * Incluye labels, campos de texto para porcentajes y botones.
     */
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null); // Absolute layout
        panelPrincipal.setBackground(new Color(250, 250, 250));
        
        // Estética
        Font labelFont = new Font("Segoe UI", Font.BOLD, 12);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 12);
        
        // Etiqueta de información
        JLabel lblInfo = new JLabel("Ingrese los porcentajes de descuento:");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(50, 10, 300, 20);
        panelPrincipal.add(lblInfo);
        
        // Porcentaje 1
        JLabel lbl1 = new JLabel("Descuento 1 a 5 unidades (%):");
        lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl1.setFont(labelFont);
        lbl1.setBounds(20, 40, 200, 20);
        panelPrincipal.add(lbl1);
        
        txtPorcentaje1 = new JTextField();
        txtPorcentaje1.setFont(fieldFont);
        txtPorcentaje1.setBounds(240, 40, 120, 24);
        panelPrincipal.add(txtPorcentaje1);
        
        // Porcentaje 2
        JLabel lbl2 = new JLabel("Descuento 6 a 10 unidades (%):");
        lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl2.setFont(labelFont);
        lbl2.setBounds(20, 80, 200, 20);
        panelPrincipal.add(lbl2);
        
        txtPorcentaje2 = new JTextField();
        txtPorcentaje2.setFont(fieldFont);
        txtPorcentaje2.setBounds(240, 80, 120, 24);
        panelPrincipal.add(txtPorcentaje2);
        
        // Porcentaje 3
        JLabel lbl3 = new JLabel("Descuento 11 a 15 unidades (%):");
        lbl3.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl3.setFont(labelFont);
        lbl3.setBounds(20, 120, 200, 20);
        panelPrincipal.add(lbl3);
        
        txtPorcentaje3 = new JTextField();
        txtPorcentaje3.setFont(fieldFont);
        txtPorcentaje3.setBounds(240, 120, 120, 24);
        panelPrincipal.add(txtPorcentaje3);
        
        // Porcentaje 4
        JLabel lbl4 = new JLabel("Descuento más de 15 unidades (%):");
        lbl4.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl4.setFont(labelFont);
        lbl4.setBounds(20, 160, 200, 20);
        panelPrincipal.add(lbl4);
        
        txtPorcentaje4 = new JTextField();
        txtPorcentaje4.setFont(fieldFont);
        txtPorcentaje4.setBounds(240, 160, 120, 24);
        panelPrincipal.add(txtPorcentaje4);
        
        // Botones
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarDescuentos());
        btnGuardar.setFont(labelFont);
        btnGuardar.setBackground(new Color(200, 230, 200));
        btnGuardar.setBounds(120, 210, 100, 28);
        panelPrincipal.add(btnGuardar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());
        btnCancelar.setFont(labelFont);
        btnCancelar.setBackground(new Color(230, 230, 230));
        btnCancelar.setBounds(240, 210, 100, 28);
        panelPrincipal.add(btnCancelar);
        
        add(panelPrincipal);
    }
    
    /**
     * Carga los valores actuales de porcentajes de descuento en los campos de texto.
     */
    private void cargarDatos() {
        txtPorcentaje1.setText(String.valueOf(DatosGlobales.porcentaje1));
        txtPorcentaje2.setText(String.valueOf(DatosGlobales.porcentaje2));
        txtPorcentaje3.setText(String.valueOf(DatosGlobales.porcentaje3));
        txtPorcentaje4.setText(String.valueOf(DatosGlobales.porcentaje4));
    }
    
    /**
     * Valida y guarda los nuevos porcentajes de descuento en DatosGlobales.
     * Muestra mensaje de éxito, refresca los campos y mantiene la ventana abierta.
     */
    private void guardarDescuentos() {
        try {
            DatosGlobales.porcentaje1 = Double.parseDouble(txtPorcentaje1.getText());
            DatosGlobales.porcentaje2 = Double.parseDouble(txtPorcentaje2.getText());
            DatosGlobales.porcentaje3 = Double.parseDouble(txtPorcentaje3.getText());
            DatosGlobales.porcentaje4 = Double.parseDouble(txtPorcentaje4.getText());
            
            JOptionPane.showMessageDialog(this, "Descuentos guardados correctamente.",
                    "Cambios guardados", JOptionPane.INFORMATION_MESSAGE);
            
            // Refrescar los campos para mostrar los cambios guardados
            cargarDatos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Ingrese valores num\u00e9ricos v\u00e1lidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

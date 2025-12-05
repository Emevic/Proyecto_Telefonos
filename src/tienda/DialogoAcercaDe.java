package tienda;

import javax.swing.*;
import java.awt.*;

/**
 * DialogoAcercaDe - Muestra información sobre la aplicación y autores
 *
 * Ventana simple con texto explicativo sobre la aplicación, autores
 * y características. Diseñada para ser informativa y fácil de leer.
 */
public class DialogoAcercaDe extends JDialog {
    private static final long serialVersionUID = 1L;
    
    public DialogoAcercaDe(JFrame padre) {
        super(padre, "Acerca de Tienda de Celulares", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(padre);
        setResizable(false);

        // Permitir cerrar con Escape
        getRootPane().registerKeyboardAction(e -> dispose(),
            KeyStroke.getKeyStroke("ESCAPE"),
            JComponent.WHEN_IN_FOCUSED_WINDOW);

        crearComponentes();
    }
    
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(new Color(250, 250, 250));
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        // Título grande centrado
        JLabel lblTitulo = new JLabel("Tienda de Celulares 1.0");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(lblTitulo);

        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 12)));

        // Línea horizontal azul clara
        JSeparator separador = new JSeparator();
        separador.setForeground(new Color(173, 216, 230));
        separador.setMaximumSize(new Dimension(450, 3));
        separador.setPreferredSize(new Dimension(450, 3));
        panelPrincipal.add(separador);

        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 16)));

        // Label "Autores" centrado
        JLabel lblAutores = new JLabel("Autores:");
        lblAutores.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblAutores.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelPrincipal.add(lblAutores);

        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 10)));

        // Panel con cada autor en su propio label, centrados
        JPanel panelNombres = new JPanel();
        panelNombres.setOpaque(false);
        panelNombres.setLayout(new BoxLayout(panelNombres, BoxLayout.Y_AXIS));
        panelNombres.setAlignmentX(Component.CENTER_ALIGNMENT);

        String[] autores = new String[] {
            "Nayeli Bianca Clemente Morales",
            "Milagros Eugenia Loza Cavero",
            "Nicole Catherine Paucar Quispe",
            "Emerson Víctor Aliaga Velán",
            "Carlos Eduardo Saavedra Alvarado"
        };

        for (String nombre : autores) {
            JLabel lbl = new JLabel(nombre);
            lbl.setFont(new Font("Segoe UI", Font.BOLD, 16));
            lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            panelNombres.add(lbl);
            panelNombres.add(Box.createRigidArea(new Dimension(0, 6)));
        }

        panelPrincipal.add(panelNombres);

        panelPrincipal.add(Box.createVerticalGlue());

        // Botón Cerrar centrado
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        btnCerrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrar.addActionListener(e -> dispose());
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 12)));
        panelPrincipal.add(btnCerrar);

        add(panelPrincipal);
    }
}

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
    
    // Componentes para edición gráfica
    private JPanel panelPrincipal;
    private JLabel lblTitulo;
    private JSeparator separador;
    private JLabel lblAutores;
    private JLabel lblAutor1;
    private JLabel lblAutor2;
    private JLabel lblAutor3;
    private JLabel lblAutor4;
    private JLabel lblAutor5;
    private JButton btnCerrar;
    
    /**
     * Constructor del diálogo Acerca De
     * @param padre Ventana padre (JFrame principal) para centrar el diálogo
     */
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
    
    /**
     * Crea y configura todos los componentes visuales del diálogo
     */
    private void crearComponentes() {
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null); // Absolute layout
        panelPrincipal.setBackground(new Color(250, 250, 250));
        
        // Título grande centrado
        lblTitulo = new JLabel("Tienda de Celulares 1.0");
        lblTitulo.setForeground(Color.BLUE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblTitulo.setBounds(50, 20, 400, 40);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblTitulo);
        
        // Línea horizontal azul clara
        separador = new JSeparator();
        separador.setForeground(new Color(173, 216, 230));
        separador.setBounds(25, 70, 450, 3);
        panelPrincipal.add(separador);
        
        // Label "Autores" centrado
        lblAutores = new JLabel("Autores:");
        lblAutores.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblAutores.setBounds(200, 80, 100, 25);
        lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblAutores);
        
        // Autores
        lblAutor1 = new JLabel("Nayeli Bianca Clemente Morales");
        lblAutor1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAutor1.setBounds(50, 110, 400, 20);
        lblAutor1.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblAutor1);
        
        lblAutor2 = new JLabel("Milagros Eugenia Loza Cavero");
        lblAutor2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAutor2.setBounds(50, 135, 400, 20);
        lblAutor2.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblAutor2);
        
        lblAutor3 = new JLabel("Nicole Catherine Paucar Quispe");
        lblAutor3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAutor3.setBounds(50, 160, 400, 20);
        lblAutor3.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblAutor3);
        
        lblAutor4 = new JLabel("Emerson V\u00edctor Aliaga Vel\u00e1n");
        lblAutor4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAutor4.setBounds(50, 185, 400, 20);
        lblAutor4.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblAutor4);
        
        lblAutor5 = new JLabel("Carlos Eduardo Saavedra Alvarado");
        lblAutor5.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblAutor5.setBounds(50, 210, 400, 20);
        lblAutor5.setHorizontalAlignment(SwingConstants.CENTER);
        panelPrincipal.add(lblAutor5);
        
        // Botón Cerrar centrado
        btnCerrar = new JButton("Cerrar");
        btnCerrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCerrar.setBounds(200, 320, 100, 28);
        btnCerrar.addActionListener(e -> dispose());
        panelPrincipal.add(btnCerrar);
        
        add(panelPrincipal);
    }
}

package tienda;

import javax.swing.*;
import java.awt.*;

/**
 * DialogoListarTelefonos - Muestra un reporte con todos los teléfonos
 *
 * Genera y muestra en un `JTextArea` un reporte formateado
 * con los detalles de todos los teléfonos registrados en `DatosGlobales`.
 */
public class DialogoListarTelefonos extends JDialog {
    private static final long serialVersionUID = 1L;
    private JTextArea areaTexto;
    private JButton btnListar;
    private JButton btnCerrar;
    
    public DialogoListarTelefonos(JFrame padre) {
        super(padre, "Listar Teléfonos Móviles", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(padre);

        // Permitir cerrar con Escape
        getRootPane().registerKeyboardAction(e -> dispose(),
            KeyStroke.getKeyStroke("ESCAPE"),
            JComponent.WHEN_IN_FOCUSED_WINDOW);

        crearComponentes();
    }
    
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        
        // Área de texto con scroll
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Courier New", Font.PLAIN, 12));
        areaTexto.setMargin(new Insets(10,10,10,10));
        areaTexto.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setPreferredSize(new Dimension(760, 420));
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> generarReporte());
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        
        Font btnFont = new Font("Segoe UI", Font.BOLD, 12);
        btnListar.setFont(btnFont);
        btnCerrar.setFont(btnFont);
        btnListar.setPreferredSize(new Dimension(100, 28));
        btnCerrar.setPreferredSize(new Dimension(100, 28));
        btnListar.setBackground(new Color(220, 235, 255));
        btnCerrar.setBackground(new Color(230, 230, 230));
        panelBotones.add(btnListar);
        panelBotones.add(btnCerrar);
        
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private void generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("===============================REPORTE DE TELÉFONOS MÓVILES===============================\n\n");
        
        if (DatosGlobales.getCantidadTelefonos() == 0) {
            reporte.append("No hay teléfonos registrados.\n");
        } else {
            for (int i = 0; i < DatosGlobales.getCantidadTelefonos(); i++) {
                Telefono tel = DatosGlobales.getTelefono(i);
                reporte.append("TELÉFONO #").append(i + 1).append("\n");
                reporte.append("─────────────────────────────────────────\n");
                reporte.append("Marca: ").append(tel.getMarca()).append("\n");
                reporte.append("Modelo: ").append(tel.getModelo()).append("\n");
                reporte.append("Color: ").append(tel.getColor()).append("\n");
                reporte.append("Procesador: ").append(tel.getProcesador()).append("\n");
                reporte.append("Pantalla: ").append(tel.getPantalla()).append("\n");
                reporte.append("Peso: ").append(tel.getPeso()).append("\n");
                reporte.append("Cámara Principal: ").append(tel.getCamaraPrincipal()).append("\n");
                reporte.append("Cámara Frontal: ").append(tel.getCamaraFrontal()).append("\n");
                reporte.append("Sistema Operativo: ").append(tel.getSistemaOperativo()).append("\n");
                reporte.append("Almacenamiento: ").append(tel.getCapacidadAlmacenamiento()).append("\n");
                reporte.append("Memoria: ").append(tel.getMemoria()).append("\n");
                reporte.append("Precio (S/): ").append(DatosGlobales.formatoMoneda(tel.getPrecio())).append("\n");
                reporte.append("Medidas (cm): ").append(tel.getMedidas()).append("\n");
                reporte.append("Plan: ").append(tel.getTipoPlan()).append("\n");
                reporte.append("\n");
            }
        }
        
        areaTexto.setText(reporte.toString());
    }
}

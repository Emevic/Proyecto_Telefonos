package tienda;

import javax.swing.*;
import java.awt.*;
import java.util.*;

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
    private JComboBox<String> comboOrden;
    
    /**
     * Constructor que crea el diálogo para listar y mostrar todos los teléfonos registrados.
     * Configura la ventana con un área de texto para el reporte y opciones para ordenar la lista.
     * @param padre La ventana principal (JFrame) que es el padre de este diálogo modal.
     */
    public DialogoListarTelefonos(JFrame padre) {
        super(padre, "Listar Tel\u00E9fonos M\u00F3viles", true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(padre);

        // Permitir cerrar con Escape
        getRootPane().registerKeyboardAction(e -> dispose(),
            KeyStroke.getKeyStroke("ESCAPE"),
            JComponent.WHEN_IN_FOCUSED_WINDOW);

        crearComponentes();
    }
    
    /**
     * Crea y configura todos los componentes visuales del diálogo.
     * Incluye selector de orden, botones y área de texto para el reporte.
     */
    private void crearComponentes() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null); // Absolute layout
        
        // Panel superior con selector de orden
        JLabel lblOrden = new JLabel("Orden:");
        lblOrden.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblOrden.setBounds(10, 10, 50, 20);
        panelPrincipal.add(lblOrden);
        
        comboOrden = new JComboBox<>(new String[] {"Original", "Precio (Mayor → Menor)", "Precio (Menor → Mayor)", "Marca (A → Z)"});
        comboOrden.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        comboOrden.addActionListener(e -> generarReporte());
        comboOrden.setBounds(70, 10, 200, 24);
        panelPrincipal.add(comboOrden);
        
        // Área de texto con scroll
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Courier New", Font.PLAIN, 12));
        areaTexto.setMargin(new Insets(10,10,10,10));
        areaTexto.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        scrollPane.setBounds(10, 40, 760, 380);
        panelPrincipal.add(scrollPane);
        
        // Botones
        btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> generarReporte());
        btnListar.setBounds(300, 430, 100, 28);
        panelPrincipal.add(btnListar);
        
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dispose());
        btnCerrar.setBounds(420, 430, 100, 28);
        panelPrincipal.add(btnCerrar);
        
        Font btnFont = new Font("Segoe UI", Font.BOLD, 12);
        btnListar.setFont(btnFont);
        btnCerrar.setFont(btnFont);
        btnListar.setBackground(new Color(220, 235, 255));
        btnCerrar.setBackground(new Color(230, 230, 230));
        
        add(panelPrincipal);
    }
    
    /**
     * Genera el reporte de teléfonos ordenado según la selección del combo.
     * Obtiene la lista de teléfonos, los ordena y formatea el texto para mostrar.
     */
    private void generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("=============================== REPORTE DE TEL\u00c9FONOS M\u00d3VILES ===============================\n\n");
        
        if (DatosGlobales.getCantidadTelefonos() == 0) {
            reporte.append("No hay tel\u00e9fonos registrados.\n");
        } else {
            // Construir lista local de teléfonos para poder ordenar sin modificar DatosGlobales
            java.util.List<Telefono> lista = new java.util.ArrayList<>();
            for (int i = 0; i < DatosGlobales.getCantidadTelefonos(); i++) {
                lista.add(DatosGlobales.getTelefono(i));
            }

            // Aplicar orden según selección del combo (si existe)
            if (comboOrden != null) {
                String opcion = (String) comboOrden.getSelectedItem();
                if ("Precio (Mayor → Menor)".equals(opcion)) {
                    Collections.sort(lista, new Comparator<Telefono>() {
                        public int compare(Telefono a, Telefono b) {
                            // ordenar por precio descendente
                            return Double.compare(b.getPrecio(), a.getPrecio());
                        }
                    });
                } else if ("Precio (Menor → Mayor)".equals(opcion)) {
                    Collections.sort(lista, new Comparator<Telefono>() {
                        public int compare(Telefono a, Telefono b) {
                            // ordenar por precio ascendente
                            return Double.compare(a.getPrecio(), b.getPrecio());
                        }
                    });
                } else if ("Marca (A → Z)".equals(opcion)) {
                    Collections.sort(lista, new Comparator<Telefono>() {
                        public int compare(Telefono a, Telefono b) {
                            return a.getMarca().compareToIgnoreCase(b.getMarca());
                        }
                    });
                }
            }

            for (int i = 0; i < lista.size(); i++) {
                Telefono tel = lista.get(i);
                reporte.append("Tel\u00E9fono #").append(i + 1).append("\n");
                reporte.append("────────────────────────────────────────────────────────────────────────────────────────────────────\n");
                reporte.append("Marca: ").append(tel.getMarca()).append("\n");
                reporte.append("Modelo: ").append(tel.getModelo()).append("\n");
                reporte.append("Color: ").append(tel.getColor()).append("\n");
                reporte.append("Procesador: ").append(tel.getProcesador()).append("\n");
                reporte.append("Pantalla: ").append(tel.getPantalla()).append("\n");
                reporte.append("Peso: ").append(tel.getPeso()).append("\n");
                reporte.append("C\u00e1mara Principal: ").append(tel.getCamaraPrincipal()).append("\n");
                reporte.append("C\u00e1mara Frontal: ").append(tel.getCamaraFrontal()).append("\n");
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

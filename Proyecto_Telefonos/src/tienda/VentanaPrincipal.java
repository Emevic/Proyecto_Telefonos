package tienda;

import javax.swing.*;
import java.awt.*;

/**
 * VentanaPrincipal - Ventana principal de la aplicación "Tienda de Celulares 1.0"
 * 
 * Esta clase es responsable de:
 * - Crear y mostrar la interfaz gráfica principal de la aplicación
 * - Gestionar el menú superior con opciones para consultar, modificar y vender teléfonos
 * - Abrir diálogos secundarios cuando el usuario hace clic en opciones del menú
 * - Gestionar el ciclo de vida de la aplicación
 * 
 * Arquitectura:
 * - Constantes: Textos y dimensiones para fácil mantenimiento
 * - Variables de instancia: Componentes Swing (menús e items)
 * - Métodos organizados: Inicialización, creación de menús, manejo de acciones
 * 
 * @author Sistema de Tienda de Celulares
 * @version 2.0
 */
public class VentanaPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;
    
    // ========== CONSTANTES ==========
    // Constantes para las dimensiones de la ventana
    private static final String TITULO = "Tienda de Celulares 1.0";
    private static final int ANCHO_VENTANA = 800;
    private static final int ALTO_VENTANA = 600;
    
    // Constantes para los nombres de los menús (facilita cambios futuros)
    private static final String MENU_ARCHIVO = "Archivo";
    private static final String MENU_MANTENIMIENTO = "Mantenimiento";
    private static final String MENU_VENTAS = "Ventas";
    private static final String MENU_CONFIGURACION = "Configuración";
    private static final String MENU_AYUDA = "Ayuda";
    
    // Constantes para los items del menú
    private static final String ITEM_SALIR = "Salir";
    private static final String ITEM_CONSULTAR = "Consultar Teléfono Móvil";
    private static final String ITEM_MODIFICAR = "Modificar Teléfono Móvil";
    private static final String ITEM_LISTAR = "Listar Teléfonos Móviles";
    private static final String ITEM_VENDER = "Vender";
    private static final String ITEM_CONFIG_DESCUENTOS = "Configurar descuentos";
    private static final String ITEM_CONFIG_OBSEQUIOS = "Configurar obsequios";
    private static final String ITEM_ACERCA_DE = "Acerca de Tienda de Celulares";
    
    // Constantes para mensajes de diálogos
    private static final String DIALOGO_CONFIRMAR = "Confirmar Salida";
    private static final String MENSAJE_SALIDA = "¿Está seguro de que desea salir?";
    
    // ========== VARIABLES DE INSTANCIA ==========
    // Barra de menú y menús principales
    private JMenuBar menuBar;
    private JMenu menuArchivo;
    private JMenu menuMantenimiento;
    private JMenu menuVentas;
    private JMenu menuConfiguracion;
    private JMenu menuAyuda;
    
    // Items del menú (botones dentro de cada menú)
    private JMenuItem itemSalir;
    private JMenuItem itemConsultar;
    private JMenuItem itemModificar;
    private JMenuItem itemListar;
    private JMenuItem itemVender;
    private JMenuItem itemConfigDescuentos;
    private JMenuItem itemConfigObsequios;
    private JMenuItem itemAcercaDe;
    
    // ========== CONSTRUCTOR ==========
    /**
     * Constructor de VentanaPrincipal
     * Inicializa todos los componentes de la ventana en el orden correcto:
     * 1. Configura las propiedades básicas de la ventana
     * 2. Crea todos los componentes (menús, items, paneles)
     * 3. Arma el menú con los items
     * 4. Crea el panel principal
     * 5. Carga los datos iniciales de la aplicación
     */
    public VentanaPrincipal() {
        inicializarVentana();           // Paso 1: Configurar propiedades del JFrame
        inicializarComponentes();        // Paso 2: Crear menús e items
        crearMenu();                     // Paso 3: Añadir items a menús
        crearFormulario();               // Paso 4: Crear panel principal
        inicializar();                   // Paso 5: Cargar datos iniciales
    }
    
    // ========== INICIALIZAR VENTANA ==========
    /**
     * Configura las propiedades básicas de la ventana (título, tamaño, ubicación, etc.)
     * Se ejecuta una sola vez al crear la aplicación
     */
    private void inicializarVentana() {
        setTitle(TITULO);                           // Texto que aparece en la barra superior
        setDefaultCloseOperation(EXIT_ON_CLOSE);   // Cerrar la aplicación al hacer clic en X
        setSize(ANCHO_VENTANA, ALTO_VENTANA);      // Tamaño inicial de la ventana
        setLocationRelativeTo(null);                // Centrar la ventana en la pantalla
        setResizable(true);                         // Permitir redimensionar la ventana
    }
    
    // ========== INICIALIZAR COMPONENTES ==========
    /**
     * Crea todos los componentes Swing necesarios:
     * - Barra de menú
     * - Menús principales (Archivo, Mantenimiento, etc.)
     * - Items de menú (Salir, Consultar, etc.)
     * - Asigna acciones (listeners) a cada item
     * 
     * Este método centraliza la creación de componentes para fácil mantenimiento
     */
    private void inicializarComponentes() {
        // Crear la barra de menú (contenedor de menús)
        menuBar = new JMenuBar();
        
        // Crear los 5 menús principales
        menuArchivo = new JMenu(MENU_ARCHIVO);
        menuMantenimiento = new JMenu(MENU_MANTENIMIENTO);
        menuVentas = new JMenu(MENU_VENTAS);
        menuConfiguracion = new JMenu(MENU_CONFIGURACION);
        menuAyuda = new JMenu(MENU_AYUDA);
        
        // Crear items para el menú Archivo
        itemSalir = new JMenuItem(ITEM_SALIR);
        itemSalir.addActionListener(e -> salir());  // Al hacer clic, ejecuta método salir()
        
        // Crear items para el menú Mantenimiento
        itemConsultar = new JMenuItem(ITEM_CONSULTAR);
        itemConsultar.addActionListener(e -> abrirDialogoConsultar());
        
        itemModificar = new JMenuItem(ITEM_MODIFICAR);
        itemModificar.addActionListener(e -> abrirDialogoModificar());
        
        itemListar = new JMenuItem(ITEM_LISTAR);
        itemListar.addActionListener(e -> abrirDialogoListar());
        
        // Crear items para el menú Ventas
        itemVender = new JMenuItem(ITEM_VENDER);
        itemVender.addActionListener(e -> abrirDialogoVender());
        
        // Crear items para el menú Configuración
        itemConfigDescuentos = new JMenuItem(ITEM_CONFIG_DESCUENTOS);
        itemConfigDescuentos.addActionListener(e -> abrirDialogoConfigDescuentos());
        
        itemConfigObsequios = new JMenuItem(ITEM_CONFIG_OBSEQUIOS);
        itemConfigObsequios.addActionListener(e -> abrirDialogoConfigObsequios());
        
        // Crear items para el menú Ayuda
        itemAcercaDe = new JMenuItem(ITEM_ACERCA_DE);
        itemAcercaDe.addActionListener(e -> abrirDialogoAcercaDe());
    }
    
    // ========== CREAR MENÚ ==========
    /**
     * Arma la estructura del menú añadiendo los items a cada menú principal
     * y añadiendo los menús principales a la barra de menú.
     * 
     * Estructura resultante:
     * Barra de menú
     *   └─ Archivo
     *       └─ Salir
     *   └─ Mantenimiento
     *       ├─ Consultar Teléfono Móvil
     *       ├─ Modificar Teléfono Móvil
     *       └─ Listar Teléfonos Móviles
     *   └─ Ventas
     *       └─ Vender
     *   └─ Configuración
     *       ├─ Configurar descuentos
     *       └─ Configurar obsequios
     *   └─ Ayuda
     *       └─ Acerca de Tienda de Celulares
     */
    public void crearMenu() {
        // Añadir items a cada menú
        menuArchivo.add(itemSalir);
        
        menuMantenimiento.add(itemConsultar);
        menuMantenimiento.add(itemModificar);
        menuMantenimiento.add(itemListar);
        
        menuVentas.add(itemVender);
        
        menuConfiguracion.add(itemConfigDescuentos);
        menuConfiguracion.add(itemConfigObsequios);
        
        menuAyuda.add(itemAcercaDe);
        
        // Añadir los menús a la barra de menú
        menuBar.add(menuArchivo);
        menuBar.add(menuMantenimiento);
        menuBar.add(menuVentas);
        menuBar.add(menuConfiguracion);
        menuBar.add(menuAyuda);
        
        // Establecer la barra de menú en la ventana (aparecerá en la parte superior)
        setJMenuBar(menuBar);
    }
    
    // ========== CREAR FORMULARIO (PANEL PRINCIPAL) ==========
    /**
     * Crea el panel principal de la ventana.
     * Por ahora es un panel vacío que centraliza elementos.
     * Se puede extender en el futuro para agregar botones, etiquetas, etc.
     */
    public void crearFormulario() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(panelPrincipal);
    }
    
    // ========== INICIALIZACIÓN DE DATOS ==========
    /**
     * Carga los datos iniciales de la aplicación.
     * Actualmente carga los teléfonos predefinidos en DatosGlobales
     */
    private void inicializar() {
        DatosGlobales.inicializarTelefonos();
    }
    
    // ========== MANEJO DE ACCIONES ==========
    /**
     * Maneja la acción de salir de la aplicación.
     * Muestra un diálogo de confirmación al usuario antes de cerrar.
     */
    private void salir() {
        // Mostrar un diálogo con opciones Sí / No
        int confirmacion = JOptionPane.showConfirmDialog(this,
                MENSAJE_SALIDA,
                DIALOGO_CONFIRMAR,
                JOptionPane.YES_NO_OPTION);
        
        // Si el usuario presiona Sí, cerrar la aplicación
        if (confirmacion == JOptionPane.YES_OPTION) {
            System.exit(0);  // Cierra el programa
        }
    }
    
    // ========== MÉTODOS PARA ABRIR DIÁLOGOS ==========
    /**
     * Abre el diálogo de consulta de teléfono.
     * El diálogo se muestra de manera modal (bloquea la ventana principal)
     */
    private void abrirDialogoConsultar() {
        DialogoConsultarTelefono dialogo = new DialogoConsultarTelefono(this);
        dialogo.setVisible(true);  // Mostrar el diálogo
    }
    
    /**
     * Abre el diálogo de modificación de teléfono
     */
    private void abrirDialogoModificar() {
        DialogoModificarTelefono dialogo = new DialogoModificarTelefono(this);
        dialogo.setVisible(true);
    }
    
    /**
     * Abre el diálogo para listar todos los teléfonos disponibles
     */
    private void abrirDialogoListar() {
        DialogoListarTelefonos dialogo = new DialogoListarTelefonos(this);
        dialogo.setVisible(true);
    }
    
    /**
     * Abre el diálogo para realizar una venta
     */
    private void abrirDialogoVender() {
        DialogoVender dialogo = new DialogoVender(this);
        dialogo.setVisible(true);
    }
    
    /**
     * Abre el diálogo para configurar descuentos por cantidad
     */
    private void abrirDialogoConfigDescuentos() {
        DialogoConfigurarDescuentos dialogo = new DialogoConfigurarDescuentos(this);
        dialogo.setVisible(true);
    }
    
    /**
     * Abre el diálogo para configurar obsequios por cantidad de compra
     */
    private void abrirDialogoConfigObsequios() {
        DialogoConfigurarObsequios dialogo = new DialogoConfigurarObsequios(this);
        dialogo.setVisible(true);
    }
    
    /**
     * Abre el diálogo con información sobre la aplicación
     */
    private void abrirDialogoAcercaDe() {
        DialogoAcercaDe dialogo = new DialogoAcercaDe(this);
        dialogo.setVisible(true);
    }
    
    // ========== MAIN - Punto de entrada de la aplicación ==========
    /**
     * Método main: Punto de entrada de la aplicación Java
     * 
     * SwingUtilities.invokeLater(...) asegura que la interfaz gráfica
     * se cree en el "Event Dispatch Thread" (el hilo correcto para Swing)
     * 
     * @param args Argumentos de línea de comandos (no se usan en esta aplicación)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();  // Crear la ventana principal
            ventana.setVisible(true);                            // Mostrarla en pantalla
        });
    }
}

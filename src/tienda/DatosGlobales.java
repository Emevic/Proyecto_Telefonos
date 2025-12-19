package tienda;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Clase DatosGlobales - Centro de datos y utilidades de la aplicación
 * 
 * Esta clase centraliza todos los datos globales de la aplicación:
 * - Almacenamiento de teléfonos (variables individuales, sin arreglos)
 * - Configuración de descuentos (4 rangos de porcentajes)
 * - Configuración de obsequios (3 tipos según cantidad)
 * - Variables de ventas (contador, total acumulado, cuota diaria)
 * 
 * ARQUITECTURA DE ALMACENAMIENTO:
 * En lugar de usar arrays o colecciones, se usan variables individuales por teléfono.
 * Por ejemplo: marca0, marca1, marca2, marca3, marca4 para las marcas de los 5 teléfonos.
 * Esto permite máxima claridad y control sin estructuras de datos complejas.
 * 
 * MÉTODOS CLAVE:
 * - getTelefono(int indice) - Construye un objeto Telefono a partir de las variables
 * - getCantidadTelefonos() - Retorna cuántos teléfonos están registrados
 * - procesarVenta() - Calcula descuento, genera boleta y actualiza ventas
 * - obtenerPorcentajeDescuento() - Calcula descuento según cantidad
 * - obtenerObsequio() - Asigna obsequio según cantidad
 * 
 * @author Sistema de Tienda de Celulares
 * @version 2.0
 * 
 * Carácteres UNICODE usados:
 * - \u00e1 = á
 * - \u00e9 = é
 * - \u00ed = í
 * - \u00f3 = ó
 * - \u00fa = ú
 * - \u00f1 = ñ
 * - \u00c1 = Á
 * - \u00c9 = É
 * - \u00cd = Í
 * - \u00d3 = Ó
 * - \u00da = Ú
 * - \u00d1 = Ñ
 * 
 */
public class DatosGlobales {
    
    // ========== DATOS DE TELÉFONOS - ALMACENAMIENTO INDIVIDUAL ==========
    // Estructura: variables marcaX, modeloX, ..., precioX para cada teléfono (X = 0-4)
    // Esto reemplaza el uso de arrays para máxima claridad
    
    // Teléfono 0: Apple iPhone
    public static String marca0;
    public static String modelo0;
    public static String sistemaOperativo0;
    public static String procesador0;
    public static String pantalla0;
    public static String color0;
    public static String peso0;
    public static String camaraPrincipal0;
    public static String camaraFrontal0;
    public static String almacenamiento0;
    public static String memoria0;
    public static String medidas0;
    public static double precio0;
    public static String tipoPlan0;

    // Teléfono 1: Samsung Galaxy
    public static String marca1;
    public static String modelo1;
    public static String sistemaOperativo1;
    public static String procesador1;
    public static String pantalla1;
    public static String color1;
    public static String peso1;
    public static String camaraPrincipal1;
    public static String camaraFrontal1;
    public static String almacenamiento1;
    public static String memoria1;
    public static String medidas1;
    public static double precio1;
    public static String tipoPlan1;

    // Teléfono 2: Xiaomi Redmi
    public static String marca2;
    public static String modelo2;
    public static String sistemaOperativo2;
    public static String procesador2;
    public static String pantalla2;
    public static String color2;
    public static String peso2;
    public static String camaraPrincipal2;
    public static String camaraFrontal2;
    public static String almacenamiento2;
    public static String memoria2;
    public static String medidas2;
    public static double precio2;
    public static String tipoPlan2;

    // Teléfono 3: Honor
    public static String marca3;
    public static String modelo3;
    public static String sistemaOperativo3;
    public static String procesador3;
    public static String pantalla3;
    public static String color3;
    public static String peso3;
    public static String camaraPrincipal3;
    public static String camaraFrontal3;
    public static String almacenamiento3;
    public static String memoria3;
    public static String medidas3;
    public static double precio3;
    public static String tipoPlan3;

    // Teléfono 4: Motorola
    public static String marca4;
    public static String modelo4;
    public static String sistemaOperativo4;
    public static String procesador4;
    public static String pantalla4;
    public static String color4;
    public static String peso4;
    public static String camaraPrincipal4;
    public static String camaraFrontal4;
    public static String almacenamiento4;
    public static String memoria4;
    public static String medidas4;
    public static double precio4;
    public static String tipoPlan4;

    // ========== CONFIGURACIÓN DE DESCUENTOS ==========
    // Porcentajes de descuento según cantidad de unidades compradas
    public static double porcentaje1 = 7.5;      // Para compras de 1 a 5 unidades
    public static double porcentaje2 = 10.0;     // Para compras de 6 a 10 unidades
    public static double porcentaje3 = 12.5;     // Para compras de 11 a 15 unidades
    public static double porcentaje4 = 15.0;     // Para compras mayores a 15 unidades

    // ========== CONFIGURACIÓN DE OBSEQUIOS ==========
    // Regalos según cantidad de unidades compradas
    public static String obsequio1 = "Protector de pantalla";  // Para 1 unidad
    public static String obsequio2 = "Funda de tel\u00e9fono";      // Para 2-5 unidades
    public static String obsequio3 = "Cable cargador";         // Para 6+ unidades

    // ========== VARIABLES DE VENTAS ==========
    // Control de ventas realizadas en la sesión
    public static int numeroVenta = 0;                      // Número secuencial de ventas
    public static double importeTotalAcumulado = 0;         // Suma de todos los montos pagados
    public static double cuotaDiaria = 0;                  // Suma acumulada de todas las ventas realizadas

    // Formateo de moneda: prefijo "S/ " y separador de miles con coma
    public static String formatoNumero(double valor) {
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        nf.setGroupingUsed(true);
        return nf.format(valor);
    }

    public static String formatoMoneda(double valor) {
        return "S/ " + formatoNumero(valor);
    }

    // Método para inicializar teléfonos
    public static void inicializarTelefonos() {
        // Asignar los datos solicitados por el usuario
        marca0 = "Apple";
        modelo0 = "iPhone 17 Pro Max";
        sistemaOperativo0 = "iOS 26";
        procesador0 = "Chip A19 Pro";
        pantalla0 = "6.9\"";
        color0 = "Naranja / Azul";
        peso0 = "231gr";
        camaraPrincipal0 = "Sistema de c\u00e1maras Pro Fusion de 48 MP";
        camaraFrontal0 = "C\u00e1mara Center Stage de 18 MP";
        almacenamiento0 = "256Gb / 512Gb / 1Tb / 2Tb";
        memoria0 = "12Gb";
        medidas0 = "16.4cm * 7.8cm * 0.875cm";
        precio0 = 6729.0;
        tipoPlan0 = Math.random() < 0.5 ? "Prepago" : "Postpago";

        marca1 = "Samsung";
        modelo1 = "Galaxy S25 Ultra 256GB Titanium Black";
        sistemaOperativo1 = "Android 15";
        procesador1 = "Qualcomm | SM8750";
        pantalla1 = "6.9\"";
        color1 = "Gris / Negro";
        peso1 = "218gr";
        camaraPrincipal1 = "200MP + 50MP + 50MP + 10MP";
        camaraFrontal1 = "12MP";
        almacenamiento1 = "256Gb";
        memoria1 = "12GB + 8GB";
        medidas1 = "16.28cm * 7.76cm * 0.82cm";
        precio1 = 4869.0;
        tipoPlan1 = Math.random() < 0.5 ? "Prepago" : "Postpago";

        marca2 = "Xiaomi";
        modelo2 = "Redmi Note 14 256GB Negro";
        sistemaOperativo2 = "Android 14";
        procesador2 = "Mediatek Helio G99 - Ultra";
        pantalla2 = "6.67\"";
        color2 = "Negro / Azul";
        peso2 = "200gr";
        camaraPrincipal2 = "108MP+2MP+2MP";
        camaraFrontal2 = "20MP";
        almacenamiento2 = "256Gb";
        memoria2 = "8GB";
        medidas2 = "16.324cm * 7.655cm * 0.816cm";
        precio2 = 739.0;
        tipoPlan2 = Math.random() < 0.5 ? "Prepago" : "Postpago";

        marca3 = "Honor";
        modelo3 = "Honor X8C Negro Medianoche 256GB";
        sistemaOperativo3 = "Android 15";
        procesador3 = "Qualcomm Snapdragon 685";
        pantalla3 = "6.7\"";
        color3 = "Negro / Violeta";
        peso3 = "174gr";
        camaraPrincipal3 = "108MP+5MP";
        camaraFrontal3 = "50MP";
        almacenamiento3 = "256Gb";
        memoria3 = "8GB + HONOR RAM Turbo 8GB";
        medidas3 = "16.105cm * 7.455cm * 0.712cm";
        precio3 = 849.0;
        tipoPlan3 = Math.random() < 0.5 ? "Prepago" : "Postpago";

        marca4 = "Motorola";
        modelo4 = "Moto G06 128GB Azul";
        sistemaOperativo4 = "Android 15";
        procesador4 = "Mediatek Helio G81Extreme";
        pantalla4 = "6.8\"";
        color4 = "Azul";
        peso4 = "194gr";
        camaraPrincipal4 = "50MP + Flicker Sensor";
        camaraFrontal4 = "8MP";
        almacenamiento4 = "128Gb";
        memoria4 = "4 GB (f\u00edsica) + hasta 8 GB (RAM Boost)";
        medidas4 = "17.135cm * 7.555cm * 0.831cm";
        precio4 = 489.0;
        tipoPlan4 = Math.random() < 0.5 ? "Prepago" : "Postpago";
    }

    // Método para obtener el índice de un teléfono por modelo
    public static int obtenerIndiceModelo(String modelo) {
        for (int i = 0; i < getCantidadTelefonos(); i++) {
            Telefono t = getTelefono(i);
            if (t != null && t.getModelo().equals(modelo)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Obtiene el porcentaje de descuento aplicable según la cantidad de teléfonos comprados.
     * Utiliza los rangos configurados: 1-5, 6-10, 11-15, 16+ unidades.
     * 
     * @param cantidad Cantidad de teléfonos comprados
     * @return Porcentaje de descuento (0-100)
     */
    public static double obtenerPorcentajeDescuento(int cantidad) {
        if (cantidad <= 5) {
            return porcentaje1;
        } else if (cantidad <= 10) {
            return porcentaje2;
        } else if (cantidad <= 15) {
            return porcentaje3;
        } else {
            return porcentaje4;
        }
    }

    /**
     * Obtiene el obsequio correspondiente según la cantidad de teléfonos comprados.
     * Utiliza los rangos: 1 unidad, 2-5 unidades, 6+ unidades.
     * 
     * @param cantidad Cantidad de teléfonos comprados
     * @return Descripción del obsequio o cadena vacía si no aplica
     */
    public static String obtenerObsequio(int cantidad) {
        if (cantidad <= 0) {
            return ""; // sin obsequio válido
        }
        if (cantidad == 1) {
            return obsequio1;
        } else if (cantidad <= 5) {
            return obsequio2;
        } else {
            return obsequio3;
        }
    }

    // Utilidades para manipular los teléfonos enumerados
    /**
     * Obtiene un objeto Telefono basado en el índice proporcionado.
     * Construye el objeto a partir de las variables estáticas individuales.
     * 
     * @param indice Índice del teléfono (0-4)
     * @return Objeto Telefono correspondiente al índice, o null si no existe
     */
    public static Telefono getTelefono(int indice) {
        switch (indice) {
            case 0:
                if (modelo0 == null) return null;
                return new Telefono(marca0, modelo0, color0, camaraPrincipal0, camaraFrontal0, sistemaOperativo0, procesador0, pantalla0, almacenamiento0, memoria0, precio0, medidas0, tipoPlan0, peso0);
            case 1:
                if (modelo1 == null) return null;
                return new Telefono(marca1, modelo1, color1, camaraPrincipal1, camaraFrontal1, sistemaOperativo1, procesador1, pantalla1, almacenamiento1, memoria1, precio1, medidas1, tipoPlan1, peso1);
            case 2:
                if (modelo2 == null) return null;
                return new Telefono(marca2, modelo2, color2, camaraPrincipal2, camaraFrontal2, sistemaOperativo2, procesador2, pantalla2, almacenamiento2, memoria2, precio2, medidas2, tipoPlan2, peso2);
            case 3:
                if (modelo3 == null) return null;
                return new Telefono(marca3, modelo3, color3, camaraPrincipal3, camaraFrontal3, sistemaOperativo3, procesador3, pantalla3, almacenamiento3, memoria3, precio3, medidas3, tipoPlan3, peso3);
            case 4:
                if (modelo4 == null) return null;
                return new Telefono(marca4, modelo4, color4, camaraPrincipal4, camaraFrontal4, sistemaOperativo4, procesador4, pantalla4, almacenamiento4, memoria4, precio4, medidas4, tipoPlan4, peso4);
            default:
                return null;
        }
    }

    /**
     * Actualiza un teléfono en el índice especificado con los datos del objeto Telefono proporcionado.
     * 
     * @param indice Índice del teléfono a actualizar (0-4)
     * @param tel Objeto Telefono con los nuevos datos
     */
    public static void setTelefono(int indice, Telefono tel) {
        if (tel == null) return;
        switch (indice) {
            case 0:
                marca0 = tel.getMarca();
                modelo0 = tel.getModelo();
                color0 = tel.getColor();
                camaraPrincipal0 = tel.getCamaraPrincipal();
                camaraFrontal0 = tel.getCamaraFrontal();
                sistemaOperativo0 = tel.getSistemaOperativo();
                procesador0 = tel.getProcesador();
                pantalla0 = tel.getPantalla();
                almacenamiento0 = tel.getCapacidadAlmacenamiento();
                memoria0 = tel.getMemoria();
                precio0 = tel.getPrecio();
                medidas0 = tel.getMedidas();
                tipoPlan0 = tel.getTipoPlan();
                peso0 = tel.getPeso();
                break;
            case 1:
                marca1 = tel.getMarca();
                modelo1 = tel.getModelo();
                color1 = tel.getColor();
                camaraPrincipal1 = tel.getCamaraPrincipal();
                camaraFrontal1 = tel.getCamaraFrontal();
                sistemaOperativo1 = tel.getSistemaOperativo();
                procesador1 = tel.getProcesador();
                pantalla1 = tel.getPantalla();
                almacenamiento1 = tel.getCapacidadAlmacenamiento();
                memoria1 = tel.getMemoria();
                precio1 = tel.getPrecio();
                medidas1 = tel.getMedidas();
                tipoPlan1 = tel.getTipoPlan();
                peso1 = tel.getPeso();
                break;
            case 2:
                marca2 = tel.getMarca();
                modelo2 = tel.getModelo();
                color2 = tel.getColor();
                camaraPrincipal2 = tel.getCamaraPrincipal();
                camaraFrontal2 = tel.getCamaraFrontal();
                sistemaOperativo2 = tel.getSistemaOperativo();
                procesador2 = tel.getProcesador();
                pantalla2 = tel.getPantalla();
                almacenamiento2 = tel.getCapacidadAlmacenamiento();
                memoria2 = tel.getMemoria();
                precio2 = tel.getPrecio();
                medidas2 = tel.getMedidas();
                tipoPlan2 = tel.getTipoPlan();
                peso2 = tel.getPeso();
                break;
            case 3:
                marca3 = tel.getMarca();
                modelo3 = tel.getModelo();
                color3 = tel.getColor();
                camaraPrincipal3 = tel.getCamaraPrincipal();
                camaraFrontal3 = tel.getCamaraFrontal();
                sistemaOperativo3 = tel.getSistemaOperativo();
                procesador3 = tel.getProcesador();
                pantalla3 = tel.getPantalla();
                almacenamiento3 = tel.getCapacidadAlmacenamiento();
                memoria3 = tel.getMemoria();
                precio3 = tel.getPrecio();
                medidas3 = tel.getMedidas();
                tipoPlan3 = tel.getTipoPlan();
                peso3 = tel.getPeso();
                break;
            case 4:
                marca4 = tel.getMarca();
                modelo4 = tel.getModelo();
                color4 = tel.getColor();
                camaraPrincipal4 = tel.getCamaraPrincipal();
                camaraFrontal4 = tel.getCamaraFrontal();
                sistemaOperativo4 = tel.getSistemaOperativo();
                procesador4 = tel.getProcesador();
                pantalla4 = tel.getPantalla();
                almacenamiento4 = tel.getCapacidadAlmacenamiento();
                memoria4 = tel.getMemoria();
                precio4 = tel.getPrecio();
                medidas4 = tel.getMedidas();
                tipoPlan4 = tel.getTipoPlan();
                peso4 = tel.getPeso();
                break;
            default:
                // no-op
        }
    }

    /**
     * Obtiene la cantidad de teléfonos registrados actualmente.
     * Cuenta cuántos teléfonos tienen modelo no nulo.
     * 
     * @return Número de teléfonos registrados (0-5)
     */
    public static int getCantidadTelefonos() {
        int c = 0;
        if (modelo0 != null) c++;
        if (modelo1 != null) c++;
        if (modelo2 != null) c++;
        if (modelo3 != null) c++;
        if (modelo4 != null) c++;
        return c;
    }

    /**
     * Agrega un nuevo teléfono a la lista de teléfonos registrados.
     * Asigna el teléfono al primer slot disponible (modeloX == null).
     * Si no hay slots disponibles, no hace nada.
     * 
     * @param tel Objeto Telefono a agregar
     */
    public static void agregarTelefono(Telefono tel) {
        if (tel == null) return;
        if (modelo0 == null) {
            marca0 = tel.getMarca(); modelo0 = tel.getModelo(); color0 = tel.getColor(); camaraPrincipal0 = tel.getCamaraPrincipal(); camaraFrontal0 = tel.getCamaraFrontal(); sistemaOperativo0 = tel.getSistemaOperativo(); procesador0 = tel.getProcesador(); pantalla0 = tel.getPantalla(); almacenamiento0 = tel.getCapacidadAlmacenamiento(); memoria0 = tel.getMemoria(); precio0 = tel.getPrecio(); medidas0 = tel.getMedidas(); tipoPlan0 = tel.getTipoPlan(); peso0 = tel.getPeso(); return;
        }
        if (modelo1 == null) {
            marca1 = tel.getMarca(); modelo1 = tel.getModelo(); color1 = tel.getColor(); camaraPrincipal1 = tel.getCamaraPrincipal(); camaraFrontal1 = tel.getCamaraFrontal(); sistemaOperativo1 = tel.getSistemaOperativo(); procesador1 = tel.getProcesador(); pantalla1 = tel.getPantalla(); almacenamiento1 = tel.getCapacidadAlmacenamiento(); memoria1 = tel.getMemoria(); precio1 = tel.getPrecio(); medidas1 = tel.getMedidas(); tipoPlan1 = tel.getTipoPlan(); peso1 = tel.getPeso(); return;
        }
        if (modelo2 == null) {
            marca2 = tel.getMarca(); modelo2 = tel.getModelo(); color2 = tel.getColor(); camaraPrincipal2 = tel.getCamaraPrincipal(); camaraFrontal2 = tel.getCamaraFrontal(); sistemaOperativo2 = tel.getSistemaOperativo(); procesador2 = tel.getProcesador(); pantalla2 = tel.getPantalla(); almacenamiento2 = tel.getCapacidadAlmacenamiento(); memoria2 = tel.getMemoria(); precio2 = tel.getPrecio(); medidas2 = tel.getMedidas(); tipoPlan2 = tel.getTipoPlan(); peso2 = tel.getPeso(); return;
        }
        if (modelo3 == null) {
            marca3 = tel.getMarca(); modelo3 = tel.getModelo(); color3 = tel.getColor(); camaraPrincipal3 = tel.getCamaraPrincipal(); camaraFrontal3 = tel.getCamaraFrontal(); sistemaOperativo3 = tel.getSistemaOperativo(); procesador3 = tel.getProcesador(); pantalla3 = tel.getPantalla(); almacenamiento3 = tel.getCapacidadAlmacenamiento(); memoria3 = tel.getMemoria(); precio3 = tel.getPrecio(); medidas3 = tel.getMedidas(); tipoPlan3 = tel.getTipoPlan(); peso3 = tel.getPeso(); return;
        }
        if (modelo4 == null) {
            marca4 = tel.getMarca(); modelo4 = tel.getModelo(); color4 = tel.getColor(); camaraPrincipal4 = tel.getCamaraPrincipal(); camaraFrontal4 = tel.getCamaraFrontal(); sistemaOperativo4 = tel.getSistemaOperativo(); procesador4 = tel.getProcesador(); pantalla4 = tel.getPantalla(); almacenamiento4 = tel.getCapacidadAlmacenamiento(); memoria4 = tel.getMemoria(); precio4 = tel.getPrecio(); medidas4 = tel.getMedidas(); tipoPlan4 = tel.getTipoPlan(); peso4 = tel.getPeso(); return;
        }
    }

    /**
     * Elimina un teléfono de la lista por índice y compacta la lista.
     * Desplaza todos los teléfonos siguientes hacia arriba para llenar el hueco.
     * 
     * @param indice Índice del teléfono a eliminar (0-4)
     */
    public static void eliminarTelefono(int indice) {
        // Eliminación y compactación: desplazar hacia arriba los teléfonos
        switch (indice) {
            case 0:
                // shift everything up
                marca0 = marca1; modelo0 = modelo1; sistemaOperativo0 = sistemaOperativo1; procesador0 = procesador1; pantalla0 = pantalla1; color0 = color1; peso0 = peso1; camaraPrincipal0 = camaraPrincipal1; camaraFrontal0 = camaraFrontal1; almacenamiento0 = almacenamiento1; memoria0 = memoria1; medidas0 = medidas1; precio0 = precio1; tipoPlan0 = tipoPlan1;
                marca1 = marca2; modelo1 = modelo2; sistemaOperativo1 = sistemaOperativo2; procesador1 = procesador2; pantalla1 = pantalla2; color1 = color2; peso1 = peso2; camaraPrincipal1 = camaraPrincipal2; camaraFrontal1 = camaraFrontal2; almacenamiento1 = almacenamiento2; memoria1 = memoria2; medidas1 = medidas2; precio1 = precio2; tipoPlan1 = tipoPlan2;
                marca2 = marca3; modelo2 = modelo3; sistemaOperativo2 = sistemaOperativo3; procesador2 = procesador3; pantalla2 = pantalla3; color2 = color3; peso2 = peso3; camaraPrincipal2 = camaraPrincipal3; camaraFrontal2 = camaraFrontal3; almacenamiento2 = almacenamiento3; memoria2 = memoria3; medidas2 = medidas3; precio2 = precio3; tipoPlan2 = tipoPlan3;
                marca3 = marca4; modelo3 = modelo4; sistemaOperativo3 = sistemaOperativo4; procesador3 = procesador4; pantalla3 = pantalla4; color3 = color4; peso3 = peso4; camaraPrincipal3 = camaraPrincipal4; camaraFrontal3 = camaraFrontal4; almacenamiento3 = almacenamiento4; memoria3 = memoria4; medidas3 = medidas4; precio3 = precio4; tipoPlan3 = tipoPlan4;
                marca4 = null; modelo4 = null; sistemaOperativo4 = null; procesador4 = null; pantalla4 = null; color4 = null; peso4 = null; camaraPrincipal4 = null; camaraFrontal4 = null; almacenamiento4 = null; memoria4 = null; medidas4 = null; precio4 = 0.0; tipoPlan4 = null;
                break;
            case 1:
                marca1 = marca2; modelo1 = modelo2; sistemaOperativo1 = sistemaOperativo2; procesador1 = procesador2; pantalla1 = pantalla2; color1 = color2; peso1 = peso2; camaraPrincipal1 = camaraPrincipal2; camaraFrontal1 = camaraFrontal2; almacenamiento1 = almacenamiento2; memoria1 = memoria2; medidas1 = medidas2; precio1 = precio2; tipoPlan1 = tipoPlan2;
                marca2 = marca3; modelo2 = modelo3; sistemaOperativo2 = sistemaOperativo3; procesador2 = procesador3; pantalla2 = pantalla3; color2 = color3; peso2 = peso3; camaraPrincipal2 = camaraPrincipal3; camaraFrontal2 = camaraFrontal3; almacenamiento2 = almacenamiento3; memoria2 = memoria3; medidas2 = medidas3; precio2 = precio3; tipoPlan2 = tipoPlan3;
                marca3 = marca4; modelo3 = modelo4; sistemaOperativo3 = sistemaOperativo4; procesador3 = procesador4; pantalla3 = pantalla4; color3 = color4; peso3 = peso4; camaraPrincipal3 = camaraPrincipal4; camaraFrontal3 = camaraFrontal4; almacenamiento3 = almacenamiento4; memoria3 = memoria4; medidas3 = medidas4; precio3 = precio4; tipoPlan3 = tipoPlan4;
                marca4 = null; modelo4 = null; sistemaOperativo4 = null; procesador4 = null; pantalla4 = null; color4 = null; peso4 = null; camaraPrincipal4 = null; camaraFrontal4 = null; almacenamiento4 = null; memoria4 = null; medidas4 = null; precio4 = 0.0; tipoPlan4 = null;
                break;
            case 2:
                marca2 = marca3; modelo2 = modelo3; sistemaOperativo2 = sistemaOperativo3; procesador2 = procesador3; pantalla2 = pantalla3; color2 = color3; peso2 = peso3; camaraPrincipal2 = camaraPrincipal3; camaraFrontal2 = camaraFrontal3; almacenamiento2 = almacenamiento3; memoria2 = memoria3; medidas2 = medidas3; precio2 = precio3; tipoPlan2 = tipoPlan3;
                marca3 = marca4; modelo3 = modelo4; sistemaOperativo3 = sistemaOperativo4; procesador3 = procesador4; pantalla3 = pantalla4; color3 = color4; peso3 = peso4; camaraPrincipal3 = camaraPrincipal4; camaraFrontal3 = camaraFrontal4; almacenamiento3 = almacenamiento4; memoria3 = memoria4; medidas3 = medidas4; precio3 = precio4; tipoPlan3 = tipoPlan4;
                marca4 = null; modelo4 = null; sistemaOperativo4 = null; procesador4 = null; pantalla4 = null; color4 = null; peso4 = null; camaraPrincipal4 = null; camaraFrontal4 = null; almacenamiento4 = null; memoria4 = null; medidas4 = null; precio4 = 0.0; tipoPlan4 = null;
                break;
            case 3:
                marca3 = marca4; modelo3 = modelo4; sistemaOperativo3 = sistemaOperativo4; procesador3 = procesador4; pantalla3 = pantalla4; color3 = color4; peso3 = peso4; camaraPrincipal3 = camaraPrincipal4; camaraFrontal3 = camaraFrontal4; almacenamiento3 = almacenamiento4; memoria3 = memoria4; medidas3 = medidas4; precio3 = precio4; tipoPlan3 = tipoPlan4;
                marca4 = null; modelo4 = null; sistemaOperativo4 = null; procesador4 = null; pantalla4 = null; color4 = null; peso4 = null; camaraPrincipal4 = null; camaraFrontal4 = null; almacenamiento4 = null; memoria4 = null; medidas4 = null; precio4 = 0.0; tipoPlan4 = null;
                break;
            case 4:
                marca4 = null; modelo4 = null; sistemaOperativo4 = null; procesador4 = null; pantalla4 = null; color4 = null; peso4 = null; camaraPrincipal4 = null; camaraFrontal4 = null; almacenamiento4 = null; memoria4 = null; medidas4 = null; precio4 = 0.0; tipoPlan4 = null;
                break;
            default:
                // no-op
        }
    }

    /**
     * Procesa una venta de teléfonos y genera una boleta formateada.
     * Calcula descuentos, obsequios, actualiza contadores de ventas y acumula el total diario.
     * 
     * @param indice Índice del teléfono a vender
     * @param cantidad Cantidad de unidades a vender
     * @return Cadena con la boleta formateada o mensaje de error
     */
    public static String procesarVenta(int indice, int cantidad) {
        Telefono tel = getTelefono(indice);
        if (tel == null) {
            return "Error: modelo inv\u00e1lido.";
        }
        if (cantidad <= 0) {
            return "Error: la cantidad debe ser mayor a 0.";
        }

        double precioUnitario = tel.getPrecio();
        double importeCompra = precioUnitario * cantidad;
        double porcentajeDescuento = obtenerPorcentajeDescuento(cantidad);
        double importeDescuento = importeCompra * (porcentajeDescuento / 100);
        double importePagar = importeCompra - importeDescuento;
        String obsequio = obtenerObsequio(cantidad);

        numeroVenta++;
        importeTotalAcumulado += importePagar;
        cuotaDiaria += importePagar;  // Agregar el monto de la venta a cuotaDiaria

        StringBuilder boleta = new StringBuilder();
        boleta.append("═══════════════════════════════════════════════\n");
        boleta.append("                   BOLETA DE VENTA\n");
        boleta.append("═══════════════════════════════════════════════\n\n");
        boleta.append("Venta #: ").append(numeroVenta).append("\n");
        boleta.append("Marca: ").append(tel.getMarca()).append("\n");
        boleta.append("Modelo: ").append(tel.getModelo()).append("\n");
        boleta.append("─────────────────────────────────────────────\n");
        boleta.append("Precio Unitario: ").append(formatoMoneda(precioUnitario)).append("\n");
        boleta.append("Cantidad:        ").append(cantidad).append(" unidades\n");
        boleta.append("─────────────────────────────────────────────\n");
        boleta.append("Importe de Compra: ").append(formatoMoneda(importeCompra)).append("\n");
        boleta.append("Importe de Descuento (").append(String.format("%.0f", porcentajeDescuento)).append("%): ").append(formatoMoneda(-importeDescuento)).append("\n");
        boleta.append("─────────────────────────────────────────────\n");
        boleta.append("IMPORTE A PAGAR:   ").append(formatoMoneda(importePagar)).append("\n");
        boleta.append("─────────────────────────────────────────────\n");
        boleta.append("Obsequio: ").append(obsequio).append("\n");
        boleta.append("═══════════════════════════════════════════════\n");

        return boleta.toString();
    }
}

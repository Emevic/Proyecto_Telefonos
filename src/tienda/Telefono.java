package tienda;

/**
 * Clase Telefono - Modelo de datos para representar un teléfono móvil
 * 
 * Esta clase encapsula todos los atributos de un teléfono móvil y proporciona
 * métodos getter y setter para acceder y modificar sus valores.
 * 
 * Atributos:
 * - marca: Fabricante del teléfono (ej: Apple, Samsung, Xiaomi)
 * - modelo: Nombre del modelo específico (ej: iPhone 14, Galaxy S23)
 * - color: Color del teléfono (ej: Negro, Azul, Rojo)
 * - procesador: Chip principal (ej: A16 Bionic, Snapdragon 8 Gen 2)
 * - pantalla: Especificaciones de pantalla (ej: 6.1" OLED 120Hz)
 * - camaraFrontal: Especificaciones de cámara frontal (ej: 12MP f/2.2)
 * - camaraPrincipal: Especificaciones de cámara trasera (ej: 48MP f/1.8)
 * - sistemaOperativo: SO del dispositivo (ej: iOS 17, Android 14)
 * - capacidadAlmacenamiento: Almacenamiento disponible (ej: 256GB)
 * - memoria: RAM del dispositivo (ej: 8GB)
 * - medidas: Dimensiones físicas (ej: 147.5 x 71.6 x 7.80 mm)
 * - peso: Peso del dispositivo (ej: 169g)
 * - tipoPlan: Tipo de plan (Prepago, Postpago, Contrato)
 * - precio: Precio de venta en moneda local
 * 
 * @author Sistema de Tienda de Celulares
 * @version 2.0
 */
public class Telefono {
    
    // ========== ATRIBUTOS PRIVADOS ==========
    // Información básica del teléfono
    private String marca;                      // Fabricante (Apple, Samsung, etc.)
    private String modelo;                     // Nombre del modelo específico
    private String color;                      // Color del dispositivo
    
    // Especificaciones técnicas
    private String procesador;                 // Chip central del teléfono
    private String pantalla;                   // Tipo y tamaño de pantalla
    private String camaraPrincipal;            // Cámara trasera especificaciones
    private String camaraFrontal;              // Cámara frontal especificaciones
    private String sistemaOperativo;           // SO (iOS, Android, etc.)
    private String memoria;                    // RAM en GB
    private String capacidadAlmacenamiento;    // Almacenamiento total
    
    // Información física y comercial
    private String medidas;                    // Dimensiones en centímetros
    private String peso;                       // Peso en gramos
    private String tipoPlan;                   // Tipo de plan (Prepago/Postpago)
    private double precio;                     // Precio de venta
    
    // ========== CONSTRUCTOR ==========
    /**
     * Constructor que inicializa un teléfono con todos sus atributos.
     * 
     * Este constructor recibe 14 parámetros correspondientes a cada atributo del teléfono.
     * Todos los parámetros son obligatorios para crear un objeto Telefono.
     * 
     * @param marca            Fabricante del teléfono
     * @param modelo           Modelo específico
     * @param color            Color del dispositivo
     * @param camaraPrincipal  Especificaciones de cámara trasera
     * @param camaraFrontal    Especificaciones de cámara frontal
     * @param sistemaOperativo Sistema operativo
     * @param procesador       Procesador del dispositivo
     * @param pantalla         Especificaciones de pantalla
     * @param capacidadAlmacenamiento Almacenamiento total
     * @param memoria          RAM del dispositivo
     * @param precio           Precio de venta
     * @param medidas          Dimensiones físicas
     * @param tipoPlan         Tipo de plan
     * @param peso             Peso del dispositivo
     */
    public Telefono(String marca, String modelo, String color, String camaraPrincipal, String camaraFrontal,
                    String sistemaOperativo, String procesador, String pantalla, String capacidadAlmacenamiento, String memoria,
                    double precio, String medidas, String tipoPlan, String peso) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.camaraPrincipal = camaraPrincipal;
        this.camaraFrontal = camaraFrontal;
        this.sistemaOperativo = sistemaOperativo;
        this.procesador = procesador;
        this.pantalla = pantalla;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.memoria = memoria;
        this.precio = precio;
        this.medidas = medidas;
        this.tipoPlan = tipoPlan;
        this.peso = peso;
    }
    
    // ========== GETTERS (LECTORES) ==========
    // Métodos para obtener valores de los atributos (solo lectura)
    
    /**
     * Obtiene la marca del teléfono
     * @return marca del fabricante
     */
    public String getMarca() {
        return marca;
    }
    
    /**
     * Obtiene el modelo del teléfono
     * @return nombre del modelo específico
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Obtiene el color del teléfono
     * @return color del dispositivo
     */
    public String getColor() {
        return color;
    }
    
    /**
     * Obtiene las especificaciones de la cámara trasera
     * @return especificaciones de cámara principal
     */
    public String getCamaraPrincipal() {
        return camaraPrincipal;
    }

    /**
     * Obtiene las especificaciones de la cámara frontal
     * @return especificaciones de cámara frontal
     */
    public String getCamaraFrontal() {
        return camaraFrontal;
    }

    /**
     * Obtiene el procesador del teléfono
     * @return nombre y modelo del procesador
     */
    public String getProcesador() {
        return procesador;
    }

    /**
     * Obtiene las especificaciones de la pantalla
     * @return especificaciones de pantalla (tamaño, tipo, Hz)
     */
    public String getPantalla() {
        return pantalla;
    }

    /**
     * Obtiene el peso del teléfono
     * @return peso en gramos
     */
    public String getPeso() {
        return peso;
    }

    /**
     * Obtiene la memoria RAM del teléfono
     * @return capacidad de RAM en GB
     */
    public String getMemoria() {
        return memoria;
    }
    
    /**
     * Obtiene el sistema operativo
     * @return SO (iOS, Android, etc.)
     */
    public String getSistemaOperativo() {
        return sistemaOperativo;
    }
    
    /**
     * Obtiene la capacidad de almacenamiento
     * @return capacidad de almacenamiento en GB
     */
    public String getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }
    
    /**
     * Obtiene el precio del teléfono
     * @return precio en moneda local
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Obtiene las medidas del teléfono
     * @return dimensiones en milímetros o centímetros
     */
    public String getMedidas() {
        return medidas;
    }
    
    /**
     * Obtiene el tipo de plan
     * @return tipo de plan (Prepago, Postpago, etc.)
     */
    public String getTipoPlan() {
        return tipoPlan;
    }
    
    // ========== SETTERS (MODIFICADORES) ==========
    // Métodos para cambiar valores de los atributos
    
    /**
     * Establece la marca del teléfono
     * @param marca nuevo valor de marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Establece el modelo del teléfono
     * @param modelo nuevo valor de modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Establece el color del teléfono
     * @param color nuevo valor de color
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Establece las especificaciones de la cámara trasera
     * @param camaraPrincipal nuevas especificaciones
     */
    public void setCamaraPrincipal(String camaraPrincipal) {
        this.camaraPrincipal = camaraPrincipal;
    }

    /**
     * Establece las especificaciones de la cámara frontal
     * @param camaraFrontal nuevas especificaciones
     */
    public void setCamaraFrontal(String camaraFrontal) {
        this.camaraFrontal = camaraFrontal;
    }

    /**
     * Establece el procesador del teléfono
     * @param procesador nuevo procesador
     */
    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    /**
     * Establece las especificaciones de la pantalla
     * @param pantalla nuevas especificaciones
     */
    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    /**
     * Establece el peso del teléfono
     * @param peso nuevo peso
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     * Establece la memoria RAM
     * @param memoria nueva capacidad de RAM
     */
    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }
    
    /**
     * Establece el sistema operativo
     * @param sistemaOperativo nuevo SO
     */
    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
    
    /**
     * Establece la capacidad de almacenamiento
     * @param capacidadAlmacenamiento nueva capacidad
     */
    public void setCapacidadAlmacenamiento(String capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }
    
    /**
     * Establece el precio del teléfono
     * @param precio nuevo precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    /**
     * Establece las medidas del teléfono
     * @param medidas nuevas dimensiones
     */
    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }
    
    /**
     * Establece el tipo de plan
     * @param tipoPlan nuevo tipo de plan
     */
    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }
}

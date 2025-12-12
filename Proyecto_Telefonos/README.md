# Proyecto_Telefonos

Proyecto educativo: "Tienda de Celulares 1.0" - Sistema de gestión de inventario y ventas.

## Descripción
Aplicación Java Swing para gestionar un catálogo de teléfonos móviles y procesar ventas con descuentos y obsequios automáticos.

## Estructura del Proyecto
```
Proyecto_Telefonos/
├── src/tienda/              # Código fuente Java
│   ├── VentanaPrincipal.java
│   ├── Telefono.java
│   ├── DatosGlobales.java
│   └── Dialogo*.java (7 diálogos)
├── bin/                     # Clases compiladas
├── README.md               # Este archivo
└── INFORME_PROYECTO.md     # Documentación detallada
```

## Características Principales
- ✅ Consultar detalles de teléfonos
- ✅ Listar todos los teléfonos disponibles
- ✅ Modificar atributos de teléfonos
- ✅ Procesar ventas con cálculo automático de descuentos
- ✅ Asignación automática de obsequios según cantidad
- ✅ Configuración de descuentos y obsequios
- ✅ Interfaz gráfica intuitiva (Swing)

## Compilación (Windows PowerShell)

```powershell
# Crear directorio bin si no existe
if (-not (Test-Path -Path "bin")) { New-Item -ItemType Directory -Path "bin" }

# Compilar todos los archivos Java
javac -d bin src\tienda\*.java
```

## Ejecución

```powershell
# Ejecutar la aplicación
java -cp bin tienda.VentanaPrincipal
```

## Módulos del Proyecto

### VentanaPrincipal.java
Ventana principal que contiene la barra de menú con 5 opciones:
- **Archivo**: Salir
- **Mantenimiento**: Consultar, Modificar, Listar teléfonos
- **Ventas**: Procesar ventas
- **Configuración**: Ajustar descuentos y obsequios
- **Ayuda**: Información sobre la aplicación

### Telefono.java
Clase modelo que representa un teléfono con:
- 14 atributos (marca, modelo, color, procesador, pantalla, etc.)
- Constructor completo
- Getters y Setters para cada atributo

### DatosGlobales.java
Centro de datos que almacena:
- Hasta 5 teléfonos (variables individuales: marca0-4, modelo0-4, etc.)
- Configuración de descuentos (4 rangos por cantidad)
- Configuración de obsequios (3 tipos por cantidad)
- Métodos para procesar ventas y calcular descuentos
- Variables de control de ventas (contador, total acumulado, cuota diaria)

### Diálogos (7 archivos)
- **DialogoConsultarTelefono**: Ver detalles de un teléfono
- **DialogoListarTelefonos**: Mostrar reporte de todos los teléfonos
	- **Actualización importante**: `DialogoListarTelefonos` ahora incluye un selector de orden (`JComboBox`) que permite ordenar la lista por: `Precio (Mayor → Menor)`, `Precio (Menor → Mayor)` y `Marca (A → Z)` sin modificar `DatosGlobales`.
- **DialogoModificarTelefono**: Editar atributos de un teléfono
- **DialogoVender**: Procesar venta y generar boleta
- **DialogoConfigurarDescuentos**: Ajustar porcentajes de descuento
- **DialogoConfigurarObsequios**: Modificar nombres de obsequios
- **DialogoAcercaDe**: Información sobre la aplicación y autores

## Requisitos Técnicos
- **Lenguaje**: Java 8 o superior
- **Framework UI**: Swing (incluido en JDK)
- **Sistema Operativo**: Windows, macOS, Linux (cualquiera con JDK)

## Estado de Compilación
- ✅ **Errores**: 0
- ⚠️ **Advertencias**: 8 (principalmente `this-escape` - no impiden ejecución)
- ✅ **Funcionalidad**: 100% operativa

### Advertencias detectadas (salida de compilación)
- `src/tienda/DialogoAcercaDe.java` - possible 'this' escape (setDefaultCloseOperation)
- `src/tienda/DialogoConfigurarDescuentos.java` - possible 'this' escape (setDefaultCloseOperation)
- `src/tienda/DialogoConfigurarObsequios.java` - possible 'this' escape (setDefaultCloseOperation)
- `src/tienda/DialogoConsultarTelefono.java` - possible 'this' escape (setDefaultCloseOperation)
- `src/tienda/DialogoListarTelefonos.java` - possible 'this' escape (setDefaultCloseOperation)
- `src/tienda/DialogoModificarTelefono.java` - possible 'this' escape (setDefaultCloseOperation)
- `src/tienda/DialogoVender.java` - possible 'this' escape (setDefaultCloseOperation)
- `src/tienda/VentanaPrincipal.java` - possible 'this' escape (crearMenu call in constructor)

Nota: Estas advertencias son no-críticas y se producen porque algunos métodos que usan `this` se llaman durante la construcción del objeto. Si deseas, puedo remediarlas moviendo esos registros/llamadas al final de cada constructor sin cambiar la funcionalidad.

## Notas de Mantenimiento
- El código está comentado para facilitar la lectura a programadores novatos
- Cada diálogo es completamente funcional y maneja errores básicos
- Los datos se almacenan en memoria (sin persistencia a disco)
- Se proporciona documentación detallada en `INFORME_PROYECTO.md`

## Mejoras Futuras Recomendadas
1. Refactorizar `DatosGlobales` para usar `List<Telefono>` (mejor escalabilidad)
2. Agregar persistencia (guardar datos en archivo o BD)
3. Crear pruebas unitarias con JUnit
4. Internacionalización (i18n) para múltiples idiomas
5. Mejoras de validación en formularios

## Historial de Cambios (24/11/2025)
- ✅ Corregido error de doble cierre de diálogos (cambio de `DISPOSE_ON_CLOSE` a `DO_NOTHING_ON_CLOSE`)
- ✅ Añadidos `serialVersionUID` y JavaDoc de clase en diálogos para mejorar warnings y documentación
- ✅ Restaurado comportamiento de tecla `Escape` en diálogos (cierra con ESC)
- ✅ Actualizado `README.md` e `INFORME_PROYECTO.md`

## Cambios recientes (11/12/2025)
- ✅ Añadido selector de orden en `DialogoListarTelefonos` con opciones: `Original`, `Precio (Mayor → Menor)`, `Precio (Menor → Mayor)`, `Marca (A → Z)`.
- ✅ Implementada la lógica de ordenación local en el diálogo (no se modificó `DatosGlobales`).


## Autores
- Nayeli Bianca Clemente Morales
- Milagros Eugenia Loza Cavero
- Nicole Paucar Quispe
- Emerson Víctor Aliaga Velán
- Carlos Eduardo Saavedra Alvarado

---
**Última actualización**: 11 de diciembre de 2025

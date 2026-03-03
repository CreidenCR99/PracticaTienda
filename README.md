# PracticaTienda

**PracticaTienda** es una aplicación de prueba por consola para facilitar la gestión de inventario, clientes y pedidos en una tienda virtual.
*Adrián Cuervo Rodríguez, 1 DAW*

---

## Técnicas Usadas

- **Colecciones de Java:** Uso de `ArrayList` y `HashMap` para la gestión de datos en memoria.
- **Programación Funcional (API Stream):**
  - Operaciones de filtrado, mapeo y recolección (`filter`, `map`, `collect`).
  - Ordenación de colecciones con `sorted` y `Comparator`.
  - Agrupación y cálculos agregados (`groupingBy`, `summingInt`, `counting`, `average`).
  - Aplanamiento de colecciones anidadas con `flatMap`.
- **Manejo de Ficheros:**
  - Lectura y escritura de ficheros de texto (`BufferedReader`, `BufferedWriter`).
  - Operaciones con el sistema de archivos (`File`).
  - Exportación de datos a formato CSV.
- **Excepciones Personalizadas:** Creación y uso de excepciones (`StockCero`, `StockInsuficiente`) para un control de errores más específico.
- **Validaciones:** Uso de expresiones regulares para la validación de datos como el DNI.
- **jUnit Tests:** Pruebas unitarias para garantizar el funcionamiento de los métodos.

---

## Características

### Gestión de Datos
- **Artículos:** Alta, baja, reposición de stock y listados por sección.
- **Clientes:** Alta, baja y modificación de datos. Se valida el DNI en el alta.
- **Pedidos:** Creación de nuevos pedidos, con cálculo de total y generación de ID único por cliente y año.

### Control de Stock
- **Comprobación de Stock:** El sistema comprueba la disponibilidad de artículos al realizar un pedido.
  - **`StockCero`:** Impide añadir artículos sin existencias.
  - **`StockInsuficiente`:** Gestiona los casos donde la demanda supera las existencias, permitiendo al usuario comprar el stock restante.

### Consultas e Informes (Streams)
- **Listados Generales:** Visualización de todos los artículos, clientes y pedidos.
- **Consultas sobre Artículos:**
  - Listar artículos por sección.
  - Listar artículos no vendidos.
  - Listar artículos ordenados de distintas formas.
- **Consultas sobre Clientes:**
  - Identificar clientes que no han realizado pedidos.
  - Listar clientes ordenados de distintas formas.
- **Consultas sobre Pedidos:**
  - Calcular el importe medio de todos los pedidos.
  - Calcular la facturación total en un período de tiempo (últimos 5 días).
  - Listar los pedidos de un cliente específico.

### Gestión de Ficheros
- **Información de archivos:** Obtener detalles como nombre, ruta y tamaño.
- **Operaciones básicas:** Borrar y renombrar archivos.
- **Persistencia de datos:**
  - Guardar el listado de clientes en un fichero `clientes.csv`.
  - Escribir y leer texto en ficheros genéricos.

---

## Tests

**MetodosAuxTest.java**
- `testEsInt()`
- `testEsDouble()`
- `testValidarDNI()`

**PracticaTiendaTest.java**
- `testCargaDatos()`
- `testTotalPedido()`
- `testTotalCliente2()`
- `testGeneraIdPedido()`
- `testStock()`

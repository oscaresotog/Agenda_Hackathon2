# 📖 Agenda de Contactos - Hackathon 2 (Java GUI)

## 🚀 Descripción del Proyecto
Aplicación de escritorio desarrollada en Java para la gestión de contactos. Este proyecto evolucionó de un planteamiento inicial en consola a una **Interfaz Gráfica de Usuario (GUI) utilizando Java Swing**, implementando el patrón de arquitectura **MVC (Modelo-Vista-Controlador)** para asegurar un código escalable, limpio y mantenible.

La agenda cuenta con un límite estricto de capacidad (10 contactos) y maneja validaciones de negocio en tiempo real, previniendo duplicados, campos vacíos y garantizando la integridad de los datos.

---

## 👥 Estructura del Equipo y Roles (8 Integrantes)
Dada la migración a una arquitectura con interfaz gráfica, las responsabilidades del equipo se adaptaron para cubrir el desarrollo visual, la lógica de negocio y el aseguramiento de calidad.

| Rol | Integrante(s)    | Responsabilidades Clave |
| :--- |:-----------------| :--- |
| **Líder Técnico & Arquitectura** | Bruno            | Coordinación general, diseño del patrón MVC, implementación del *Event Dispatch Thread* (EDT), integración de la UI (`Agendota`) con la lógica, y resolución de conflictos (Merge). |
| **Desarrollo Core (Modelo)** | Emmanuel         | Construcción de la clase `Contacto`. Implementación crítica del contrato `equals()` y `hashCode()` para validación estricta de duplicidad por Nombre y Apellido. |
| **Desarrollo Core (Lógica)** | Oscar            | Construcción de la clase `Agenda`. Lógica CRUD, control de capacidad máxima (10), validaciones de negocio y ordenamiento alfabético mediante `Comparator`. |
| **Desarrollo Frontend (UI Swing)** | Carlos y Yessica | Diseño de la interfaz gráfica visual. Distribución de componentes (`JTextField`, `JButton`, `JList`), implementación del `JScrollPane` y manejo de la paleta visual. |
| **QA y Testing** | Tonantzin        | Pruebas de borde: validación de campos vacíos, estrés de capacidad (agenda llena), flujos de búsqueda fallida y verificación de comportamiento visual (sombreo en listas). |
| **Documentación & Clean Code** | Janice           | Redacción del `README`, revisión de estándares de código (uso de Lambdas de Java 8+, encapsulamiento) e instrucciones de despliegue. |

---

## ⚙️ Arquitectura y Tecnologías
* **Lenguaje:** Java 8+ (Uso intensivo de expresiones Lambda y Collections API).
* **Interfaz Gráfica:** Java Swing (con adaptación automática al `LookAndFeel` nativo del sistema operativo).
* **Patrón de Diseño:** Modelo-Vista-Controlador (MVC).
  * *Modelo:* `Contacto.java`
  * *Controlador/Lógica:* `Agenda.java`
  * *Vista:* `Agendota.java` y `Agendota.form`

---

## ✅ Características y Funcionalidades (Checklist Cumplido)

### 1. Gestión de Datos (Modelo `Contacto`)
* [x] Atributos encapsulados: `nombre`, `apellido`, `telefono`.
* [x] **Mejora implementada:** El método `equals()` y `hashCode()` evalúan *Nombre + Apellido* ignorando mayúsculas/minúsculas para una prevención de duplicados más precisa y realista.

### 2. Lógica de Negocio (Controlador `Agenda`)
* [x] **Límite de Capacidad:** Restringido a 10 espacios (`CAPACIDAD` constante).
* [x] **Añadir Contacto:** Bloquea campos vacíos, duplicados lógicos y desbordamiento de capacidad.
* [x] **Modificar Teléfono:** Actualización en tiempo real sin alterar la identidad del contacto.
* [x] **Búsqueda Exacta:** Retorna el objeto si coincide el nombre y apellido.
* [x] **Eliminar Contacto:** Remueve el registro exacto tras validación.
* [x] **Listado Dinámico:** Devuelve la lista ordenada alfabéticamente (por nombre y luego apellido) para su visualización.
* [x] **Monitoreo de Estado:** Métodos `agendaLlena()` y `espaciosLibres()`.

### 3. Interfaz Gráfica (Vista `Agendota`)
* [x] **Sincronización en Tiempo Real:** El `JList` (apoyado por un `DefaultListModel`) se actualiza instantáneamente tras cualquier operación CRUD.
* [x] **Búsqueda Visual (UX):** Al buscar un contacto, además de mostrar sus datos, la fila correspondiente en el `JList` se resalta automáticamente y la vista hace *scroll* hacia ella.
* [x] **Feedback al Usuario:** Uso de `JOptionPane` para informar sobre éxitos, errores de validación y estado de la capacidad.
* [x] **Limpieza Automática:** Los campos de texto se vacían y el cursor se auto-enfoca (`requestFocus`) tras cada acción exitosa.

---

## 🛠️ Instrucciones de Ejecución

1. Clonar el repositorio en el entorno local.
2. Abrir el proyecto en **IntelliJ IDEA** (recomendado para interpretar correctamente el archivo `.form` de la GUI).
3. Navegar a `src/main/java/org/Main.java`.
4. Ejecutar el método `main`.
5. *Nota:* La aplicación intentará cargar el tema visual de tu sistema operativo (Windows/Mac/Linux) para una mejor experiencia. De no estar disponible, utilizará el tema por defecto de Java (Metal).
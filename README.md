# Agenda_Hackathon2
Plan de Acción: Agenda de Contactos (Java)

1. Estructura del Equipo y Roles (8 Integrantes)
   Proyecto que requiere principalmente lógica de backend y estructura de datos, dividiremos los roles para asegurar cobertura en desarrollo, pruebas y documentación simultánea.

| Rol                                                      | Cantidad | Responsabilidades Clave |
|:---------------------------------------------------------| :---: | :--- |
| Lider: Bruno                                             | 1 | Coordina el equipo, define la estructura de clases (`Contacto`, `Agenda`), toma decisiones técnicas (¿Array o ArrayList?) y gestiona el merge de código. |
| Desarrollador Core (Modelo): Emmanuel                    | 2 | Implementa la clase `Contacto` (nombre, teléfono, `equals()`, `toString()`) y la lógica de comparación. Es crítico que la igualdad se base solo en el nombre. |
| Desarrollador Core (Lógica): Oscar                       | 3 | Implementa la clase `Agenda`. Se encarga de los métodos: `añadirContacto`, `existeContacto`, `buscaContacto`, `eliminarContacto`, `agendaLlena`, `espacioLibres`. Maneja el tamaño fijo (10) o dinámico. |
| Desarrollador de Interfaz (UI/Consola): Carlos y Yessica | 1 | Crea el menú en la consola, maneja la entrada de datos (`Scanner`), conecta las opciones del menú con los métodos de la agenda y maneja los mensajes de error/éxito. |
| QA y Pruebas (Testing): Janice                           | 1 | Crea casos de prueba para cada método (ej: intentar añadir más de 10 contactos, buscar un nombre inexistente, eliminar un contacto que no existe). |
| Documentador & Integrador: Tonantzin                     | 1 | Redacta el `README`, documenta cómo compilar y ejecutar, asegura que el código tenga comentarios y ayuda a subir el repositorio. |

Aunque somos 8 personas, el volumen de código para una agenda básica es pequeño. El QA y el Documentador debemos ayudar a escribir código o hacer pruebas de estrés (llenar la agenda 100 veces) para no quedarse sin tareas.
2. Estrategia de Desarrollo (Sprints)

Dividiremos el tiempo del hackathon en 4 Sprints cortos. Asumimos un cronograma flexible, pero cada sprint debe tener un objetivo "terminado" antes de pasar al siguiente.

Sprint 1: Cimientos y Estructura (20% del tiempo)
Objetivo: Tener las clases base compuestas y funcionales sin menú.
- Arquitecto: Define el paquete y las clases vacías.
- Desarrolladores Modelo: Crean la clase `Contacto`.
    - Atributos: `nombre` (String), `telefono` (String/long).
    - Método `equals()`: Solo compara nombres.
- Desarrolladores Lógica: Crean la clase `Agenda`.
    - Atributo: Array de `Contacto` o `ArrayList`.
    - Constructor: Tamaño por defecto (10) o personalizado.
    - Método base `agendaLlena()` y `espacioLibres()`.
- QA: Prueba instanciar objetos y verificar que `equals()` funcione correctamente.

Sprint 2: Lógica de Negocio Crítica (30% del tiempo)
Objetivo: Implementar todas las reglas de negocio solicitadas.
- Desarrolladores Lógica: Implementan el núcleo:
    - `añadirContacto(Contacto c)`: Lógica para evitar duplicados y verificar si está llena.
    - `existeContacto(Contacto c)`: Uso del `equals()`.
    - `buscaContacto(String nombre)`: Búsqueda lineal.
    - `eliminarContacto(Contacto c)`: Lógica de desplazamiento de array o remoción.
- QA: Pruebas de borde:
    - Intentar añadir cuando la agenda está llena (debe imprimir mensaje de error).
    - Buscar y eliminar contactos inexistentes.
- Documentador: Empieza a escribir los comentarios en el código (JavaDoc).

Sprint 3: Interfaz de Consola y Flujo (30% del tiempo)
Objetivo: Que el usuario pueda interactuar con el programa.
- Desarrollador UI: Crea el `while` infinito con `switch/case` en la consola.
    - Opciones: 1. Añadir, 2. Listar, 3. Buscar, 4. Eliminar, 5. Salir.
    - Manejo de excepciones de entrada (si el usuario pone letras en vez de números).
- Líder: Asegura que los mensajes de error del backend (ej: "Agenda llena") se muestren claramente en la consola.
- QA: Prueba el flujo completo: Añadir -> Listar -> Buscar -> Eliminar -> Verificar que desapareció.

Sprint 4: Pulido, Pruebas Finales y Entrega (20% del tiempo)
Objetivo: Código limpio, documentation y demo.
- Todo el equipo: Revisión de código en pareja (Pair Programming) para encontrar errores de lógica.
- Documentador: Crea el archivo `README.md` con:
    - Instrucciones de compilación (`javac`, `java`).
    - Descripción de las funcionalidades.
    - Ejemplo de uso.
- QA: Ejecuta una prueba final de "Destrucción": intenta romper el programa con entradas erróneas.
- Líder: Prepara la presentación rápida (2 min) para el jurado.


3. Requisitos Técnicos a Cubrir (Checklist)

Aseguremos de que el código final cumpla estrictamente con esto:

- [ ] Clase `Contacto`:
    - [ ] Constructor con nombre y teléfono.
    - [ ] Sobrescritura de `equals()`: Dos contactos son iguales si solo el nombre coincide.
- [ ] Clase `Agenda`:
    - [ ] Constructor con tamaño default (10) y con tamaño personalizado.
    - [ ] `añadirContacto(Contacto c)`: Verifica duplicados y espacio.
    - [ ] `existeContacto(Contacto c)`: Retorna booleano.
    - [ ] `listarContactos()`: Imprime todos los contactos.
    - [ ] `buscaContacto(String nombre)`: Retorna/Imprime teléfono.
    - [ ] `eliminarContacto(Contacto c)`: Retorna booleano de éxito.
    - [ ] `agendaLlena()`: Retorna booleano.
    - [ ] `espacioLibres()`: Retorna `int`.
- [ ] Menú:
    - [ ] Loop principal en consola.
    - [ ] Opciones claras y manejo de errores de entrada.
      REPASAR:
1.  Comunicación Constante: Usaremos un chat (Zoom). El Líder debe hacer un "stand-up" de 2 minutos cada hora para ver qué bloques están atascados.
2.  Control de Versiones: Con Git, el Líder debe ser quien haga los `merge`. Evitemos que dos personas toquen el mismo archivo al mismo tiempo para no tener conflictos de fusión.
3.  Prioridad: Si se acaba el tiempo, primero aseguremos que la lógica funcione (Sprint 2). El menú (Sprint 3) puede ser básico, pero si la lógica de "Agenda llena" falla, el proyecto no sirve.
4.  Prueba de Fuego: Antes de entregar, un usuario ficticio que no sea el desarrollador del menú debe intentar usar el programa. Si se atasca al escribir, reparar eso en el Sprint 4.



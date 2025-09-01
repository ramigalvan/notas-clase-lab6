### Clase de Laboratorio 6: Desarrollo Mobile con Java en Android
**Fecha:** 28/8/25

---

### 1. Estructura de la Aplicación Android
* **XML y Java:** La programación en Android se basa en una separación clara entre la interfaz de usuario y la lógica.
    * **XML:** Define la **estructura visual** de las pantallas (layouts, botones, campos de texto, etc.). Puedes verlo como una estructura de árbol, donde cada elemento tiene un padre y puede tener hijos.
    * **Java:** Contiene la **lógica de la aplicación**. Se encarga de manejar los eventos del usuario, procesar datos y controlar la navegación.
* **Interacción XML-Java:** Para conectar los elementos de la interfaz (definidos en XML) con el código Java, se utiliza el método `findViewById()`.
    * `findViewById()`: Este método te permite **recuperar un objeto** (una vista como un `Button` o un `EditText`) del archivo XML usando su identificador (`id`). Esto es fundamental para poder interactuar con los elementos de la UI.

---

### 2. El Ciclo de Vida de una Actividad
* **Concepto:** El ciclo de vida de una `Activity` es una serie de métodos que el sistema Android llama automáticamente a medida que una pantalla cambia de estado (se crea, se inicia, se detiene, etc.).
* **Métodos principales:**
    * `onCreate()`: Se llama una sola vez, cuando la actividad se crea. Aquí se infla el layout (`setContentView()`) y se inicializan las vistas.
    * `onStart()`: La actividad se vuelve visible para el usuario.
    * `onResume()`: La actividad pasa al primer plano y el usuario puede interactuar con ella.
    * `onPause()`: La actividad está parcialmente oscurecida por otra actividad. Es el lugar ideal para guardar datos de sesión.
    * `onStop()`: La actividad ya no es visible para el usuario.
    * `onDestroy()`: Se llama antes de que la actividad sea destruida. Aquí se liberan los recursos.
* **`Bundle`:** El `Bundle` en `onCreate(Bundle savedInstanceState)` es un mecanismo para **guardar y restaurar el estado** de una actividad. Sirve para almacenar datos importantes (como el texto de un campo) antes de que la actividad sea destruida, por ejemplo, cuando el usuario gira el teléfono.

---

### 3. Manejo de Eventos del Usuario
* **Concepto:** Los eventos son acciones realizadas por el usuario, como clics en botones o toques en la pantalla. Para reaccionar a estos eventos, se usan **listeners**.
* **Mecanismos:**
    * `onClick` (propiedad en XML): Permite asociar directamente un método en el código Java con el evento de clic de un botón, de forma declarativa en el layout.
    * `on...Listener()`: Son interfaces que se implementan en el código Java para "escuchar" eventos. Por ejemplo:
        * `OnClickListener()`: Se usa para detectar clics.
        * `OnTouchListener()`: Se usa para detectar toques en la pantalla.

---

### 4. Navegación entre Actividades (Intents)
* **Concepto:** Los `Intents` son objetos que se usan para **comunicar componentes** de una aplicación, principalmente para navegar entre actividades.
* **Tipos de Intents:**
    * **Intents Explícitos:** Se utilizan para iniciar una actividad **específica** dentro de tu propia aplicación. Le dices al sistema exactamente qué clase de `Activity` quieres iniciar.
    * **Intents Implícitos:** Se utilizan para solicitar una acción al sistema sin especificar una actividad concreta. El sistema encuentra la `Activity` más adecuada para responder a esa "intención" (ej. "abrir un navegador", "enviar un correo"). Se definen con un parámetro de **ACCIÓN** y, opcionalmente, **DATOS**.
* **Almacenamiento:** Los `Intents` y las `Activity` que pueden responder a ellos se registran en el archivo de configuración de la aplicación, el **`AndroidManifest.xml`**. Esto permite que otras aplicaciones o el propio sistema sepan qué puede hacer tu aplicación.

---

### 5. Conceptos avanzados y Tareas
* **Procesos y Concurrencia:** Es importante entender los conceptos de hilos y concurrencia, ya que en Android las operaciones que tardan mucho tiempo (como una descarga de internet) no deben ejecutarse en el hilo principal para no "congelar" la interfaz de usuario.
* **`Context`:** El `Context` es una interfaz que te da acceso a información global de la aplicación, como recursos, clases, y servicios. Se usa para muchas operaciones, como iniciar una `Activity` o crear vistas. La palabra clave `this` en una `Activity` normalmente se refiere a su propio contexto.
* **Práctica:** La tarea de la clase es **crear una pantalla de registro**.
    * Se deben tomar los datos de los campos (`EditText`).
    * Validar los datos.
    * Redirigir al usuario a una nueva pantalla si los datos son correctos.
    * Mostrar un mensaje de error si la validación falla.
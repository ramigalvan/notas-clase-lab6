
---

### 📝 Notas - Laboratorio VI: Desarrollo Móvil en Android (Clase 1)
18/8/25
Este documento resume los puntos clave de la primera clase, centrada en los fundamentos y la estructura de proyectos de Android.

---

### 1. Ecosistema de Desarrollo y Lenguajes
* **Java vs. Kotlin:** Se discutió el uso de Java y Kotlin para el desarrollo de Android. Aunque Kotlin es el lenguaje preferido por Google, la clase se centrará en Java.
* **Interfaces de Usuario:**
    * **XML:** Método tradicional y principal para construir interfaces de usuario de forma declarativa.
    * **Jetpack Compose:** Framework moderno y recomendado para crear interfaces de usuario de forma programática. Se mencionó la pregunta de si Compose es compatible con Java, que es un punto a investigar.

---

### 2. Estructura y Herramientas del Proyecto
* **Estructura del Proyecto:** Se debe estudiar y comprender la organización de un proyecto Android, incluyendo los directorios principales:
    * `java/`: Contiene el código fuente de la aplicación.
    * `res/layout/`: Archivos XML de la interfaz de usuario.
    * `res/values/`: Recursos como cadenas de texto, colores y dimensiones.
    * `res/drawable/`: Íconos e imágenes.
    * `res/mipmap/`: Íconos de la aplicación.
* **Gestión de Dependencias:** **Gradle** es el sistema de automatización y gestión de dependencias utilizado en Android. Se mencionó la sintaxis **Kotlin DSL** para los archivos de configuración de Gradle y los posibles problemas que pueden surgir.
* **Gestión de APIs y Versiones:** Las versiones de Android (con sus nombres en código, ej. "Nougat", "Oreo") se asocian con un conjunto específico de APIs (Application Programming Interfaces). El proyecto final debe justificar el uso de ciertas dependencias y librerías basándose en la versión de API objetivo.

---

### 3. Conceptos Técnicos Fundamentales
* **APIs del Sistema:** Se discutió la relación entre las librerías de Android y el **sistema operativo (Linux)** y la **máquina virtual (VM)**.
* **Persistencia de Datos:** Se explorará el uso de bases de datos internas como **SQLite**, junto con el manejo de preferencias para almacenar datos simples.
* **Librerías Nativas vs. de Terceros:** La clase abordará la diferencia entre las librerías incluidas en el SDK de Android (nativas) y las de terceros (externas), así como su justificación y uso.
* **Manejo de Pantallas:** Se debe prestar atención a los problemas de **densidad de píxeles**, **márgenes** y **tamaños de elementos** para asegurar que la interfaz se vea bien en diferentes dispositivos.
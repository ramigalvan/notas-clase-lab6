
## 1. Diseño de interfaces en XML

* Los **layouts** en Android se definen con archivos XML.
* Es importante practicar la construcción de diseños primero en **Figma** o herramientas similares para luego replicarlos en XML.
* Elementos clave en el diseño:

  * **Box-model:** márgenes, padding y bordes.
  * **Tipos de layouts:** `LinearLayout`, `RelativeLayout`, `ConstraintLayout`, `FrameLayout`, etc.
  * **Posicionamiento por defecto:** cada layout organiza sus hijos con reglas distintas.
  * **Restricciones y alineación:** en `ConstraintLayout` se definen vínculos entre ejes (`X, Y, -X, -Y`) para alinear componentes.

---

## 2. Sistema de diseño y estilo

* Usar un **sistema de diseño consistente**:

  * Paleta de colores definida en `res/values/colors.xml`.
  * Tipografías en `res/font/`.
  * Estilos y temas en `res/values/styles.xml`.
* **Recursos estáticos:**

  * **Fuentes personalizadas** (se agregan a `res/font/`).
  * **Íconos de Material Design:** disponibles en la [Material Icons Library](https://fonts.google.com/icons).
  * No es necesario un CDN: Android recomienda integrarlos como recursos locales o mediante dependencias (`Material Components for Android`).

---

## 3. Layouts responsivos

* **ConstraintLayout** → recomendado por Google por su flexibilidad en posicionamiento y alineación.
* Uso de **Guidelines, Chains y Barriers** para organizar elementos.
* **Layouts adaptables al dispositivo:**

  * Se pueden crear carpetas como `layout-sw600dp/` para adaptar a tablets.
  * También se usan `ConstraintLayout` con reglas relativas y vistas que se ajustan automáticamente.

---

## 4. Animaciones en Android

* **Keyframe animations con SVG:**

  * Se pueden implementar con **Vector Drawables** (`.xml` en `res/drawable/`).
  * Animaciones con `AnimatedVectorDrawable`.
  * Definición de keyframes para transformaciones (rotar, escalar, mover).
* También existen:

  * **Property Animations** (`ObjectAnimator`, `AnimatorSet`).
  * **MotionLayout** (dentro de `ConstraintLayout`) para animaciones complejas.

---

## 5. Recomendaciones de estudio

🔎 Investiga más a fondo en la [documentación oficial de Android](https://developer.android.com/):

* **ConstraintLayout** (alineación, guías, restricciones).
* **Responsive design en Android**.
* **Uso de Material Components** para botones, inputs, tarjetas, etc.
* **MotionLayout** para animaciones modernas.



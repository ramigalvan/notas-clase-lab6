### Hola Mundo con Botón Interactiva

Esta es una aplicación básica de Android que muestra un mensaje de bienvenida y un botón interactivo.


```java
public void onHelloBtnClicked(View view){
    TextView txtWelcome = findViewById(R.id.txtWelcome);
    txtWelcome.setText("Hello from a button!");
}
```

```xml
<Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="click me"
        android:layout_below="@+id/txtWelcome"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="20dp"
        android:onClick="onHelloBtnClicked"
/>
```

---

#### Características Principales

* **Mensaje de bienvenida:** Un texto estilizado con un color personalizado y una fuente en negrita e itálica.
* **Diseño de Layout:** Usa un **RelativeLayout** para posicionar los elementos en el centro de la pantalla.
* **Interacción del usuario:** Un botón con el texto "click me" que, al ser presionado, cambia el texto del mensaje de bienvenida.
* **Colores personalizados:** Utiliza un archivo de recursos de colores (`colors.xml`) para definir y reutilizar los colores del tema.

#### Componentes de la Aplicación

* **`MainActivity.java`:** La clase principal de la aplicación, que maneja la lógica de la interfaz. Conecta el diseño (`activity_main.xml`) con el código, y define el método `onHelloBtnClicked` para manejar la acción del botón.
* **`activity_main.xml`:** El archivo de layout que define la interfaz de usuario, incluyendo un `TextView` y un `Button`.
* **`colors.xml`:** Archivo de recursos que contiene las definiciones de los colores utilizados en la aplicación.
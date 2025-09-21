package com.example.firstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    /*
    4.  **Lista de ítems simple:**
    * Crea una `Activity` principal con un `ListView` (o `RecyclerView`, si te sientes más avanzado).
    * Usa un `ArrayAdapter` para mostrar una lista de cadenas (`String`), por ejemplo, nombres de frutas.
    * **Esto te enseña a manejar colecciones de datos en una UI.**
    */

    private final static String LOGCAT_TAG = "Logcat debugg";

    private List<String> frutas;
    private ArrayAdapter<String> adapter;
    private EditText frutaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d(LOGCAT_TAG, "Estoy en onCreate");
        frutas = new ArrayList<>();
        //frutas precargadas
        frutas.add("Manzana");
        frutas.add("Pera");
        frutas.add("Banana");

        ListView frutasListView = findViewById(R.id.lista_frutas);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, frutas);
        frutasListView.setAdapter(adapter);

        frutaEditText = findViewById(R.id.edit_text_fruta);
        Button btnAgregarFruta = findViewById(R.id.btn_agregar);

        btnAgregarFruta.setOnClickListener(v -> {
            Log.d("BUTTONS_AGREGAR", "El usuario ha presionado el boton agregar");
            String frutaInput = frutaEditText.getText().toString();

            if(frutaInput.isEmpty()){
                Toast.makeText(MainActivity.this, "Pone una fruta loco", Toast.LENGTH_SHORT).show();
            }else{
                frutas.add(frutaInput);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Fruta agregada!", Toast.LENGTH_SHORT).show();

                Log.d("Fruta", "Loggeando fruta" + frutas.toString());

                frutaEditText.setText("");
            }
        });



    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOGCAT_TAG, "Estoy en un onRestar()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOGCAT_TAG, "Estoy en un onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOGCAT_TAG, "Estoy en un onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOGCAT_TAG, "Estoy en un onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOGCAT_TAG, "Estoy en un onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOGCAT_TAG, "Estoy en un onDestroy()");
    }
}
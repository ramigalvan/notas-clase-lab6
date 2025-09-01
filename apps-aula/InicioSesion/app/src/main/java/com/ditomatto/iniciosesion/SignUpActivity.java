package com.ditomatto.iniciosesion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    String tag = "Playing with UI - Step:";
    TextView fullName;
    TextView email;
    TextView studentId;
    TextView password;
    Button btnLogin;

    // Constante para el nombre de tu archivo de SharedPreferences
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        playingWithUI();
    }

    /**
     * este metodo sirve para debuggear los campos
     * de la UI
     */
    private void playingWithUI() {
        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.email);
        studentId = findViewById(R.id.studentId);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = fullName.getText().toString().trim();
                String emailStr = email.getText().toString().trim();
                String studentIdStr = studentId.getText().toString().trim();
                String passwordStr = password.getText().toString();


                if (name.isEmpty() || emailStr.isEmpty() || studentIdStr.isEmpty() || passwordStr.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                    return; // Detener la ejecución
                }

                // Validación básica de email
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailStr).matches()) {
                    Toast.makeText(SignUpActivity.this, "Por favor, introduce un email válido", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 4. Guardar los datos en SharedPreferences
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();

                editor.putString("fullName", name);
                editor.putString("email", emailStr);
                editor.putString("studentId", studentIdStr);
                editor.putString("password", passwordStr); // En un caso real, no guardarías la contraseña así

                // Aplica los cambios. El editor.apply() es asíncrono y no bloquea el hilo principal.
                editor.apply();

                // 5. Notificar al usuario y mostrar datos en la consola para depurar
                Log.d(tag, "Datos guardados en SharedPreferences");
                Log.d(tag, "Nombre: " + name);
                Log.d(tag, "Email: " + emailStr);
                Log.d(tag, "ID Estudiante: " + studentIdStr);
                Log.d(tag, "Password: " + passwordStr);

                Toast.makeText(SignUpActivity.this, "¡Registro exitoso!", Toast.LENGTH_LONG).show();

                // Opcional: Navegar a otra actividad
                 Intent intent = new Intent(SignUpActivity.this, WelcomeActivity.class);
                 startActivity(intent);

                // Code here executes on main thread after user presses button
            }
        });
    }

}
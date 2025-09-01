package com.ditomatto.iniciosesion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class WelcomeActivity extends AppCompatActivity {
    TextView forgotPassword;
    TextView signUp;

    Button btnLogin;
    EditText emailEditText;
    EditText passwordEditText;

    // Nombre del archivo de SharedPreferences, debe coincidir con el usado en SignUpActivity
    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setupUI();
    }

    public void setupUI(){   // Obtener referencias a los campos de email y contraseña
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                startActivity(new Intent(getBaseContext(), ForgotPasswordActivity.class));
                return false;
            }
        });

        signUp = findViewById(R.id.signUp);
        signUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                startActivity(new Intent(getBaseContext(), SignUpActivity.class));
                return false;
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Leer el email y la contraseña ingresados por el usuario
                String emailInput = emailEditText.getText().toString().trim();
                String passwordInput = passwordEditText.getText().toString();

                // Obtener los datos guardados en SharedPreferences
                SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                String savedEmail = settings.getString("email", ""); // El segundo parámetro es un valor por defecto
                String savedPassword = settings.getString("password", "");

                // Validar los datos ingresados
                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(WelcomeActivity.this, "Por favor, ingresa tu email y contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Comparar los datos con los almacenados
                if (emailInput.equals(savedEmail) && passwordInput.equals(savedPassword)) {
                    // Si los datos coinciden, el inicio de sesión es exitoso
                    Toast.makeText(WelcomeActivity.this, "¡Inicio de sesión exitoso!", Toast.LENGTH_LONG).show();
                    // Aquí puedes navegar a la pantalla principal de la aplicación
                    // 🎁 Pasar los datos a la siguiente actividad
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    intent.putExtra("USER_EMAIL", savedEmail);
                    intent.putExtra("USER_PASSWORD", savedPassword);

                    // Si guardaste el nombre completo, también lo puedes pasar
                    //settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    String savedFullName = settings.getString("fullName", "");
                    intent.putExtra("USER_FULL_NAME", savedFullName);

                    startActivity(intent);
                     finish(); // Opcional: cierra esta actividad para que el usuario no pueda volver
                } else {
                    // Si los datos no coinciden, mostrar un mensaje de error
                    Toast.makeText(WelcomeActivity.this, "Email o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public void onClick(View view){
        //startActivity(new Intent(this, MainActivity.class));
    }
}
package com.upiiz.examen_jatc_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etUsuario = findViewById(R.id.Email);
        EditText etClave = findViewById(R.id.Password);
        Button btnIniciar = findViewById(R.id.IniciarSesion);
        Button btnCrear = findViewById(R.id.CrearCuenta);

        // Validar usuario admin y clave 123456 -> listado
        btnIniciar.setOnClickListener(v -> {
            String usuario = etUsuario.getText().toString().trim();
            String clave = etClave.getText().toString();

            if (usuario.equals("admin") && clave.equals("123456")) {
                startActivity(new Intent(MainActivity.this, ListaChats.class));
                finish();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }
        });

        // Crear una cuenta -> registro
        btnCrear.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, Registro.class)));
    }
}
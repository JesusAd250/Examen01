package com.upiiz.examen_jatc_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ImageView ivAtras = findViewById(R.id.ivAtras);
        EditText etNombre = findViewById(R.id.etNombre);
        EditText etClave = findViewById(R.id.etClave);
        EditText etConfirmar = findViewById(R.id.etConfirmar);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        TextView tvYaTienes = findViewById(R.id.tvYaTienes);

        ivAtras.setOnClickListener(v -> irAlLogin());

        btnRegistrar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String clave = etClave.getText().toString();
            String confirmar = etConfirmar.getText().toString();

            if (nombre.length() < 3) {
                etNombre.setError("El nombre debe tener mínimo 3 caracteres");
                etNombre.requestFocus();
                return;
            }

            if (clave.isEmpty() || !clave.equals(confirmar)) {
                etConfirmar.setError("Las contraseñas no coinciden");
                etConfirmar.requestFocus();
                return;
            }

            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            irAlLogin();
        });

        tvYaTienes.setOnClickListener(v -> irAlLogin());
    }

    private void irAlLogin() {
        Intent intent = new Intent(Registro.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
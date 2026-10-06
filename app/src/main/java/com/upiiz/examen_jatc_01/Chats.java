package com.upiiz.examen_jatc_01;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.upiiz.examen_jatc_01.model.MensajeAdapter;
import com.upiiz.examen_jatc_01.model.MensajeJava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Chats extends AppCompatActivity {

    private final List<MensajeJava> mensajes = new ArrayList<>();
    private MensajeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        ListView lvMensajes = findViewById(R.id.lvMensajes);
        EditText etMensaje = findViewById(R.id.etMensaje);
        ImageButton btnEnviar = findViewById(R.id.btnEnviar);
        ImageView ivAtras = findViewById(R.id.ivAtras);
        TextView tvNombre = findViewById(R.id.tvNombreChat);
        TextView tvInicial = findViewById(R.id.tvInicialChat);

        // Datos que vienen del listado
        String nombre = getIntent().getStringExtra("nombre");
        if (nombre != null && !nombre.isEmpty()) {
            tvNombre.setText(nombre);
            tvInicial.setText(nombre.substring(0, 1).toUpperCase());
        }

        cargarConversacion();

        adapter = new MensajeAdapter(this, mensajes);
        lvMensajes.setAdapter(adapter);

        ivAtras.setOnClickListener(v -> finish());

        btnEnviar.setOnClickListener(v -> {
            String texto = etMensaje.getText().toString().trim();
            if (texto.isEmpty()) return;

            String hora = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            mensajes.add(new MensajeJava(texto, hora, true));
            adapter.notifyDataSetChanged();
            lvMensajes.setSelection(mensajes.size() - 1);
            etMensaje.setText("");
        });
    }

    // 20 mensajes simulando la conversación (alternando izquierda/derecha)
    private void cargarConversacion() {
        String[][] datos = {
                {"0", "Hola Ana, ¿cómo estás?", "09:32"},
                {"1", "¡Hola! Muy bien, ¿y tú?", "09:33"},
                {"0", "Todo bien, ¿quieres vernos más tarde?", "09:34"},
                {"1", "Sí, me parece bien. ¿A qué hora?", "09:35"},
                {"0", "¿Te parece a las 5?", "09:36"},
                {"1", "Perfecto, nos vemos entonces", "09:36"},
                {"0", "¿Dónde nos vemos?", "09:37"},
                {"1", "En la cafetería de siempre", "09:37"},
                {"0", "Genial, llevo mis apuntes", "09:38"},
                {"1", "Yo llevo los míos también", "09:38"},
                {"0", "¿Ya hiciste la práctica de Android?", "09:40"},
                {"1", "Casi, me falta el chat", "09:41"},
                {"0", "A mí me falta el registro", "09:41"},
                {"1", "Nos ayudamos entonces", "09:42"},
                {"0", "Claro, así terminamos más rápido", "09:43"},
                {"1", "¿Llevas tu laptop?", "09:43"},
                {"0", "Sí, y el cargador", "09:44"},
                {"1", "Muy bien, entonces a las 5", "09:45"},
                {"0", "Nos vemos allá", "09:45"},
                {"1", "¡Hasta luego!", "09:46"}
        };

        for (String[] d : datos) {
            // "0" = enviado (derecha), "1" = recibido (izquierda)
            mensajes.add(new MensajeJava(d[1], d[2], d[0].equals("0")));
        }
    }
}
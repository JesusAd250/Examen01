package com.upiiz.examen_jatc_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.upiiz.examen_jatc_01.model.Usuario;
import com.upiiz.examen_jatc_01.model.UsuarioAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaChats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chats);

        ListView lvUsuarios = findViewById(R.id.lvUsuarios);

        // 20 usuarios
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Ana García", "ana123"));
        usuarios.add(new Usuario("Luis Martínez", "luism"));
        usuarios.add(new Usuario("Marta López", "marta_22"));
        usuarios.add(new Usuario("Pedro Sánchez", "pedro99"));
        usuarios.add(new Usuario("Sofía Torres", "sofia_t"));
        usuarios.add(new Usuario("Juan Rodríguez", "juanr"));
        usuarios.add(new Usuario("Carla Mendoza", "carlam"));
        usuarios.add(new Usuario("Diego Ramírez", "diego_r"));
        usuarios.add(new Usuario("Valeria Cruz", "vale_cruz"));
        usuarios.add(new Usuario("Andrés Flores", "andresf"));
        usuarios.add(new Usuario("Camila Ortiz", "camio"));
        usuarios.add(new Usuario("Jorge Herrera", "jorgeh"));
        usuarios.add(new Usuario("Lucía Navarro", "lucia_n"));
        usuarios.add(new Usuario("Miguel Castillo", "miguelc"));
        usuarios.add(new Usuario("Paula Reyes", "paula_r"));
        usuarios.add(new Usuario("Ricardo Vega", "ricky_v"));
        usuarios.add(new Usuario("Daniela Silva", "dani_s"));
        usuarios.add(new Usuario("Fernando Ríos", "fer_rios"));
        usuarios.add(new Usuario("Gabriela Soto", "gabys"));
        usuarios.add(new Usuario("Héctor Luna", "hector_l"));

        lvUsuarios.setAdapter(new UsuarioAdapter(this, usuarios));

        // Click / touch sobre un usuario -> chat
        lvUsuarios.setOnItemClickListener((parent, view, position, id) -> {
            Usuario seleccionado = usuarios.get(position);
            Intent intent = new Intent(ListaChats.this, Chats.class);
            intent.putExtra("nombre", seleccionado.getNombre());
            intent.putExtra("usuario", seleccionado.getUsuario());
            startActivity(intent);
        });
    }
}
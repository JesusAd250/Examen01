package com.upiiz.examen_jatc_01.model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.upiiz.examen_jatc_01.R;
import com.upiiz.examen_jatc_01.model.Usuario;

import java.util.List;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    private static final int[] COLORES = {
            Color.parseColor("#1E6FE0"), Color.parseColor("#8E24AA"),
            Color.parseColor("#2E9E4F"), Color.parseColor("#F57C00"),
            Color.parseColor("#D81B60"), Color.parseColor("#00897B")
    };

    public UsuarioAdapter(@NonNull Context context, @NonNull List<Usuario> usuarios) {
        super(context, 0, usuarios);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_usuario, parent, false);
        }

        Usuario u = getItem(position);

        TextView tvInicial = convertView.findViewById(R.id.tvInicial);
        TextView tvNombre = convertView.findViewById(R.id.tvNombre);
        TextView tvUsuario = convertView.findViewById(R.id.tvUsuario);

        tvNombre.setText(u.getNombre());
        tvUsuario.setText(u.getUsuario());
        tvInicial.setText(u.getNombre().substring(0, 1).toUpperCase());

        // Color distinto por usuario
        GradientDrawable circulo = (GradientDrawable) tvInicial.getBackground().mutate();
        circulo.setColor(COLORES[position % COLORES.length]);

        return convertView;
    }
}
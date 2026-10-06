package com.upiiz.examen_jatc_01.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.upiiz.examen_jatc_01.R;

import java.util.List;

public class MensajeAdapter extends ArrayAdapter<MensajeJava> {

    public MensajeAdapter(@NonNull Context context, @NonNull List<MensajeJava> mensajes) {
        super(context, 0, mensajes);
    }

    @Override
    public int getViewTypeCount() { return 2; }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).isEnviado() ? 1 : 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MensajeJava m = getItem(position);   // <- antes decía MensajeAdapter (ahí estaba el error)

        if (convertView == null) {
            int layout = m.isEnviado()
                    ? R.layout.mensaje_enviado
                    : R.layout.mensaje_recibido;
            convertView = LayoutInflater.from(getContext()).inflate(layout, parent, false);
        }

        TextView tvTexto = convertView.findViewById(R.id.tvTexto);
        TextView tvHora = convertView.findViewById(R.id.tvHora);

        tvTexto.setText(m.getTexto());
        tvHora.setText(m.getHora());

        return convertView;
    }
}
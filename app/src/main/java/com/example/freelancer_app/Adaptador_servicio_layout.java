package com.example.freelancer_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador_servicio_layout extends RecyclerView.Adapter<Adaptador_servicio_layout.vista>{

    Servicio[] datos;

    public Servicio[] getDatos() {
        return datos;
    }

    public void setDatos(Servicio[] datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public vista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servicio_layout, null, false);
        return new vista(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vista holder, int position) {
        holder.definirDatos(position);

    }

    @Override
    public int getItemCount() {
        return datos.length;
    }

    public class vista extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView descripcion;

        public vista(@NonNull View itemView) {
            super(itemView);
            titulo =(TextView) itemView.findViewById(R.id.titulo);
            descripcion =(TextView) itemView.findViewById(R.id.descripcion);
        }

        public void definirDatos(int s) {
            titulo.setText(datos[s].titulo);
            descripcion.setText(datos[s].descripcion);

        }
    }

    public Adaptador_servicio_layout(Servicio[] datos) {
        this.datos = datos;
    }
}

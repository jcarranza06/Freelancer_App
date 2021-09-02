package com.example.freelancer_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Adaptador_servicio_layout extends RecyclerView.Adapter<Adaptador_servicio_layout.vista>{

    ArrayList<Servicio> datos;
    ArrayList<Servicio> datosBase;

    public ArrayList<Servicio> getDatos() {
        return datos;
    }

    public void setDatos(Servicio[] datos) {
        this.datos = new ArrayList<>(Arrays.asList(datos));
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
        return datos.size();
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
            titulo.setText(datos.get(s).titulo);
            descripcion.setText(datos.get(s).descripcion);

        }
    }

    public Adaptador_servicio_layout(Servicio[] datos) {
        this.datos = new ArrayList<>(Arrays.asList(datos));
        this.datosBase =new ArrayList<Servicio>();
        this.datosBase.addAll(Arrays.asList(datos));
    }
    public void buscar(String busqueda){
        if (busqueda.length()==0 || busqueda.equals("")){
            datos.clear();
            datos.addAll(datosBase);
        }else{
            datos.clear();
            for (int i =0; i<datosBase.size();i++){
                if (datosBase.get(i).descripcion.toLowerCase().contains(busqueda.toLowerCase()) || datosBase.get(i).titulo.toLowerCase().contains(busqueda.toLowerCase())){
                    datos.add(datosBase.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }
}

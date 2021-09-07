package com.example.freelancer_app.layouts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancer_app.R;
import com.example.freelancer_app.data.Servicio;

import java.util.ArrayList;
import java.util.Arrays;

public class Adaptador_servicio_layout extends RecyclerView.Adapter<Adaptador_servicio_layout.vista> implements View.OnClickListener{

    ArrayList<Servicio> datos;
    ArrayList<Servicio> datosBase;
    View.OnClickListener listener;

    public Servicio getDatos(int i){
        return datos.get(i);
    }

    public ArrayList<Servicio> getDatos() {
        return datos;
    }

    public void setDatos(Servicio[] datos) {
        this.datos = new ArrayList<>(Arrays.asList(datos));
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;

    }

    @NonNull
    @Override
    public vista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.servicio_layout, null, false);
        view.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class vista extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView descripcion;
        TextView precio;
        Servicio servicio;

        public Servicio getServicio(){
            return this.servicio;
        }
        public vista(@NonNull View itemView) {
            super(itemView);
            titulo =(TextView) itemView.findViewById(R.id.titulo);
            descripcion =(TextView) itemView.findViewById(R.id.descripcion);
            precio=(TextView) itemView.findViewById(R.id.precio);
        }

        public void definirDatos(int s) {
            titulo.setText(datos.get(s).getTitulo());
            descripcion.setText(datos.get(s).getDescripcionServicio());
            precio.setText("$"+datos.get(s).getPrecio());
            servicio=datos.get(s);

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
                if (datosBase.get(i).getDescripcionServicio().toLowerCase().contains(busqueda.toLowerCase()) || datosBase.get(i).getTitulo().toLowerCase().contains(busqueda.toLowerCase())){
                    datos.add(datosBase.get(i));
                }
            }
        }
        notifyDataSetChanged();
    }
}

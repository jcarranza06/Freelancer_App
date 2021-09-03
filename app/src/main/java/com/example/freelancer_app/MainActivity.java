package com.example.freelancer_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView buscador;
    RecyclerView recycler;
    Adaptador_servicio_layout adaptador;
    Servicio[] servicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setBuscador();
        setRecycler();

        FloatingActionButton btnAgregar =findViewById(R.id.btnNuevo);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCrearActivity();
            }
        });
    }

    public void abrirCrearActivity(){
        Intent abrirCrear = new Intent(MainActivity.this, CrearServicio.class);
        startActivity(abrirCrear);
    }

    public void setBuscador() {
        buscador=(SearchView) findViewById(R.id.buscador);
        buscador.setOnQueryTextListener(this);
        servicios=DataBase.getServicios();
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adaptador.buscar(s);
        return false;
    }
    public void setRecycler(){
        recycler=(RecyclerView) findViewById(R.id.panelShowServicios);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        adaptador=new Adaptador_servicio_layout(servicios);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirActivityServicioEspecifico(adaptador.getDatos(recycler.getChildAdapterPosition(view)));
                System.out.println(adaptador.getDatos(recycler.getChildAdapterPosition(view)));
            }
        });
        recycler.setAdapter(adaptador);
    }

    public void abrirActivityServicioEspecifico(Servicio servicio){
        Intent abrirEspecifico = new Intent(MainActivity.this, MostrarServicio.class);
        Bundle parametros =new Bundle();
        parametros.putInt("idPropietario", servicio.idPropietario);
        parametros.putInt("id", servicio.id);
        parametros.putInt("calificacion", servicio.calificacion);
        parametros.putString("descripcion", servicio.descripcion);
        parametros.putInt("plazo", servicio.plazo);
        parametros.putInt("precio", servicio.precio);
        parametros.putString("titulo",servicio.titulo);

        abrirEspecifico.putExtras(parametros);
        startActivity(abrirEspecifico);
    }
}
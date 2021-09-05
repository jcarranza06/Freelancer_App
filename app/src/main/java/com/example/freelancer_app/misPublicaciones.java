package com.example.freelancer_app;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class misPublicaciones extends AppCompatActivity {
    RecyclerView recycler;
    Adaptador_servicio_layout adaptador;
    Servicio[] servicios;
    TextView nombre;
    TextView correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_publicaciones);
        nombre=(TextView)findViewById(R.id.labelUsuarionombre);
        correo=(TextView)findViewById(R.id.labelUsuariocorreo);
        nombre.setText(Sesion.getUsuario().nombre);
        correo.setText(Sesion.getUsuario().correo);

        servicios = DataBase.getServicioByUserId(Sesion.getUsuario().id);

        recycler = (RecyclerView) findViewById(R.id.panelShowPublicaciones);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        adaptador=new Adaptador_servicio_layout(servicios);

        recycler.setAdapter(adaptador);

    }
}
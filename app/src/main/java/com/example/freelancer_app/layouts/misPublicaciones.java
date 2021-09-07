package com.example.freelancer_app.layouts;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancer_app.R;
import com.example.freelancer_app.data.DataBase;
import com.example.freelancer_app.data.Servicio;
import com.example.freelancer_app.data.Sesion;

public class misPublicaciones extends AppCompatActivity {
    RecyclerView recycler;
    Adaptador_servicio_layout adaptador;
    Servicio[] servicios;
    TextView lblNombre;
    TextView lblCorreo;
    TextView lblPais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_publicaciones);
        lblNombre=(TextView)findViewById(R.id.labelUsuarionombre);
        lblCorreo=(TextView)findViewById(R.id.labelUsuariocorreo);
        lblPais=(TextView)findViewById(R.id.labelUsuariopais);
        lblNombre.setText(Sesion.getUsuario().getNombre());
        lblCorreo.setText("Correo: "+Sesion.getUsuario().getCorreo());
        lblPais.setText("Pais: "+Sesion.getUsuario().getPais());

        servicios = DataBase.getServicioByUserId(Sesion.getUsuario().getId());

        recycler = (RecyclerView) findViewById(R.id.panelShowPublicaciones);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        adaptador=new Adaptador_servicio_layout(servicios);

        recycler.setAdapter(adaptador);

    }
}
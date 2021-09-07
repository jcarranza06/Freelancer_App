package com.example.freelancer_app.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancer_app.R;
import com.example.freelancer_app.data.DataBase;
import com.example.freelancer_app.data.Servicio;
import com.example.freelancer_app.data.Sesion;
import com.example.freelancer_app.data.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    SearchView buscador;
    RecyclerView recycler;
    Adaptador_servicio_layout adaptador;
    Servicio[] servicios;
    Usuario[] usuarios;
    Sesion sesion;
    TextView textoBienvenida;
    Button btnMisPublicaciones;
    Button btnSalir;

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
        definirSesion();
        servicios= DataBase.getServicios();
        usuarios=DataBase.getUsuarios();
        instanciarBotones();

        setBuscador();
        setRecycler();
        textoBienvenida= (TextView)findViewById(R.id.textoBienvenida);
        FloatingActionButton btnAgregar =findViewById(R.id.btnNuevo);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCrearActivity();
            }
        });

        try{
            textoBienvenida.setText("bienvenido: "+Sesion.getUsuario().getNombre());
        }catch (Exception e){

        }
    }

    public void instanciarBotones(){
        btnMisPublicaciones=(Button) findViewById(R.id.btnVerPublicaciones);
        btnMisPublicaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irServUser = new Intent(MainActivity.this, misPublicaciones.class);
                startActivity(irServUser);
            }
        });
        btnSalir=(Button) findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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

    }
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("de vuelta //////////////////////");
        try{
            textoBienvenida.setText("bienvenido: "+Sesion.getUsuario().getNombre());
            servicios=DataBase.getServicios();
            usuarios=DataBase.getUsuarios();
            adaptador=new Adaptador_servicio_layout(servicios);
            adaptador.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    abrirActivityServicioEspecifico(adaptador.getDatos(recycler.getChildAdapterPosition(view)));
                    System.out.println(adaptador.getDatos(recycler.getChildAdapterPosition(view)));
                }
            });
            recycler.setAdapter(adaptador);
        }catch (Exception e){

        }
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
    public void definirSesion(){
            System.out.println("abriendo login");
            Intent abrirLogin = new Intent(MainActivity.this, LoginCuenta.class);
            startActivity(abrirLogin);

    }
    public void abrirActivityServicioEspecifico(Servicio servicio){
        Intent abrirEspecifico = new Intent(MainActivity.this, MostrarServicio.class);
        Bundle parametros =new Bundle();
        parametros.putInt("idPropietario", servicio.getIdPropietario());
        parametros.putInt("id", servicio.getIdServicio());
        parametros.putFloat("calificacion", servicio.getCalificacion());
        parametros.putString("descripcion", servicio.getDescripcionServicio());
        parametros.putInt("plazo", servicio.getPlazo());
        parametros.putInt("precio", servicio.getPrecio());
        parametros.putString("titulo",servicio.getTitulo());

        abrirEspecifico.putExtras(parametros);
        startActivity(abrirEspecifico);
    }
    public Sesion getSesion(){
        return this.sesion;
    }

}
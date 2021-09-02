package com.example.freelancer_app;

import android.os.Bundle;
import android.os.StrictMode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> datos;
    RecyclerView recycler;

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
        recycler=(RecyclerView) findViewById(R.id.panelShowServicios);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        Servicio[] servicios=DataBase.getServicios();
        /*for (int i=0;i<4;i++) {
            DataBase.addServicio(2, 3, "vendo zapatos azules", 8, 45000, "venta de zapatos");
            DataBase.addServicio(3, 5, "arquitecta en bogota", 45, 3000000, "arquitecta");
            DataBase.addServicio(4, 1, "programados", 8, 45000, "programados");
            DataBase.addServicio(5, 2, "asdsadasdasdasdasdas", 8, 45000, "freelancer");
            DataBase.addServicio(6, 8, "echa pañete", 8, 45000, "ruso");
            DataBase.addServicio(7, 7, "sadasdasdsadas", 8, 45000, "vendedor");
            DataBase.addServicio(9, 9, "vendoasd zapaasdtos azulasdes", 8, 45000, "fincaraiz");
            DataBase.addServicio(1, 4, "asdasdasdsa", 8, 45000, "droguista");
            DataBase.addServicio(2, 1, "vendo zapatos azules", 8, 45000, "venta de zapatos");
        }*/
        datos = new ArrayList<String>();
        for (int i =0;i<106;i++){
            datos.add("hola "+i);
        }
        Adaptador_servicio_layout adaptador=new Adaptador_servicio_layout(servicios);
        recycler.setAdapter(adaptador);
    }
}
package com.example.freelancer_app.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancer_app.R;
import com.example.freelancer_app.data.Calificacion;
import com.example.freelancer_app.data.DataBase;
import com.example.freelancer_app.data.Servicio;

public class calificar extends AppCompatActivity {

    EditText calificacion;
    Button btnCalificar;
    Bundle parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);
        calificacion=(EditText) findViewById(R.id.editTextCalificacion);
        btnCalificar=(Button) findViewById(R.id.buttonCAlificar);
        parametros= this.getIntent().getExtras();
        btnCalificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calificar();
            }
        });
    }
    public void calificar(){
        try {
            int calificacio =  Integer.valueOf(calificacion.getText().toString());
            if (calificacio>=0 && calificacio <=5) {
                Servicio servicio = DataBase.getServicioById(parametros.getInt("id"));
                Calificacion c1 = new Calificacion(servicio.getCalificacion(0));
                c1.add(calificacio);
                DataBase.modificarServicio(parametros.getInt("id"), servicio.getIdPropietario(), c1.getCalificacionCode(), servicio.getDescripcionServicio(), servicio.getPlazo(), servicio.getPrecio(), servicio.getTitulo());
                finish();
            }else{
                Toast notificacionServicio = Toast.makeText(getApplicationContext(),
                        "Incorrecto", Toast.LENGTH_SHORT);
                notificacionServicio.show();            }
        }catch (Exception e){
            Toast notificacionServicio = Toast.makeText(getApplicationContext(),
                    "Incorrecto", Toast.LENGTH_SHORT);
            notificacionServicio.show();
        }
    }
}
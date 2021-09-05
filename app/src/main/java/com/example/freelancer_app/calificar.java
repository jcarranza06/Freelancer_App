package com.example.freelancer_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
            Servicio servicio=DataBase.getServicioById(parametros.getInt("id"));
            DataBase.modificarServicio(parametros.getInt("id"), servicio.idPropietario, Integer.valueOf(calificacion.getText().toString()),servicio.descripcion, servicio.plazo,servicio.precio,servicio.titulo);
            finish();
        }catch (Exception e){
            Toast notificacionServicio = Toast.makeText(getApplicationContext(),
                    "Incorrecto", Toast.LENGTH_SHORT);
            notificacionServicio.show();
        }
    }
}
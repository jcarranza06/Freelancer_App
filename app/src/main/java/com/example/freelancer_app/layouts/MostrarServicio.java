package com.example.freelancer_app.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancer_app.R;
import com.example.freelancer_app.data.DataBase;

public class MostrarServicio extends AppCompatActivity {

    TextView tituloMostrar;
    RatingBar ratingBar;
    TextView textView3;
    TextView plazoMostrar;
    TextView precioMostrar;
    TextView autorMostrar;
    TextView emailMostrar;
    Button calificar;
    Button btnAtrasMostrar;
    Bundle parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        parametros= this.getIntent().getExtras();

        textView3 = findViewById(R.id.textView3);
        textView3.setMovementMethod(new ScrollingMovementMethod());

        tituloMostrar=(TextView)findViewById(R.id.tituloMostrar);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        textView3 = (TextView)findViewById(R.id.textView3);
        plazoMostrar=(TextView)findViewById(R.id.plazoMostrar);
        precioMostrar=(TextView)findViewById(R.id.precioMostrar);
        autorMostrar=(TextView)findViewById(R.id.autorMostrar);
        emailMostrar=(TextView)findViewById(R.id.emailMostrar);
        calificar = (Button)findViewById(R.id.btnCalificar);
        btnAtrasMostrar = (Button)findViewById(R.id.btnAtrasMostrar);

        instanciarbtnAtrasMostrar();
        instanciarbtnCalificar();

        if(parametros!=null){
            tituloMostrar.setText(parametros.getString("titulo"));
            ratingBar.setRating(parametros.getFloat("calificacion"));
            textView3.setText("Descripcion: "+parametros.getString("descripcion"));
            plazoMostrar.setText("Plazo: "+Integer.toString(parametros.getInt("plazo")) +" dias");
            precioMostrar.setText("Precio: $"+Integer.toString(parametros.getInt("precio")));
            autorMostrar.setText("Propietario: "+ DataBase.getUsuarioById(parametros.getInt("idPropietario")).getNombre());
            emailMostrar.setText("Correo: "+ DataBase.getUsuarioById(parametros.getInt("idPropietario")).getCorreo());

        }


    }
    public void instanciarbtnCalificar(){
        calificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irCalificar=new Intent(MostrarServicio.this, com.example.freelancer_app.layouts.calificar.class);
                Bundle parametros1 =new Bundle();
                parametros1.putInt("id",parametros.getInt("id"));
                irCalificar.putExtras(parametros1);
                startActivity(irCalificar);
            }
        });
    }

    public void instanciarbtnAtrasMostrar(){
        btnAtrasMostrar=(Button) findViewById(R.id.btnAtrasMostrar);
        btnAtrasMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
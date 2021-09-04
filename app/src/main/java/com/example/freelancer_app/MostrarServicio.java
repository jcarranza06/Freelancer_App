package com.example.freelancer_app;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        Bundle parametros= this.getIntent().getExtras();

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

        if(parametros!=null){
            tituloMostrar.setText(parametros.getString("titulo"));
            ratingBar.setRating(parametros.getInt("calificacion"));
            textView3.setText(parametros.getString("descripcion"));
            plazoMostrar.setText(parametros.getString("plazo"));
            precioMostrar.setText(parametros.getString("precio"));
            autorMostrar.setText(parametros.getString("autor"));
            emailMostrar.setText(parametros.getString("email"));

        }

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
package com.example.freelancer_app;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MostrarServicio extends AppCompatActivity {

    TextView textView3;
    TextView tituloMostrar;
    Button btnAtrasMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        Bundle parametros= this.getIntent().getExtras();

        textView3 = findViewById(R.id.textView3);
        tituloMostrar=(TextView)findViewById(R.id.tituloMostrar);
        instanciarbtnAtrasMostrar();

        if(parametros!=null){
            tituloMostrar.setText(parametros.getString("titulo"));
        }

        textView3.setMovementMethod(new ScrollingMovementMethod());
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
package com.example.freelancer_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class CrearServicio extends AppCompatActivity {

    EditText titulo;
    TextInputEditText descripcion;
    EditText plazo;
    EditText precio;
    Button crear;
    Button cancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        Bundle parametros = this.getIntent().getExtras();

        titulo = (EditText) findViewById(R.id.editTitulo);
        descripcion = (TextInputEditText) findViewById(R.id.editDescripcion);
        plazo = (EditText) findViewById(R.id.editPlazo);
        precio = (EditText) findViewById(R.id.editPrecio);
        crear = (Button) findViewById(R.id.btnCrear);
        cancelar = (Button) findViewById(R.id.btnCancelar);

        instacnciarBtnCancelar();

        crear.setEnabled(true);


        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_int = Sesion.getUsuario().id;
                int calificacion_int = 0;
                String titulo_string = titulo.getText().toString();
                String descripcion_string = descripcion.getText().toString();
                int plazo_string = Integer.valueOf(plazo.getText().toString());
                int precio_string = Integer.valueOf(precio.getText().toString());

                if ((!titulo_string.equalsIgnoreCase(""))&&(!descripcion_string.equalsIgnoreCase(""))&&(!plazo.getText().toString().equalsIgnoreCase(""))&&(!precio.getText().toString().equalsIgnoreCase(""))&&(!descripcion_string.equalsIgnoreCase(""))){
                    System.out.println(DataBase.addServicio(id_int, calificacion_int, descripcion_string, plazo_string, precio_string, titulo_string));
                    finish();
                }else{
                }
            }
        });



    }


    public void instacnciarBtnCancelar(){
        Button btnCancelar= (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
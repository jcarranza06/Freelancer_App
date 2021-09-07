package com.example.freelancer_app.layouts;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancer_app.R;
import com.example.freelancer_app.data.DataBase;
import com.example.freelancer_app.data.Sesion;
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
                int id_int = Sesion.getUsuario().getId();
                int calificacion_int = 0;
                String titulo_string = "";
                String descripcion_string = "";
                int plazo_string = -1;
                int precio_string = -1;
                try {
                    id_int = Sesion.getUsuario().getId();
                    calificacion_int = 389891;
                    titulo_string = titulo.getText().toString();
                    descripcion_string = descripcion.getText().toString();
                    plazo_string = Integer.valueOf(plazo.getText().toString());
                    precio_string = Integer.valueOf(precio.getText().toString());
                }
                catch (Exception e){
                    Toast notificacionServicio = Toast.makeText(getApplicationContext(),
                            "Llene todos los espacios", Toast.LENGTH_SHORT);
                    notificacionServicio.show();
                }


                if ((!titulo_string.equalsIgnoreCase(""))&&(!descripcion_string.equalsIgnoreCase(""))&&(!plazo.getText().toString().equalsIgnoreCase(""))&&(!precio.getText().toString().equalsIgnoreCase(""))&&(!descripcion_string.equalsIgnoreCase(""))&&(plazo_string>0)&&(precio_string>0)){
                    System.out.println(DataBase.addServicio(id_int, calificacion_int, descripcion_string, plazo_string, precio_string, titulo_string));
                    Toast notificacionServicio = Toast.makeText(getApplicationContext(),
                                    "Servicio creado", Toast.LENGTH_SHORT);
                    notificacionServicio.show();
                    finish();
                }else{
                    Toast notificacionServicio = Toast.makeText(getApplicationContext(),
                            "Llene todos los espacios", Toast.LENGTH_SHORT);
                    notificacionServicio.show();
                    //System.out.println("fallido");
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
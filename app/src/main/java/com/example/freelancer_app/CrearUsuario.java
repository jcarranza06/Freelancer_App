package com.example.freelancer_app;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CrearUsuario extends AppCompatActivity {
    EditText nombre;
    EditText correo;
    EditText clave;
    EditText pais;
    EditText descripcion;
    Button continuar;
    RadioButton terminosCondiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_usuario);

        nombre = (EditText) findViewById(R.id.txt_nombre_crearu);
        correo = (EditText) findViewById(R.id.txt_correo_crearu);
        clave = (EditText) findViewById(R.id.txt_clave_crearu);
        pais = (EditText) findViewById(R.id.txt_pais_crearu);
        descripcion = (EditText) findViewById(R.id.txt_descripcion_crearu);
        terminosCondiciones = (RadioButton) findViewById(R.id.radioButton);
        continuar = (Button) findViewById(R.id.crear_usuario_button);

        continuar.setEnabled(false);

        terminosCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(terminosCondiciones.isChecked()==true){
                    continuar.setEnabled(true); }
                else{
                    continuar.setEnabled(false);
                }

            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre_string = nombre.getText().toString();
                String correo_string = correo.getText().toString();
                String clave_string = clave.getText().toString();
                String pais_string = pais.getText().toString();
                String descripcion_string = descripcion.getText().toString();
                if ((!nombre_string.equalsIgnoreCase(""))&&(!correo_string.equalsIgnoreCase(""))&&(!clave_string.equalsIgnoreCase(""))&&(!pais_string.equalsIgnoreCase(""))&&(!descripcion_string.equalsIgnoreCase(""))&&terminosCondiciones.isChecked()){
                    System.out.println(DataBase.addUsuario(nombre_string, clave_string, correo_string, pais_string, descripcion_string));
                    Usuario usuario = DataBase.getUsuarioByEmail(correo_string);
                    Sesion.setSesion(true);
                    Sesion.setUsuario(usuario);
                    finish();

                }else{
                    //Toast.makeText(null,"Complete todos los campos",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }



}

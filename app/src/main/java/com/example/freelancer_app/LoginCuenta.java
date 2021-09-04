package com.example.freelancer_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class LoginCuenta extends AppCompatActivity {
    EditText correo;
    EditText clave;
    Button login;
    Button crearCuenta;
    Usuario usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_cuenta);

        correo = (EditText) findViewById(R.id.txt_usuariologin);
        clave = (EditText) findViewById(R.id.txt_clavelogin);
        login = (Button) findViewById(R.id.login_button);
        crearCuenta = (Button) findViewById(R.id.crear_cuenta_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = DataBase.getUsuarioByEmail(correo.getText().toString());
                //Usuario[] usuarios = DataBase.getUsuarios();
                System.out.println(usuario);
                System.out.println(clave.getText().toString());

                if (usuario.clave.equals(clave.getText().toString())){
                    finish();
                }
            }


        });
        crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCrearUsuario();
                finish();
            }
        });




    }
    public void abrirCrearUsuario(){
        Intent abrirCrearU = new Intent(LoginCuenta.this , CrearUsuario.class);
        startActivity(abrirCrearU);
    }



}

package com.example.freelancer_app.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancer_app.R;
import com.example.freelancer_app.data.DataBase;
import com.example.freelancer_app.data.Sesion;
import com.example.freelancer_app.data.Usuario;

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
                usuario=null;
                try{
                    System.out.println("funciona");
                    usuario = DataBase.getUsuarioByEmail(correo.getText().toString());
                    System.out.println(usuario);
                    System.out.println(clave.getText().toString());
                    if (usuario.getClave().equals(clave.getText().toString())){
                        Sesion.setUsuario(usuario);
                        finish();
                    }else{
                        Toast notificacionServicio = Toast.makeText(getApplicationContext(),
                                "Incorrecto", Toast.LENGTH_SHORT);
                        notificacionServicio.show();
                    }
                }catch (Exception e){
                    Toast notificacionServicio = Toast.makeText(getApplicationContext(),
                            "Incorrecto", Toast.LENGTH_SHORT);
                    notificacionServicio.show();
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

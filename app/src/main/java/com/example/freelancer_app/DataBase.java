package com.example.freelancer_app;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


/*
 *
 *
	metodos:

	-getUsuarios(): devuelve String en formato JSon con todos los usuarios existentes
	-getUsuarioById(int id): devuelve un String en formato JSon usuario a partir de su id
	-getUsuarioByEmail(String Email): devuelve un String en formato JSon usuario a partir de su correo
	-getServicios(): devuelve String en formato JSon con todos los servicios existentes
	-getServicioById(int id): devuelve un String en formato JSon servicio a partir de su id
	-getServicioByUserId(int idPropietario): devuelve un String en formato JSon con todos los servicios del usuario del idPropietario
	-addUsuario(String nombre, String clave, String correo,String pais,String descripcion): crea un usuario sin foto, devuelve succes sí se realizó correctamente
	-addServicio(int idPropietario, int calificacion, String descripcion,int plazo,int precio, String titulo): crea un servicio sin fotos, devuelve succes sí se realizó correctamente
	-eliminarUsuario(int id): elimina el usuario con el id, devuelve succes sí se realizó correctamente
	-eliminarServicio(int id): elimina el usuario del id, devuelve succes sí se realizó correctamente
	-modificarUsuario(int id,String nombre, String clave, String correo,String pais,String descripcion); modifica el usuario del id, envíe todos los campos, devuelve succes sí se realizó correctamente
	-modificarServicio(int id,int idPropietario, int calificacion, String descripcion,int plazo,int precio, String titulo): modifiac el servicio del id, devuelve succes sí se realizó correctamente

*/

public class DataBase {
    static String resultado;
    static Gson gson = new Gson();
    public static final String BaseURL="https://basededatos-proyectopoo.000webhostapp.com/";
    static String URL;
    static InputStream response;
    static URLConnection connection;
    static String responseBody;


    public static String makeRequest(String url) {
        response=null;
        connection=null;
        responseBody="funcionando";
        String charset = "UTF-8";
        try {
            connection = new URL(url).openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        connection.setRequestProperty("Accept-Charset", charset);
        try {
            response = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(response)) {
            responseBody = scanner.useDelimiter("\\A").next();
        }
        return responseBody;
    }
    public DataBase() {
        super();
    }

    public static Usuario[] getUsuarios() {
        URL=BaseURL+"getUsuarios.php";
        resultado=makeRequest(URL);
        Usuario[] users=gson.fromJson(resultado , Usuario[].class);
        return users;
    }
    public static Usuario getUsuarioById(int id){
        URL=BaseURL+"getUsuarioById.php?id="+id;
        resultado = makeRequest(URL);
        Usuario[] users=gson.fromJson(resultado , Usuario[].class);
        return users[0];
    }
    public static Usuario getUsuarioByEmail(String correo){
        URL=BaseURL+"getUsuarioByEmail.php?correo="+correo;
        resultado = makeRequest(URL);
        Usuario[] users=gson.fromJson(resultado , Usuario[].class);
        return users[0];
    }
    public static Servicio[] getServicios(){
        URL=BaseURL+"getServicios.php";
        resultado = makeRequest(URL);
        Servicio[] servicios=gson.fromJson(resultado , Servicio[].class);
        return servicios;
    }
    public static Servicio getServicioById(int id){
        URL=BaseURL+"getServicioById.php?id="+id;
        resultado = makeRequest(URL);
        Servicio[] servicios=gson.fromJson(resultado , Servicio[].class);
        return servicios[0];
    }
    public static Servicio getServicioByUserId(int idPropietario){
        URL=BaseURL+"getServicioByUserId.php?idPropietario="+idPropietario;
        resultado = makeRequest(URL);
        Servicio[] servicios=gson.fromJson(resultado , Servicio[].class);

        return servicios[0];
    }
    public static String addUsuario(String nombre, String clave, String correo,String pais,String descripcion) {
        URL=BaseURL+"agregarUsuario.php?nombre="+nombre+"&clave="+clave+"&correo="+correo+"&pais="+pais+"&descripcion="+descripcion;

        return makeRequest(URL);
    }
    public static String addServicio(int idPropietario, int calificacion, String descripcion,int plazo,int precio, String titulo) {
        URL=BaseURL+"agregarServicio.php?idPropietario="+idPropietario+"&calificacion="+calificacion+"&descripcion="+descripcion+"&plazo="+plazo+"&precio="+precio+"&titulo="+ titulo;

        return makeRequest(URL);
    }
    public static String eliminarUsuario(int id) {
        URL=BaseURL +"eliminarUsuario.php?id="+id;

        return makeRequest(URL);
    }
    public static String eliminarServicio(int id) {
        URL=BaseURL +"eliminarServicio.php?id="+id;

        return makeRequest(URL);
    }
    public static String modificarUsuario(int id,String nombre, String clave, String correo,String pais,String descripcion) {
        URL=BaseURL+"modificarUsuario.php?id="+id+"&nombre="+nombre+"&clave="+clave+"&correo="+correo+"&pais="+pais+"&descripcion="+descripcion;

        return makeRequest(URL);
    }
    public static String modificarServicio(int id,int idPropietario, int calificacion, String descripcion,int plazo,int precio, String titulo) {
        URL=BaseURL+"modificarServicio.php?id="+id+"&idPropietario="+idPropietario+"&calificacion="+calificacion+"&descripcion="+descripcion+"&plazo="+plazo+"&precio="+precio+"&titulo="+titulo;
        return makeRequest(URL);
    }
}

package com.example.freelancer_app;

public class Sesion {
    static private Boolean sesion;
    static private Usuario usuario;

    public static Boolean getSesion() {
        return sesion;
    }

    public static void setSesion(Boolean sesion) {
        Sesion.sesion = sesion;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Sesion.usuario = usuario;
    }

}

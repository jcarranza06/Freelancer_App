package com.example.freelancer_app;

import java.io.Serializable;

public class Sesion implements Serializable {
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

    public Sesion(Usuario usuario) {
        this.sesion=true;
        this.usuario= usuario;
    }
}

package com.example.freelancer_app;

public class Habilidad {
    String descripcionHabilidad;

    public String getDescripcionHabilidad() {
        return descripcionHabilidad;
    }

    public void setDescripcionHabilidad(String descripcionHabilidad) {
        this.descripcionHabilidad = descripcionHabilidad;
    }

    @Override
    public String toString() {
        return "La habilidad es" descripcionHabilidad ;
    }

    public Habilidad(String descripcionHabilidad) {
        super();
        this.descripcionHabilidad = descripcionHabilidad;
    }




}

package com.example.freelancer_app;

import java.util.ArrayList;


public class Servicios extends Usuario {
    ArrayList<Habilidad>  listaServicios;
    float calificacion;
    String descripcionServicio;
    String plazo;
    float precio;
    public ArrayList<Habilidad> getListaServicios() {
        return listaServicios;
    }
    public void setListaServicios(ArrayList<Habilidad> listaServicios) {
        this.listaServicios = listaServicios;
    }
    public float getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }
    public String getDescripcionServicio() {
        return descripcionServicio;
    }
    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicion = descripcionServicio;
    }
    public String getPlazo() {
        return plazo;
    }
    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Servicios listaServicios=" + listaServicios + ", calificacion=\n" + calificacion + ", descripcion del servicio=\n"
                + descripcionServicio + ", plazo =\n " + plazo + ", precio=\n" + precio;
    }
    /*
    int id;
    String nombre;
    String clave;
    String correo;
    String pais;
    String descripcion;*/

    public Servicios(ArrayList<Habilidad> listaServicios, float calificacion, String descripcion, String plazo, float precio, int id, String nombre, String clave, String correo, String pais{
        super(id, nombre, clave, correo, pais, descripcion);
        this.listaServicios = listaServicios;
        this.calificacion = calificacion;
        this.descripcionServicio = descripcionServicio;
        this.plazo = plazo;
        this.precio = precio;
    }


}

package com.example.freelancer_app;

import java.util.ArrayList;


public class Servicios {
    ArrayList<Habilidad>  listaServicios;
    int idPropietario;
    int idServicio;
    int calificacion;
    String descripcionServicio;
    int plazo;
    int precio;
    String titulo;

    public ArrayList<Habilidad> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Habilidad> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "El titulo del servicio es: "+ titulo+"\n"+"El id del servicio es: "+idServicio+"\n"+
                "El id del propietario es: "+idPropietario +"\n"+"Los servicios que ofrece son: "+
        listaServicios+"\n"+ "La calificacion es: " + calificacion+"\n"+"Su descripcion es: "
                + descripcionServicio +"\n"+ "El plazo es:  " + plazo +"\n"+ "El precio es :" + precio+"\n";
    }


    public Servicios(ArrayList<Habilidad> listaServicios, int calificacion, String descripcionServicio, int plazo,
                     int precio, String titulo){
        this.listaServicios = listaServicios;
        this.calificacion = calificacion;
        this.descripcionServicio = descripcionServicio;
        this.plazo = plazo;
        this.precio = precio;
        this.titulo = titulo;
    }


}

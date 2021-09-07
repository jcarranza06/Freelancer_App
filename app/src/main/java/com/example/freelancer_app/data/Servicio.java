package com.example.freelancer_app.data;

import java.util.ArrayList;

public class Servicio extends ObjetoDataBase{
    ArrayList<Habilidad>  listaServicios;
    final int idPropietario;
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

    public int getIdServicio() {
        return id;
    }

    public int getCalificacion(int i) {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcionServicio() {
        return descripcion;
    }

    public void setDescripcionServicio(String descripcion) {
        this.descripcion = descripcion;
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
        return "El titulo del servicio es: "+ titulo+"\n"+"El id del servicio es: "+id+"\n"+
                "El id del propietario es: "+idPropietario +"\n"+"Los servicios que ofrece son: "+
        listaServicios+"\n"+ "La calificacion es: " + calificacion+"\n"+"Su descripcion es: "
                + descripcion+"\n"+ "El plazo es:  " + plazo +"\n"+ "El precio es :" + precio+"\n";
    }


    public Servicio(ArrayList<Habilidad> listaServicios, int calificacion, String descripcionServicio, int plazo,
                    int precio, String titulo, int idPropietario, int id){
        super(descripcionServicio, "colombia", calificacion, "Servicios");
        this.idPropietario=idPropietario;
        this.listaServicios = listaServicios;
        this.plazo = plazo;
        this.precio = precio;
        this.titulo = titulo;
    }

}

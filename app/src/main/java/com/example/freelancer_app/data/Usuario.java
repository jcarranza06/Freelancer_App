package com.example.freelancer_app.data;

import java.io.Serializable;

public class Usuario extends ObjetoDataBase implements Serializable{
    String nombre;
    String clave;
    String correo;


    public int getId() {
        return this.id;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripción) {
        this.descripcion = descripcion;
    }



    public Usuario(int idc, String nombre, String clave, String correo, String pais, String descripcion) {
        super(idc,descripcion,pais,389890,"Usuarios");
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
    }
    public Usuario( String nombre, String clave, String correo, String pais, String descripcion) {
        super(DataBase.getUsuarioByEmail(correo).getId(),descripcion,pais,389890,"Usuarios");
        this.nombre = nombre;
        this.clave = clave;
        this.correo = correo;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", clave='" + getClave() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", pais='" + getPais() + "'" +
            ", descripción='" + getDescripcion() + "'" +
            "}";
    }

    
}
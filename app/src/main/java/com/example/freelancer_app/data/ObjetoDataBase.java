package com.example.freelancer_app.data;

public abstract class ObjetoDataBase {

    final int id;
    String descripcion;
    String pais;
    int calificacion;
    final String table;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPais() {
        return pais;
    }

    public String getTable() {
        return table;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public float getCalificacion() {
        Calificacion c1=new Calificacion(calificacion);
        return c1.getCalificacion();
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public ObjetoDataBase(int id, String descripcion, String pais, int calificacion, String table) {
        this.id = id;
        this.descripcion = descripcion;
        this.pais = pais;
        this.calificacion = calificacion;
        this.table=table;
    }
    public ObjetoDataBase( String descripcion, String pais, int calificacion, String table) {
        this.id=0;
        this.descripcion = descripcion;
        this.pais = pais;
        this.calificacion = calificacion;
        this.table=table;
    }
}

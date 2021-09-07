package com.example.freelancer_app.data;

public class Calificacion {
    int sumatoria;
    int cantidadCalificaciones;

    public int getSumatoria() {
        return sumatoria;
    }

    public void setSumatoria(int sumatoria) {
        this.sumatoria = sumatoria;
    }

    public int getCantidadCalificaciones() {
        return cantidadCalificaciones;
    }

    public void setCantidadCalificaciones(int cantidadCalificaciones) {
        this.cantidadCalificaciones = cantidadCalificaciones;
    }

    public float getCalificacion(){
        return sumatoria/cantidadCalificaciones;
    }
    public int getCalificacionCode(){
        String a=Integer.toString(sumatoria);
        String b=Integer.toString(cantidadCalificaciones);
        String code= a+"8989"+b;
        return Integer.valueOf(code);
    }

    public Calificacion(int sumatoria, int cantidadCalificaciones) {
        this.sumatoria = sumatoria;
        this.cantidadCalificaciones = cantidadCalificaciones;
    }
    public Calificacion(int code) {
        int index=String.valueOf(code).indexOf("8989");
        this.sumatoria = Integer.valueOf(String.valueOf(code).substring(0,index));
        this.cantidadCalificaciones = Integer.valueOf(String.valueOf(code).substring(index+4,String.valueOf(code).length()));
    }
    public void add(int i){
        this.sumatoria+=i;
        this.cantidadCalificaciones+=1;
    }

}

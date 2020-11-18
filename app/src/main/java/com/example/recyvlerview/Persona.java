package com.example.recyvlerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

public class Persona {

    String nombre ;
    String anio;
//    int fotoID;
   String descripcion;





    public Persona(String nombre , String anio, String descripcion ){

        this.nombre=nombre;
        this.anio=anio;
        this.descripcion=descripcion;

        //    this.fotoID=fotoID;



    }












    public Persona(){


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}

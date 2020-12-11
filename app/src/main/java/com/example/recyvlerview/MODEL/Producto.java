package com.example.recyvlerview.MODEL;

public class Producto {

         String nombre;
         String precio;
         int id ;

         public Producto(){
             nombre="";
             precio="";
             id=0;

         }

    public Producto(String nombre, String precio, int id) {
        this.nombre = nombre;
        this.precio = precio;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

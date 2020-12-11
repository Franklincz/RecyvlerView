package com.example.recyvlerview.OBJETOS;

import com.example.recyvlerview.MODEL.Producto;

public class ArayProductos {
    Producto p= new Producto();
    String cantidad;

public ArayProductos(){
    cantidad="";
    p=new Producto();

}

    public ArayProductos(Producto p, String cantidad) {

        this.p = p;
        this.cantidad = cantidad;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}

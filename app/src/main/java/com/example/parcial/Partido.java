package com.example.parcial;

import java.io.Serializable;

public class Partido implements Serializable {

    private String nombre;
    private String resultado;
    private String urImagen;

    public Partido() {
    }

    public Partido(String nombre, String resultado, String urImagen) {
        this.nombre = nombre;
        this.resultado = resultado;
        this.urImagen = urImagen;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResultado() { return resultado;}

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getUrImagen() {
        return urImagen;
    }

    public void setUrImagen(String urImagen) {
        this.urImagen = urImagen;
    }
}

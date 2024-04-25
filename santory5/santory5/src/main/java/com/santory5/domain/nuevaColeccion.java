package com.santory5.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "nuevaColeccion")

public class nuevaColeccion implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_nuevacoleccion") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long idNuevaColeccion;
    private double precio;
    private String descripcion;
    private int cantidad_colores;
    private String talla;
    private int existencias;
    private boolean activo;
    private String rutaImagen;
   

    public nuevaColeccion() {
    }

    public nuevaColeccion(double precio, String descripcion, int cantidad_colores, String talla, int existencias, boolean activo, String rutaImagen) {
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad_colores = cantidad_colores;
        this.talla = talla;
        this.existencias = existencias;
        this.activo = activo;
        this.rutaImagen = rutaImagen;
    }



}
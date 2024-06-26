
package com.santory5.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "calzadofemenino")

public class calzadoFemenino implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_calzadofemenino") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long id_calzadofemenino;
    private double precio;
    private String descripcion;
    private int cantidad_colores;
    private String talla;
    private int existencias;
    private boolean activo;
    private String rutaImagen;
   

    public calzadoFemenino() {
    }

    public calzadoFemenino(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

}
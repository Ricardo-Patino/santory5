
package com.santory5.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "puntos_de_venta")

public class puntosDeVenta implements Serializable  {
    
    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_sucursal") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long id_sucursal;
    private String sucursal;
    private String descripcion;
    private String ubicacion;
    private String horario;
    private boolean activo;
    private String rutaImagen;
   

    public puntosDeVenta() {
    }

    public puntosDeVenta(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
}

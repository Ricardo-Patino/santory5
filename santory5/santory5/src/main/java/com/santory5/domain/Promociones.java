/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santory5.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author USUARIO
 */
@Data
@Entity
@Table(name = "promociones")
public class Promociones implements Serializable {
    
    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria. 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD 
    @Column(name = "id_promociones") //decir cual es el nombre en la base de datos. Se hace la asociación 
    private long id_promociones;
    private double precio;
    private String descripcion;
    private int cantidad_colores;
    private String talla;
    private boolean activo;
    private double precio_promocion;
    private String rutaImagen;
   

    public Promociones() {
    }

    public Promociones(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    
    
}

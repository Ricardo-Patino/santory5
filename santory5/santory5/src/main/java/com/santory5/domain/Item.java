package com.santory5.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Item extends nuevaColeccion {
    private int cantidad; //Almacenar la cantidad de items de las Nuevas Colecciones

    public Item() {
    }

    public Item(nuevaColeccion nuevacoleccion) {
        super.setIdNuevaColeccion(nuevacoleccion.getIdNuevaColeccion());
        super.setPrecio(nuevacoleccion.getPrecio());
        super.setDescripcion(nuevacoleccion.getDescripcion());
        super.setCantidad_colores(nuevacoleccion.getCantidad_colores());
        super.setTalla(nuevacoleccion.getTalla());
        super.setActivo(nuevacoleccion.isActivo());
        super.setRutaImagen(nuevacoleccion.getRutaImagen());
        this.cantidad = 0;
    }
}
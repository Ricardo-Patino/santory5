package com.santory5.service;

import com.santory5.domain.nuevaColeccion;
import java.util.List;

public interface nuevaColeccionService {
    
    // Se obtiene un listado de categorias en un List
    public List<nuevaColeccion> getnuevaColeccion(boolean activos);
    
    // Se obtiene un Categoria, a partir del id de un categoria
    public nuevaColeccion getnuevaColeccions(nuevaColeccion nuevacoleccion);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(nuevaColeccion nuevacoleccion);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(nuevaColeccion nuevacoleccion);
 
}
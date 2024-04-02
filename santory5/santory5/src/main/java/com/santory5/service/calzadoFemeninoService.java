package com.santory5.service;

import com.santory5.domain.calzadoFemenino;
import java.util.List;

public interface calzadoFemeninoService {
    
    // Se obtiene un listado de categorias en un List
    public List<calzadoFemenino> getcalzadoFemenino(boolean activos);
    
    // Se obtiene un Categoria, a partir del id de un categoria
    public calzadoFemenino getcalzadoFemeninos(calzadoFemenino calzadofemenino);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(calzadoFemenino calzadofemenino);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(calzadoFemenino calzafemenino);
 
}
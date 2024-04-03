/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santory5.service;

import com.santory5.domain.Promociones;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface PromocionesService {
    // Se obtiene un listado de categorias en un List
    public List<Promociones> getPromociones(boolean activos);
    
    // Se obtiene un Categoria, a partir del id de un categoria
    public Promociones getPromocioness(Promociones promociones);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Promociones promociones);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Promociones promociones);
}

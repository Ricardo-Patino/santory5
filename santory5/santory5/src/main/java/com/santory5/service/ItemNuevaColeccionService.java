package com.santory5.service;

import com.santory5.domain.ItemNuevaColeccion;
import java.util.ArrayList;
import java.util.List;

public interface ItemNuevaColeccionService {     
    List<ItemNuevaColeccion> ItemNuevaColecciones = new ArrayList<>();
    
    public List<ItemNuevaColeccion> gets();
    
    //Se recupera el registro que tiene el idItem pasado por parámetro
    //si no existe en la tabla se retorna null
    public ItemNuevaColeccion get(ItemNuevaColeccion itemnuevacoleccion);
    
    //Se elimina el registro que tiene el idItem pasado por parámetro
    public void delete(ItemNuevaColeccion itemnuevacoleccion);
    
    //Si el objeto item tiene un idItem que existe en la tabla item
    //El registro de actualiza con la nueva información
    //Si el idItem NO existe en la tabla, se crea el registro con esa información
    public void save(ItemNuevaColeccion itemnuevacoleccion);
    
    public void actualiza(ItemNuevaColeccion itemnuevacoleccion);
    
    public void facturar();
}

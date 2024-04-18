package com.santory5.service.impl;

import com.santory5.dao.FacturaDao;
import com.santory5.dao.VentaDao;
import com.santory5.domain.nuevaColeccion;
import com.santory5.domain.Usuario;
import com.santory5.domain.Factura;
import com.santory5.domain.ItemNuevaColeccion;
import com.santory5.domain.Venta;
import com.santory5.service.UsuarioService;
import com.santory5.service.ItemNuevaColeccionService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.santory5.dao.nuevaColeccionDao;

@Service
public class ItemNuevaColeccionServiceImpl implements ItemNuevaColeccionService {

    @Override
    public List<ItemNuevaColeccion> gets() {
        return ItemNuevaColecciones;
    }

    //Se usa en el addCarrito... agrega un elemento
    @Override
    public void save(ItemNuevaColeccion itemnuevacoleccion) {
        boolean existe = false;
        for (ItemNuevaColeccion i : ItemNuevaColecciones) {
            //Busca si ya existe el producto en el carrito
            if (Objects.equals(i.getId_nuevacoleccion(), itemnuevacoleccion.getId_nuevacoleccion())) {
                //Valida si aún puede colocar un item adicional -segun existencias-
                if (i.getCantidad() < itemnuevacoleccion.getExistencias()) {
                    //Incrementa en 1 la cantidad de elementos
                    i.setCantidad(i.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {//Si no está el producto en el carrito se agrega cantidad =1.            
            itemnuevacoleccion.setCantidad(1);
            ItemNuevaColecciones.add(itemnuevacoleccion);
        }
    }

    //Se usa para eliminar un producto del carrito
    @Override
    public void delete(ItemNuevaColeccion itemnuevacoleccion) {
        var posicion = -1;
        var existe = false;
        for (ItemNuevaColeccion i : ItemNuevaColecciones) {
            ++posicion;
            if (Objects.equals(i.getId_nuevacoleccion(), itemnuevacoleccion.getId_nuevacoleccion())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            ItemNuevaColecciones.remove(posicion);
        }
    }

    //Se obtiene la información de un producto del carrito... para modificarlo
    @Override
    public ItemNuevaColeccion get(ItemNuevaColeccion itemnuevacoleccion) {
        for (ItemNuevaColeccion i : ItemNuevaColecciones) {
            if (Objects.equals(i.getId_nuevacoleccion(), itemnuevacoleccion.getId_nuevacoleccion())) {
                return i;
            }
        }
        return null;
    }

    //Se usa en la página para actualizar la cantidad de productos
    @Override
    public void actualiza(ItemNuevaColeccion itemnuevacoleccion) {
        for (ItemNuevaColeccion i : ItemNuevaColecciones) {
            if (Objects.equals(i.getId_nuevacoleccion(), itemnuevacoleccion.getId_nuevacoleccion())) {
                i.setCantidad(itemnuevacoleccion.getCantidad());
                break;
            }
        }
    }

    @Autowired
    private UsuarioService uuarioService;

    @Autowired
    private FacturaDao facturaDao;
    @Autowired
    private VentaDao ventaDao;
    @Autowired
    private nuevaColeccionDao nuevaColeccionDao;

    @Override
    public void facturar() {
        System.out.println("Facturando");

        //Se obtiene el usuario autenticado
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }

        if (username.isBlank()) {
            return;
        }

        Usuario usuario = uuarioService.getUsuarioPorUsername(username);

        if (usuario == null) {
            return;
        }

        Factura factura = new Factura(usuario.getIdUsuario());
        factura = facturaDao.save(factura);

        double total = 0;
        for (ItemNuevaColeccion i : ItemNuevaColecciones) {
            System.out.println("Producto: " + i.getDescripcion()
                    + " Cantidad: " + i.getCantidad()
                    + " Total: " + i.getPrecio() * i.getCantidad());
            Venta venta = new Venta(factura.getIdFactura(), i.getId_nuevacoleccion(), i.getPrecio(), i.getCantidad());
            ventaDao.save(venta);
            nuevaColeccion nuevacoleccion = nuevaColeccionDao.getReferenceById(i.getId_nuevacoleccion());
            nuevacoleccion.setExistencias(nuevacoleccion.getExistencias()-i.getCantidad());
            nuevaColeccionDao.save(nuevacoleccion);
            total += i.getPrecio() * i.getCantidad();
        }
        factura.setTotal(total);
        facturaDao.save(factura);
        ItemNuevaColecciones.clear();
    }
}
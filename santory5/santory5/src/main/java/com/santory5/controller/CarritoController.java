package com.santory5.controller;

import com.santory5.domain.nuevaColeccion;
import com.santory5.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.santory5.service.nuevaColeccionService;
import com.santory5.service.ItemService;

@Controller
public class CarritoController {
    @Autowired
    private ItemService ItemService;
    @Autowired
    private nuevaColeccionService nuevaColeccionService;
    
    @GetMapping("/")
    private String listado(Model model) {
        var nuevacolecciones = nuevaColeccionService.getnuevaColeccion(false);
        model.addAttribute("nuevacolecciones", nuevacolecciones);
        return "/index";
    }

    //Para ver el carrito
    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var itemnuevacolecciones = ItemService.gets();
        model.addAttribute("itemnuevacolecciones", itemnuevacolecciones);
        var carritoTotalVenta = 0;
        for (Item i : itemnuevacolecciones) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", 
                carritoTotalVenta);
        return "/carrito/listado";
    }    
   
    //Para Agregar un nuevacoleccion al carrito
    @GetMapping("/carrito/agregar/{id_nuevacoleccion}")
    public ModelAndView agregarItem(Model model, Item itemnuevacoleccion) {
        Item itemnuevacoleccion2 = ItemService.get(itemnuevacoleccion);
        if (itemnuevacoleccion2 == null) {
            nuevaColeccion nuevacoleccion = nuevaColeccionService.getnuevaColeccions(itemnuevacoleccion);
            itemnuevacoleccion2 = new Item(nuevacoleccion);
        }
        nuevaColeccionService.save(itemnuevacoleccion2);
        var lista = ItemService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (Item i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }

    //Para mofificar un nuevacoleccion del carrito
    @GetMapping("/carrito/modificar/{id_nuevacoleccion}")
    public String modificarItem(Item itemNuevaColeccion, Model model) {
        itemNuevaColeccion = ItemService.get(itemNuevaColeccion);
        model.addAttribute("itemNuevaColeccion", itemNuevaColeccion);
        return "/carrito/modificar";
    }

    //Para eliminar un elemento del carrito
    @GetMapping("/carrito/eliminar/{id_nuevacoleccion}")
    public String eliminarItem(Item itemNuevaColeccion) {
        ItemService.delete(itemNuevaColeccion);
        return "redirect:/carrito/listado";
    }

    //Para actualizar un nuevacoleccion del carrito (cantidad)
    @PostMapping("/carrito/guardar")
    public String guardarItem(Item itemNuevaColeccion) {
        ItemService.actualiza(itemNuevaColeccion);
        return "redirect:/carrito/listado";
    }

    //Para facturar los nuevacoleccions del carrito... no implementado...
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        ItemService.facturar();
        return "redirect:/";
    }
}

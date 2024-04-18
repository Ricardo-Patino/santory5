package com.santory5.controller;

import com.santory5.domain.nuevaColeccion;
import com.santory5.domain.ItemNuevaColeccion;
import com.santory5.service.ItemNuevaColeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.santory5.service.nuevaColeccionService;

@Controller
public class CarritoController {
    @Autowired
    private ItemNuevaColeccionService ItemNuevaColeccionService;
    @Autowired
    private nuevaColeccionService nuevaColeccionService;
    
    @GetMapping("/")
    private String listado(Model model) {
        var nuevacolecciones = nuevaColeccionService.getnuevaColeccion(false);
        model.addAttribute("nuevacoleccions", nuevacolecciones);
        return "/index";
    }

    //Para ver el carrito
    @GetMapping("/carrito/listado")
    public String inicio(Model model) {
        var itemnuevacolecciones = ItemNuevaColeccionService.gets();
        model.addAttribute("itemnuevacolecciones", itemnuevacolecciones);
        var carritoTotalVenta = 0;
        for (ItemNuevaColeccion i : itemnuevacolecciones) {
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("carritoTotal", 
                carritoTotalVenta);
        return "/carrito/listado";
    }    
   
    //Para Agregar un nuevacoleccion al carrito
    @GetMapping("/carrito/agregar/{idnuevacoleccion}")
    public ModelAndView agregarItem(Model model, ItemNuevaColeccion itemnuevacoleccion) {
        ItemNuevaColeccion itemnuevacoleccion2 = ItemNuevaColeccionService.get(itemnuevacoleccion);
        if (itemnuevacoleccion2 == null) {
            nuevaColeccion nuevacoleccion = nuevaColeccionService.getnuevaColeccions(itemnuevacoleccion);
            itemnuevacoleccion2 = new ItemNuevaColeccion(nuevacoleccion);
        }
        nuevaColeccionService.save(itemnuevacoleccion2);
        var lista = ItemNuevaColeccionService.gets();
        var totalCarritos = 0;
        var carritoTotalVenta = 0;
        for (ItemNuevaColeccion i : lista) {
            totalCarritos += i.getCantidad();
            carritoTotalVenta += (i.getCantidad() * i.getPrecio());
        }
        model.addAttribute("listaItems", lista);
        model.addAttribute("listaTotal", totalCarritos);
        model.addAttribute("carritoTotal", carritoTotalVenta);
        return new ModelAndView("/carrito/fragmentos :: verCarrito");
    }

    //Para mofificar un nuevacoleccion del carrito
    @GetMapping("/carrito/modificar/{idNuevaColeccion}")
    public String modificarItem(ItemNuevaColeccion itemNuevaColeccion, Model model) {
        itemNuevaColeccion = ItemNuevaColeccionService.get(itemNuevaColeccion);
        model.addAttribute("itemNuevaColeccion", itemNuevaColeccion);
        return "/carrito/modificar";
    }

    //Para eliminar un elemento del carrito
    @GetMapping("/carrito/eliminar/{idNuevaColeccion}")
    public String eliminarItem(ItemNuevaColeccion itemNuevaColeccion) {
        ItemNuevaColeccionService.delete(itemNuevaColeccion);
        return "redirect:/carrito/listado";
    }

    //Para actualizar un nuevacoleccion del carrito (cantidad)
    @PostMapping("/carrito/guardar")
    public String guardarItem(ItemNuevaColeccion itemNuevaColeccion) {
        ItemNuevaColeccionService.actualiza(itemNuevaColeccion);
        return "redirect:/carrito/listado";
    }

    //Para facturar los nuevacoleccions del carrito... no implementado...
    @GetMapping("/facturar/carrito")
    public String facturarCarrito() {
        ItemNuevaColeccionService.facturar();
        return "redirect:/";
    }
}

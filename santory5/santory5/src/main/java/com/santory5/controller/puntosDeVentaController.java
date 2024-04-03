package com.santory5.controller;

import com.santory5.domain.puntosDeVenta;
import com.santory5.service.impl.FirebaseStorageServiceImpl;
import com.santory5.service.puntosDeVentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/puntosDeVenta")
public class puntosDeVentaController {
    
    @Autowired
    private puntosDeVentaService puntosDeVentaService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var puntosdeventaes = puntosDeVentaService.getpuntosDeVenta(false);
        System.out.println(puntosdeventaes);
        model.addAttribute("puntosdeventaes", puntosdeventaes);
        model.addAttribute("totalpuntosdeventaes", puntosdeventaes.size());
        return "/puntosdeventa/listado";
    }
    
    @GetMapping("/nuevo")
    public String puntosdeventaNuevo(puntosDeVenta puntosdeventa) {
        return "/puntosdeventa/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String puntosdeventaGuardar(puntosDeVenta puntosdeventa,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            puntosDeVentaService.save(puntosdeventa);
            puntosdeventa.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "puntosdeventa", 
                            puntosdeventa.getId_sucursal()));
        }
        puntosDeVentaService.save(puntosdeventa);
        return "redirect:/puntosdeventa/listado";
    }

    @GetMapping("/eliminar/{id_puntosdeventa}")
    public String puntosdeventaEliminar(puntosDeVenta puntosdeventa) {
        puntosDeVentaService.delete(puntosdeventa);
        return "redirect:/puntosdeventa/listado";
    }

    @GetMapping("/modifica/{id_puntosdeventa}")
    public String puntosdeventaModificar(puntosDeVenta puntosdeventa, Model model) {
        puntosdeventa = puntosDeVentaService.getpuntosDeVentass(puntosdeventa);
        model.addAttribute("puntosdeventa", puntosdeventa);
        return "/puntosdeventa/modifica";
    }
    
    
}

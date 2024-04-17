package com.santory5.controller;

import com.santory5.domain.Promociones;
import com.santory5.service.PromocionesService;
import com.santory5.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
@RequestMapping("/promociones")
public class PromocionesController {
    @Autowired
    private PromocionesService PromocionesService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var promocioneses = PromocionesService.getPromociones(false);
        System.out.println(promocioneses);
        model.addAttribute("promocioneses", promocioneses);
        model.addAttribute("totalpromocioneses", promocioneses.size());
        return "/promociones/listado";
    }
    
    @GetMapping("/nuevo")
    public String promocionesNuevo(Promociones promociones) {
        return "/promociones/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String promocionesGuardar(Promociones promociones) {        
//        if (!imagenFile.isEmpty()) {
//            PromocionesService.save(promociones);
//            promociones.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile, 
//                            "promociones", 
//                            promociones.getId_promociones()));
//        }
        PromocionesService.save(promociones);
        return "redirect:/promociones/listado";
    }

    @GetMapping("/eliminar/{id_promociones}")
    public String promocionesEliminar(Promociones promociones) {
        PromocionesService.delete(promociones);
        return "redirect:/promociones/listado";
    }

    @GetMapping("/modifica/{id_promociones}")
    public String promocionesModificar(Promociones promociones, Model model) {
        promociones = PromocionesService.getPromocioness(promociones);
        model.addAttribute("promociones", promociones);
        return "/promociones/modifica";
    }
    
}

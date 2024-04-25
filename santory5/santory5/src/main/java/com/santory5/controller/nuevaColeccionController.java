package com.santory5.controller;

import com.santory5.domain.nuevaColeccion;
import com.santory5.service.impl.FirebaseStorageServiceImpl;
import com.santory5.service.nuevaColeccionService;
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
@RequestMapping("/nuevaColeccion")
public class nuevaColeccionController {

    @Autowired
    private nuevaColeccionService nuevaColeccionService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var nuevaColeccion = nuevaColeccionService.getnuevaColeccion(false);
        model.addAttribute("nuevacolecciones", nuevaColeccion);
        model.addAttribute("totalnuevacolecciones", nuevaColeccion.size());
        return "/nuevaColeccion/listado";
    }

    @GetMapping("/nuevo")
    public String nuevaColeccionNuevo(nuevaColeccion nuevaColeccion) {
        return "/nuevaColeccion/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String nuevaColeccionGuardar(nuevaColeccion nuevaColeccion) {
//        if (!imagenFile.isEmpty()) {
//            nuevaColeccionService.save(nuevacoleccion);
//            nuevacoleccion.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile, 
//                            "nuevaColeccion", 
//                            nuevacoleccion.getId_nuevacoleccion()));
//        }
        nuevaColeccionService.save(nuevaColeccion);
        return "redirect:/nuevaColeccion/listado";
    }

    @GetMapping("/eliminar/{idNuevaColeccion}")
    public String nuevaColeccionEliminar(nuevaColeccion nuevaColeccion) {
        nuevaColeccionService.delete(nuevaColeccion);
        return "redirect:/nuevaColeccion/listado";
    }

    @GetMapping("/modificar/{idNuevaColeccion}")
    public String nuevaColeccionModificar(nuevaColeccion nuevaColeccion, Model model) {
        nuevaColeccion = nuevaColeccionService.getnuevaColeccions(nuevaColeccion);
        model.addAttribute("nuevacoleccion", nuevaColeccion);
        return "/nuevaColeccion/modifica";
    }

}

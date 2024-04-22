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
        var nuevacolecciones = nuevaColeccionService.getnuevaColeccion(false);
        model.addAttribute("nuevacolecciones", nuevacolecciones);
        model.addAttribute("totalnuevacolecciones", nuevacolecciones.size());
        return "/nuevaColeccion/listado";
    }

    @GetMapping("/nuevo")
    public String nuevaColeccionNuevo(nuevaColeccion nuevacoleccion) {
        return "/nuevaColeccion/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String nuevaColeccionGuardar(nuevaColeccion nuevacoleccion) {
//        if (!imagenFile.isEmpty()) {
//            nuevaColeccionService.save(nuevacoleccion);
//            nuevacoleccion.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile, 
//                            "nuevaColeccion", 
//                            nuevacoleccion.getId_nuevacoleccion()));
//        }
        nuevaColeccionService.save(nuevacoleccion);
        return "redirect:/nuevaColeccion/listado";
    }

    @GetMapping("/eliminar/{id_nuevacoleccion}")
    public String nuevaColeccionEliminar(nuevaColeccion nuevacoleccion) {
        nuevaColeccionService.delete(nuevacoleccion);
        return "redirect:/nuevaColeccion/listado";
    }

    @GetMapping("/modificar/{id_nuevacoleccion}")
    public String nuevaColeccionModificar(nuevaColeccion nuevacoleccion, Model model) {
        nuevacoleccion = nuevaColeccionService.getnuevaColeccions(nuevacoleccion);
        model.addAttribute("nuevacoleccion", nuevacoleccion);
        return "/nuevaColeccion/modifica";
    }

}

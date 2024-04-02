package com.santory5.controller;

import com.santory5.domain.calzadoFemenino;
import com.santory5.service.impl.FirebaseStorageServiceImpl;
import com.santory5.service.calzadoFemeninoService;
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
@RequestMapping("/calzadoFemenino")
public class calzadoFemeninoController {
    
    @Autowired
    private calzadoFemeninoService calzadoFemeninoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var calzadofemeninoes = calzadoFemeninoService.getcalzadoFemenino(false);
        System.out.println(calzadofemeninoes);
        model.addAttribute("calzadofemeninoes", calzadofemeninoes);
        model.addAttribute("totalcalzadofemeninoes", calzadofemeninoes.size());
        return "/calzadoFemenino/listado";
    }
    
    @GetMapping("/nuevo")
    public String calzadoFemeninoNuevo(calzadoFemenino calzadofemenino) {
        return "/calzadoFemenino/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String calzadoFemeninoGuardar(calzadoFemenino calzadofemenino,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            calzadoFemeninoService.save(calzadofemenino);
            calzadofemenino.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "calzadoFemenino", 
                            calzadofemenino.getId_calzadofemenino()));
        }
        calzadoFemeninoService.save(calzadofemenino);
        return "redirect:/calzadoFemenino/listado";
    }

    @GetMapping("/eliminar/{id_calzadofemenino}")
    public String calzadoFemeninoEliminar(calzadoFemenino calzadofemenino) {
        calzadoFemeninoService.delete(calzadofemenino);
        return "redirect:/calzadoFemenino/listado";
    }

    @GetMapping("/modifica/{id_nuevacoleccion}")
    public String calzadoFemeninoModificar(calzadoFemenino calzadofemenino, Model model) {
        calzadofemenino = calzadoFemeninoService.getcalzadoFemeninos(calzadofemenino);
        model.addAttribute("calzadofemenino", calzadofemenino);
        return "/calzadoFemenino/modifica";
    }
    
}
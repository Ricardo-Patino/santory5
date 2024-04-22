package com.santory5.controller;

import com.santory5.service.ReporteService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    ReporteService reporteService;

    @GetMapping("/principal")
    public String principal(Model model) {
        return "/reportes/principal";
    }
    
    @GetMapping("/usuariossantory")
    public ResponseEntity<Resource> usuariossantory(@RequestParam String tipo) throws IOException {
        
        return reporteService.generaReporte("usuariossantory", null, tipo);
     
    }
    
}
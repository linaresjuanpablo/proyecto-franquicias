package com.Franquicia.Proyecto.Franquicia.Controller;

import com.Franquicia.Proyecto.Franquicia.Dto.FranquiciaDto;
import com.Franquicia.Proyecto.Franquicia.Service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/franquicias")

public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    @Autowired
    public FranquiciaController(FranquiciaService franquiciaService){
        this.franquiciaService = franquiciaService;
    }
    @PostMapping
    public ResponseEntity<String> guardarFranquicia(@RequestBody FranquiciaDto franquicia){
        franquiciaService.guardarFranquicia(
                franquicia.getNit(),
                franquicia.getNombre(),
                franquicia.getDireccion(),
                franquicia.getCiudad(),
                franquicia.getRepresentanteLegal(),
                franquicia.getActividadEconomica()
        );
        return ResponseEntity.ok("Franquicia guardada con exito");
    }
}

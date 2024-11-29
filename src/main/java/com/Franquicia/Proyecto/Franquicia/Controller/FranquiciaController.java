package com.Franquicia.Proyecto.Franquicia.Controller;

import com.Franquicia.Proyecto.Franquicia.Dto.FranquiciaActualizarDto;
import com.Franquicia.Proyecto.Franquicia.Dto.FranquiciaDto;
import com.Franquicia.Proyecto.Franquicia.Service.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/renovar")
    public ResponseEntity<String> actualizarNombreFranquicia(@RequestBody FranquiciaActualizarDto request){
        try {
            String respuesta = franquiciaService.actualizarNombreFranquicia(
                    request.getNombreActual(),
                    request.getNuevoNombre()
            );
            return ResponseEntity.ok(respuesta);
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}

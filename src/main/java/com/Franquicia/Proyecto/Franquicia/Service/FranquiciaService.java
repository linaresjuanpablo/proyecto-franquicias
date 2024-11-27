package com.Franquicia.Proyecto.Franquicia.Service;

import com.Franquicia.Proyecto.Franquicia.Repository.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    @Autowired
    public FranquiciaService(FranquiciaRepository franquiciaRepository){
        this.franquiciaRepository = franquiciaRepository;
    }
    public void guardarFranquicia(Integer nit,
                                  String nombre,
                                  String direccion,
                                  String ciudad,
                                  String representanteLegal,
                                  String actividadEconomica) {

        if (nit == null || nit<=0) {
            throw new IllegalArgumentException("El NIT no puede estar vacío");
        }


        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        if (ciudad == null || ciudad.isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede estar vacía");
        }
        if (representanteLegal == null || representanteLegal.isEmpty()) {
            throw new IllegalArgumentException("El representante legal no puede estar vacío");
        }
        if (actividadEconomica == null || actividadEconomica.isEmpty()) {
            throw new IllegalArgumentException("La actividad económica no puede estar vacía");
        }


        franquiciaRepository.guardarFranquicia(nit,nombre,direccion,ciudad,representanteLegal,actividadEconomica);
    }
}

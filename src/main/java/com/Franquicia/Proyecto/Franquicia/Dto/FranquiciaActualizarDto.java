package com.Franquicia.Proyecto.Franquicia.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FranquiciaActualizarDto {
    private String nombreActual;
    private String nuevoNombre;

    public FranquiciaActualizarDto(String nombreActual, String nuevoNombre) {
        this.nombreActual = nombreActual;
        this.nuevoNombre = nuevoNombre;
    }
}

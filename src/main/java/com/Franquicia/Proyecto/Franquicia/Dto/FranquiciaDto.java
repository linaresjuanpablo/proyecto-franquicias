package com.Franquicia.Proyecto.Franquicia.Dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter

public class FranquiciaDto {


    private Integer nit;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String representanteLegal;
    private String actividadEconomica;


    public FranquiciaDto(Integer nit, String nombre, String direccion, String telefono, String ciudad, String representanteLegal, String actividadEconomica) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.representanteLegal = representanteLegal;
        this.actividadEconomica = actividadEconomica;
    }
}
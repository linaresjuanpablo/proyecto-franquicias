package com.Franquicia.Proyecto.Franquicia.Dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SucursalDto {

    private String nombre;
    private Integer nitSucursal;
    private  String telefono;
    private String direccion;
    private String ciudad;

    public SucursalDto(String nombre, Integer nitSucursal, String telefono, String direccion, String ciudad) {
        this.nombre = nombre;
        this.nitSucursal = nitSucursal;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }
}







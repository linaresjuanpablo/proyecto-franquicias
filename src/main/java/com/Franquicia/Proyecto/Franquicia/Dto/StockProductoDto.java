package com.Franquicia.Proyecto.Franquicia.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public class StockProductoDto {

    private String nombre;
    private String precio;
    private String cantidad;
    private String nombreSucursal;
    private String nombrefranquicia;
    //private  Long id;

    public StockProductoDto(String nombre, String precio, String cantidad, String nombreSucursal, String nombrefranquicia) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.nombreSucursal = nombreSucursal;
        this.nombrefranquicia = nombrefranquicia;

    }

    private List<StockProductoDto> stockProductoDto;
}



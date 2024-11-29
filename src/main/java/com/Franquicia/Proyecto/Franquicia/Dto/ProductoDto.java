package com.Franquicia.Proyecto.Franquicia.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProductoDto {


    private String nombre;
    private String cantidad;
    private String precio;
    private Long nitSucursal;



    public ProductoDto(String nombre, String cantidad, String precio, Long nitSucursal){
        this.cantidad = cantidad;
        this.precio = precio;
        this.nitSucursal = nitSucursal;
        //this.productoId = productoId;
        //this.sucursalId = sucursalId;
    }
}

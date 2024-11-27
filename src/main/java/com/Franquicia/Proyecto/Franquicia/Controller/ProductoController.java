package com.Franquicia.Proyecto.Franquicia.Controller;

import com.Franquicia.Proyecto.Franquicia.Dto.ProductoDto;
import com.Franquicia.Proyecto.Franquicia.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")

public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity<String>guardarProducto(@RequestBody ProductoDto producto){
        productoService.guardarProducto(
                producto.getNombre(),
                producto.getCantidad(),
                producto.getPrecio(),
                producto.getNitSucursal()

        );
        return ResponseEntity.ok("Producto guardado con exito");
    }
}

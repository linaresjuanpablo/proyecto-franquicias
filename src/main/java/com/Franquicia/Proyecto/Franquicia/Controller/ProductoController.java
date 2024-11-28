package com.Franquicia.Proyecto.Franquicia.Controller;

import com.Franquicia.Proyecto.Franquicia.Dto.ProductoDto;
import com.Franquicia.Proyecto.Franquicia.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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


    @DeleteMapping("/eliminar")
    public ResponseEntity<String>eliminarProductoDeSucursal(@RequestBody Map<String, Long> request) {
        Long id = request.get("id");
        Long idSucursal = request.get("idSucursal");

        productoService.eliminarProducto(id, idSucursal);
        return ResponseEntity.ok("producto eliminado correctamente");
    }

}

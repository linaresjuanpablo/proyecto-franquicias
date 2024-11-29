package com.Franquicia.Proyecto.Franquicia.Controller;

import com.Franquicia.Proyecto.Franquicia.Dto.ProductoDto;
import com.Franquicia.Proyecto.Franquicia.Dto.StockProductoDto;
import com.Franquicia.Proyecto.Franquicia.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping("/{id}")
    public ResponseEntity<String>actualizarProducto(
            @PathVariable Long id,
            @RequestBody Map<String, String> body){
        try {
            //String id = body.get("id");
            String nombre = body.get("nombre");
            String cantidad = body.get("cantidad");
            String precio = body.get("precio");

            productoService.actualizarProducto(nombre, cantidad, precio, id);
            return ResponseEntity.ok("Stock modificado exitosamente");
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/mayor/{id}")
    public ResponseEntity<List<StockProductoDto>> obtenerProducto(
            @PathVariable Long id){
        List<StockProductoDto> productos = productoService.obtenerProductos(id);
        return ResponseEntity.ok(productos);
    }




}
